package spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import spring.vo.Member;

public class MemberDao {

private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Member selectByEmail(String email) {

		List<Member> list= jdbcTemplate.query("SELECT * FROM members WHERE memberEmail=?", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member member = new Member(
								rs.getString("memberEmail"),
								rs.getString("memberPassword"),
								rs.getString("memberName"));
					return member;
			}} ,email);

		return list.isEmpty()?null:list.get(0);
	}

	public void insert(Member newMember) {
			
			int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
								// �̿ϼ��� ������ �������� �ϼ���Ű�� ���
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement psmt = con.prepareStatement(
								"INSERT INTO members VALUES(members_seq.nextval,?,?,?,?,?)");
					
						psmt.setString(1,newMember.getMemberId());
						psmt.setString(2,newMember.getMemberName());
						psmt.setString(3,newMember.getMemberPassword());
						psmt.setString(4,newMember.getMemberEmail());
						psmt.setString(5,newMember.getMemberPhone());
					
					return psmt;
				}
			});
			System.out.println("INSERT�� ���Ե� �������� ���� : "+cnt);
		}
		
	}