package spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.vo.Board;


public class BoardDao {

	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Board> mapper= new RowMapper<Board>() {//익명 구현 객체

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
			String sql = "SELECT b.qnaBoardTitle, m.memberName, b.qnaBoardRegdate, b.qnaBoardCount FROM BOARDS B, MEMBERS M WHERE B.memberNum = M.memberNum ORDER BY QNABOARDNUM DESC";
			

			
			List<Board> list= jdbcTemplate.query(sql, mapper);
			
			return list;
		}
		
		}
	
	

