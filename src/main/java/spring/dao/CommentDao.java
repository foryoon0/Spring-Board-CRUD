package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import spring.vo.Board;
import spring.vo.Comment;

public class CommentDao {

	private JdbcTemplate jdbcTemplate;

	public CommentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

	private RowMapper<Comment> mapper = new RowMapper<Comment>() {// �͸� ���� ��ü

		@Override
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment comment = new Comment(rs.getInt("commentNum"), 
											rs.getInt("qnaBoardNum"), 
											rs.getString("commentContent"),
											rs.getTimestamp("commentRegdate"));
						return comment;
		}

	};


	////////////////////////////////////////////////////
	// 답글 내용 읽어오기
	public Comment selectByqnaBoardNum(int qnaBoardNum) {

		List<Comment> list = jdbcTemplate.query(
				"SELECT * FROM comments WHERE qnaBoardNum = ?",
				new RowMapper<Comment>() {

					@Override
					public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
						Comment comment = new Comment(
								rs.getString("commentContent"), 
								rs.getTimestamp("commentRegdate"),
								rs.getInt("commentNum"));
							comment.setQnaBoardNum(rs.getInt("qnaBoardNum"));
						return comment;
					}
				}, qnaBoardNum);
		
		return list.isEmpty() ? null : list.get(0);

	}
	///////////////////////////////////////////////////////////////////////////////////////
	////////////////댓글등록
	

	public void update(Comment comment) {
		
			int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
			
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement psmt = con.prepareStatement(
						"INSERT INTO comments VALUES(comments_seq.NEXTVAL,?,?,sysdate)");

					psmt.setInt(1,comment.getQnaBoardNum());
					psmt.setString(2,comment.getCommentContent());
					
				return psmt;
			}
		});
		
		System.out.println("게시글 업데이트갯수 :" + cnt);
	}
	///////////////////////////////////////////////////////////////////////////////
	/////////////게시물 관리자 삭제 deletePostByqnaBoardNum
	public void deletePostByqnaBoardNum(int qnaBoardNum) {
		String sql = "DELETE FROM comments WHERE qnaBoardNum = ?";
		
		jdbcTemplate.update(sql,qnaBoardNum);
		

		System.out.println("삭제완료");
	}
	
	/////////////////////////////////////////////////////////////////
	//selectCommentNum
	
	public List<Comment> selectCommentNum() {
		String sql = "SELECT * FROM comments";

		List<Comment> list2 = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Comment comment = new Comment(
					rs.getInt("qnaBoardNum"));
			comment.setQnaBoardNum(rs.getInt("qnaBoardNum"));
			return comment;
		});
		
		return list2;

	}
}
