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

public class MemberDao {

private JdbcTemplate jdbcTemplate;
	
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//�̸��� ����
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
	//회원가입
	public void insert(Member newMember) {
			
			int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
								// �̿ϼ��� ������ �������� �ϼ���Ű�� ���
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
			System.out.println("INSERT�� ���Ե� �������� ���� : "+cnt);
		}
	
	
		////////////////////////////////////////////////////////////////////////////////////////////
		// id를 통해 조회 멤버 디테일 정보 읽어오기
		public Member selectById(String memberId) {
		
		List<Member> list= jdbcTemplate.query("SELECT * FROM members WHERE memberId=?", new RowMapper<Member>() {

							@Override
							public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
										Member member = new Member(
												rs.getInt("memberNum"),
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
	//selectByName 
		public Member selectByName(String memberName) {
			
			List<Member> list= jdbcTemplate.query("SELECT * FROM members WHERE memberName=?", new RowMapper<Member>() {
							@Override
								public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
											Member member = new Member(
													rs.getInt("memberNum"),
													rs.getString("memberId"),
													rs.getString("memberPassword"),
													rs.getString("memberName"),
													rs.getString("memberEmail"),
													rs.getString("memberPhone")); 
											member.setMemberName(rs.getString("memberName"));
										return member;
								}} ,memberName);
			
			return list.isEmpty()?null:list.get(0);
		}	
		
	//////////////////////////////////////////////////////////////////
	///////////////멤버 리스트 가져오는 메소드
			
		public List<Member> selectAll() {
				String sql = "SELECT * from members";
	
				List<Member> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
					Member member = new Member(rs.getInt("memberNum"), 
											rs.getString("memberId"),
											rs.getString("memberName"));
						member.setMemberNum(rs.getInt("memberNum"));
					return member;
				});
				
				return list;
	
			}
////////////////////////////////////////////////////////////////////////
/// 게시글 수정 메소드 edit

		public void edit(Member member) {
		
		int cnt = jdbcTemplate.update(new PreparedStatementCreator() {
		
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		PreparedStatement psmt = con.prepareStatement(
		"UPDATE members SET memberId = ?, memberName = ? , memberEmail = ?, memberPhone = ? WHERE memberNum = ?");
		
		
		psmt.setString(1,member.getMemberId());
		psmt.setString(2,member.getMemberName());
		psmt.setString(3,member.getMemberEmail());
		psmt.setString(4,member.getMemberPhone());
		psmt.setInt(5,member.getMemberNum());
		
		
		return psmt;
		}
		});
		
		System.out.println("멤버 데이트갯수 :" + cnt);
		}
		
	}