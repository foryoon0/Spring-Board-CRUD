package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.vo.Board;


public class BoardDao {

	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Board> mapper= new RowMapper<Board>() {//�͸� ���� ��ü

				@Override
				public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
						Board board = new Board(
								rs.getInt("qnaBoardNum"),
								rs.getString("qnaBoardTitle"),
								rs.getString("memberName"),
								rs.getTimestamp("qnaBoardRegdate"),
								rs.getInt("qnaBoardCount"));
					return board;
				}   
		
	};

	public BoardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
		
	public List<Board> selectAll() { 
			String sql = "SELECT b.*,m.* FROM boards b left outer join members m on b.memberNum = m.memberNum ORDER BY QNABOARDNUM DESC ";
			
			List<Board> list= jdbcTemplate.query(sql, (rs,rowNum)->{
					Board board = new Board(
						rs.getString("qnaBoardTitle"),
						rs.getString("memberName"),
						rs.getTimestamp("qnaBoardRegdate"),
						rs.getInt("qnaBoardCount"));
				board.setQnaBoardNum(rs.getInt("qnaBoardNum"));
			return board;
		});
			System.out.println("����Ʈ����");
			return list;
		
		}
}
	
	

