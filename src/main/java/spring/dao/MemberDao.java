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
	
	
	//이메일 선택
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
	
	
	//////////////////////////////////////////// 
	//회원가입 기능
	public void insert(Member newMember) {
			
			int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
								// 미완성의 쿼리를 수동으로 완성시키는 기능
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement psmt = con.prepareStatement(
								"INSERT INTO members VALUES(members_seq.nextval,?,?,?,?,?)");
					
						psmt.setString(1,newMember.getMemberId());
						psmt.setString(2,newMember.getMemberPassword());
						psmt.setString(3,newMember.getMemberName());
						psmt.setString(4,newMember.getMemberEmail());
						psmt.setString(5,newMember.getMemberPhone());
					
					return psmt;
				}
			});
			System.out.println("INSERT로 삽입된 데이터의 개수 : "+cnt);
		}
	
	
		////////////////////////////////////////////////////////////////////////////////////////////
		//로그인 기능 아이디를 통해서 조회하기
		public Member selectById(String memberId) {
		
		List<Member> list= jdbcTemplate.query("SELECT * FROM members WHERE memberId=?", new RowMapper<Member>() {

							@Override
							public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
										Member member = new Member(
												rs.getString("memberPassword"),
												rs.getString("memberName"),
												rs.getString("memberEmail"),
												rs.getString("memberPhone"));
										member.setMemberId(rs.getString("memberId"));
									return member;
							}} ,memberId);
		
		return list.isEmpty()?null:list.get(0);
	}
		
		
	///////////////////////////////////////////////////////////
	//selectByName 회원정보 디테일 읽어오기
		public Member selectByName(String memberName) {
			
			List<Member> list= jdbcTemplate.query("SELECT * FROM members WHERE memberName=?", new RowMapper<Member>() {
							@Override
								public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
											Member member = new Member(
													rs.getInt("memberNum"),
													rs.getString("memberId"),
													rs.getString("memberName"),
													rs.getString("memberEmail"),
													rs.getString("memberPhone")); 
											member.setMemberName(rs.getString("memberName"));
										return member;
								}} ,memberName);
			
			return list.isEmpty()?null:list.get(0);
		}	
		
		
	}