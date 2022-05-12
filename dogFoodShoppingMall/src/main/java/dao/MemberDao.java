package dao;

import java.sql.*;
import java.util.*;

import vo.Member;

public class MemberDao {
	
	public int updateMemberPw(Member member) { // 비밀번호 변경
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		
		String sql = "UPDATE member SET member_pw=PASSWORD(?)"
				+ " WHERE member_id=? AND phone=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			stmt.setString(3, member.getPhone());
			row = stmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row;
	}
	
	
	public String searchMemberPw(Member member) { // 비밀번호 찾기
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String memberPw = null;
		
		String sql = "SELECT member_pw memberPw"
				+ " FROM member"
				+ " WHERE member_id=? And name=? AND phone=?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPhone());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				memberPw = rs.getString("memberPw");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberPw;
		
	}
	
	
	
	public String searchMemberId(Member member) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String memberId = null;
		
		String sql = "SELECT member_id memberId"
						+ " FROM member"
						+ " WHERE name=? AND phone=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getPhone());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				memberId = rs.getString("memberId");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return memberId;
	}
	
	
	public void insertMember(Member member) { // 회원가입 메서드
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO member (member_id, member_pw, name, birth, phone, email, gender, address_id, detail_addr, create_date, update_date)"
				+ " VALUES"
				+ " (?, PASSWORD(?), ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.setString(3, member.getName());
			stmt.setString(4, member.getBirth());
			stmt.setString(5, member.getPhone());
			stmt.setString(6, member.getEmail());
			stmt.setString(7, member.getGender());
			stmt.setInt(8, member.getAddressId());
			stmt.setString(9, member.getDetailAddr());
			
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	public String selectMemberByIdPw(Member member) { // 로그인 유효성 검사 메서드
		String memberId = null; // 변수 memberId 생성
		
		// DB연결을 위한 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 쿼리 작성
		String sql = "SELECT member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // sql문 전송
			stmt.setString(1, member.getMemberId()); // ? 값에 memberId 값 넣어주기
			stmt.setString(2, member.getMemberPw()); // ? 값에 memberPw 값 넣어주기
			
			rs = stmt.executeQuery(); // select한 값 rs에 저장
			
			if(rs.next()) { // rs에 정보가 있을때, memberId에 값 저장
				memberId = rs.getString("memberId"); // 반환해줄 변수에 값 저장
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberId; // 리턴값
	}
}
