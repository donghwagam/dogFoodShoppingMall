package dao;

import java.sql.*;
import java.util.*;

import vo.Member;

public class MemberDao {
	
	// 비밀번호 변경 메서드
	public int updateMemberPw(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0; // 반환값으로 이용할 row 선언
		
		// 비밀번호를 업데이트 하는 쿼리 저장
		String sql = "UPDATE member SET member_pw=PASSWORD(?)"
				+ " WHERE member_id=? AND phone=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			
			// ?에 정보 입력
			stmt.setString(1, member.getMemberPw()); // 바꿀 비밀번호
			stmt.setString(2, member.getMemberId()); // 아이디
			stmt.setString(3, member.getPhone()); // 휴대폰번호
			row = stmt.executeUpdate(); // 쿼리 실행 후 row에 반환 값 저장
		} 
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row; // 업데이트가 성공했으면 1을 반환 실패했으면 0을 반환 
	}
	
	// DB에 저장된 비밀번호 찾기
	public String searchMemberPw(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String memberPw = null; // 쿼리문에서 가져올 비밀번호를 저장할 변수 선언
		
		// DB에 저장된 비밀번호 가져오는 쿼리
		String sql = "SELECT member_pw memberPw"
				+ " FROM member"
				+ " WHERE member_id=? And name=? AND phone=?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			stmt.setString(1, member.getMemberId()); // 아이디
			stmt.setString(2, member.getName()); // 이름
			stmt.setString(3, member.getPhone()); // 핸드폰번호
			
			rs = stmt.executeQuery(); // 쿼리로 받아온 정보 ResultSet형식으로 저장
			
			if(rs.next()) { // rs에 정보가 있다면
				memberPw = rs.getString("memberPw"); // rs에 있는 정보 memberPw 변수에 저장
			}
			
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberPw; // 받아온 비밀번호 반환
		
	}
	
	// 아이디 찾기 메서드
	public String searchMemberId(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String memberId = null; // 쿼리문에서 찾아올 아이디를 저장한 변수 선언
		
		// 아이디를 찾아올 쿼리 저장
		String sql = "SELECT member_id memberId"
						+ " FROM member"
						+ " WHERE name=? AND phone=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			stmt.setString(1, member.getName()); // 이름
			stmt.setString(2, member.getPhone()); // 핸드폰번호
			
			rs = stmt.executeQuery(); // 쿼리문으로 받아온 정보 ResultSet형식으로 저장
			
			if(rs.next()) { // rs에 저장된 정보가 있다면
				memberId = rs.getString("memberId"); // 쿼리문에서 찾아온 아이디 저장
			}
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberId; // 아이디값 반환
	}
	
	// 회원가입 메서드
	public void insertMember(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 회원가입을 해줄 쿼리문 작성
		String sql = "INSERT INTO member (member_id, member_pw, name, birth, phone, email, gender, address_id, detail_addr, create_date, update_date)"
				+ " VALUES"
				+ " (?, PASSWORD(?), ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			stmt.setString(1, member.getMemberId()); // 아이디
			stmt.setString(2, member.getMemberPw()); // 비밀번호
			stmt.setString(3, member.getName()); // 이름
			stmt.setString(4, member.getBirth()); // 생년월일
			stmt.setString(5, member.getPhone()); // 핸드폰번호
			stmt.setString(6, member.getEmail()); // 이메일
			stmt.setString(7, member.getGender()); // 성별
			stmt.setInt(8, member.getAddressId()); // 주소
			stmt.setString(9, member.getDetailAddr()); // 상세주소
			stmt.executeUpdate(); // 쿼리 실행
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 로그인 유효성 검사 메서드
	public String selectMemberByIdPw(Member member) {
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
		}
		// 예외 처리
		catch (Exception e) {
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
