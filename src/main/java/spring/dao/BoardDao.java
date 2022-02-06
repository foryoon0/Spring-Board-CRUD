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
import spring.vo.Member;

public class BoardDao {

	private JdbcTemplate jdbcTemplate;

	private RowMapper<Board> mapper = new RowMapper<Board>() {// 익명 구현 객체

		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			Board board = new Board(rs.getInt("qnaBoardNum"), rs.getString("qnaBoardTitle"), rs.getString("memberName"),
					rs.getTimestamp("qnaBoardRegdate"), rs.getInt("qnaBoardCount"));
			return board;
		}

	};

	public BoardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Board> selectAll() {
		String sql = "SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum ORDER BY QNABOARDNUM DESC ";

		List<Board> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Board board = new Board(rs.getString("qnaBoardTitle"), rs.getString("memberName"),
					rs.getTimestamp("qnaBoardRegdate"), rs.getInt("qnaBoardCount"));
			board.setQnaBoardNum(rs.getInt("qnaBoardNum"));
			return board;
		});
		System.out.println("리스트최종");
		return list;

	}

	////////////////////////////////////////////////////
	// BoardNum 통해서 게시물 내용 읽어오기 selectByqnaBoardNum
	public Board selectByqnaBoardNum(int qnaBoardNum) {

		List<Board> list = jdbcTemplate.query(
				"SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum WHERE qnaBoardNum=?",
				new RowMapper<Board>() {

					@Override
					public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board board = new Board(rs.getString("qnaBoardTitle"), rs.getTimestamp("qnaBoardRegdate"),
								rs.getString("memberName"), rs.getInt("qnaBoardCount"),
								rs.getString("qnaBoardContent"));
						board.setQnaBoardNum(rs.getInt("qnaBoardNum"));
						return board;
					}
				}, qnaBoardNum);
		return list.isEmpty() ? null : list.get(0);

	}

	//////////////////////////////////////////////////////////////////////////
	// selectByName name을 통해 memberNum 가져오기////////////////////////////////////////////
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
		System.out.println("이름 가져오기");
		return list.isEmpty()?null:list.get(0);

	}

	/////////////////////////////////////////////////////////////////
	//새로운 게시물 등록
	public void insert(Board newBoard) {

		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
	
			
			
	// 미완성의 쿼리를 수동으로 완성시키는 기능
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con
						.prepareStatement("INSERT INTO boards VALUES(boards_seq.nextval,?,?,?,?,?)");


				return psmt;
			}
		});
		System.out.println("INSERT로 삽입된 데이터의 개수 : " + cnt);
	}

}
