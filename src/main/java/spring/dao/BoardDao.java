package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import spring.vo.Board;

public class BoardDao {

	private JdbcTemplate jdbcTemplate;
	
	public BoardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	private RowMapper<Board> mapper = new RowMapper<Board>() {// �͸� ���� ��ü

		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			Board board = new Board(rs.getInt("qnaBoardNum"), rs.getString("qnaBoardTitle"), rs.getString("memberName"),
					rs.getTimestamp("qnaBoardRegdate"), rs.getInt("qnaBoardCount"));
			return board;
		}

	};

	
	public List<Board> selectAll() {
		String sql = "SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum ORDER BY QNABOARDNUM DESC ";

		List<Board> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Board board = new Board(rs.getString("qnaBoardTitle"), rs.getString("memberName"),
					rs.getTimestamp("qnaBoardRegdate"), rs.getInt("qnaBoardCount"));
			board.setQnaBoardNum(rs.getInt("qnaBoardNum"));
			return board;
		});
		
		return list;

	}

	////////////////////////////////////////////////////
	// BoardNum
	public Board selectByqnaBoardNum(int qnaBoardNum) {

		List<Board> list = jdbcTemplate.query(
				"SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum WHERE qnaBoardNum=?",
				new RowMapper<Board>() {

					@Override
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board board = new Board(
								rs.getInt("qnaBoardNum"), 
								rs.getString("qnaBoardTitle"), 
								rs.getTimestamp("qnaBoardRegdate"),
								rs.getString("memberName"), 
								rs.getInt("qnaBoardCount"),
								rs.getString("qnaBoardContent"));
						board.setQnaBoardNum(rs.getInt("qnaBoardNum"));
						return board;
					}
				}, qnaBoardNum);
		return list.isEmpty() ? null : list.get(0);

	}

	//////////////////////////////////////////////////////////////////////////
	// selectByName name을 통해 이름 조회 후 로그인!
	public Board selectByName(String memberName) {
		List<Board> list= jdbcTemplate.query(
				"SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum WHERE memberName=?",
				new RowMapper<Board>() {
			@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
							Board board = new Board(
									rs.getInt("memberNum"),
									rs.getString("memberName"));
								board.setMemberName(rs.getString("memberName"));
						return board;
				}} ,memberName);
		System.out.println("�̸� ��������");
		return list.isEmpty()?null:list.get(0);

	}

	/////////////////////////////////////////////////////////////////
	// 게시글 등록
	public void insert(Board newBoard) {

		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {

			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con.prepareStatement(
						"INSERT INTO boards VALUES(boards_seq.nextval,?,?,?,sysdate,0)");
					
					psmt.setInt(1,newBoard.getMemberNum());
					psmt.setString(2,newBoard.getQnaBoardTitle());
					psmt.setString(3,newBoard.getQnaBoardContent());
	

				return psmt;
			}
		});
		System.out.println("게시글 등록완료 ");
	}

	
	////////////////////////////////////////////////////////////////////////
	/// 게시글 삭제
	public void deletePostByCode(int qnaBoardNum) {
		String sql = "DELETE FROM boards WHERE qnaBoardNum = ?";
		
		jdbcTemplate.update(sql,qnaBoardNum);
		
//		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement psmt = con.prepareStatement(
//						"DELETE FROM boards WHERE qnaBoardNum = ?");
//				
//				psmt.setInt(1,qnaBoardNum);
//				
//				return psmt;
//			}
//		});

		System.out.println("삭제완료");
	}
	

	////////////////////////////////////////////////////////////////////////
	/// 게시글 수정 메소드 edit

	public void edit(Board board) {
		
			int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
			
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con.prepareStatement(
						"UPDATE boards SET qnaBoardTitle = ?, qnaBoardContent = ? WHERE qnaBoardNum = ?");
				
					
					psmt.setString(1,board.getQnaBoardTitle());
					psmt.setString(2,board.getQnaBoardContent());
					psmt.setInt(3,board.getQnaBoardNum());
	
					
				return psmt;
			}
		});
		
		System.out.println("게시글 업데이트갯수 :" + cnt);
	}
	
	
	
	//페이징 처리
	public int selectAllNumBoard() {
		
		String sql = "SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum";
		
		List<Board> cntAll = jdbcTemplate.query(sql, mapper);
		System.out.println("selectAllnum"+cntAll.size());
		return cntAll.size();
	}
	
	// 현재 페이지 정보(섹션번호, 페이지 번호) 현재 페이지 글목록읽어오기
	
	public List<Board> selectTargetBoard(int section, int pageNum){
	
		String sql = " SELECT * FROM "
				+ " (SELECT ROWNUM AS nick, QNABOARDTITLE, MEMBERNAME, QNABOARDREGDATE, QNABOARDCOUNT, QNABOARDNUM "  
				+ " FROM (SELECT b.QNABOARDTITLE, m.MEMBERNAME, b.QNABOARDREGDATE, b.QNABOARDCOUNT, b.QNABOARDNUM FROM BOARDS b JOIN MEMBERS m ON (b.MEMBERNUM = m.MEMBERNUM) ORDER BY b.QNABOARDNUM DESC)) "
				+ " WHERE nick BETWEEN (?-1)*50+(?-1)*5+1 AND (?-1)*50+(?)*5";
		
		List<Board> list = jdbcTemplate.query(sql, mapper, section, pageNum, section, pageNum);
		for(Board b : list) {
			System.out.println(b.getMemberName());
		}
		return list;
	}

	////////////////////////////////////////////////
	///카운트 증가 메서드
		public void updateCount(int qnaBoardNum) {
		
		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
		
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		PreparedStatement psmt = con.prepareStatement(
		"UPDATE boards SET qnaBoardCount = NVL(TO_NUMBER(qnaBoardCount),0)+1 WHERE QNABOARDNUM = ?");
		
			psmt.setInt(1,qnaBoardNum);
		
			return psmt;
			}
			});
		System.out.println("조회수 증가");
		}

	
}
