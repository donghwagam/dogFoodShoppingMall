package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import vo.Notice;

public class NoticeDao {
	// 공지사항 리스트 출력하는 메서드
	public List<Notice> selectNoticeList() {
		List<Notice> list = new ArrayList<>();
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT notice_id noticeId"
				+ "			 , notice_title noticeTitle"
				+ "			 , notice_content noticeContent"
				+ "			 , create_date createDate"
				+ "			 , update_date updateDate"
				+ "	  FROM notice"
				+ "	  ORDER BY create_date DESC";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setCreateDate(rs.getString("createDate"));
				notice.setUpdateDate(rs.getString("updateDate"));
				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 공지사항 내용 출력하는 메서드
	public Notice selectContent(int noticeId) {
		
		Notice notice = new Notice();
		
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT notice_id noticeId, notice_title noticeTitle, notice_content noticeContent, create_date createDate, update_date updateDate"
				+ "		FROM notice"
				+ "		WHERE notice_id = ?"
				+ "		ORDER BY create_date DESC";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noticeId);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				notice.setNoticeId(rs.getInt("noticeId"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setCreateDate(rs.getString("createDate"));
				notice.setUpdateDate(rs.getString("updateDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return notice;
	}
		
	// 공지사항 입력하는 메서드
	public int insertNoitce(Notice notice) {
		
		int row = 0;
	
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO notice (notice_title, notice_content, create_date, update_date)\r\n"
				+ "		VALUES (?, ?, NOW(), NOW());";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, notice.getNoticeTitle());
			stmt.setString(2, notice.getNoticeContent());
			
			row = stmt.executeUpdate();
			if(row != 1) {
				System.out.println("insertNotice 입력 실패");
			} else {
				System.out.println("insertNotice 입력 성공");
			}
			
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
	
	// 공지사항 수정하는 메서드
	public int updateNotice(Notice notice) {
		
		int row = 0;
		
		// 자원준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "UPDATE notice SET notice_title=?, notice_content=?, update_date=NOW() WHERE notice_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB연결
	
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, notice.getNoticeTitle());
			stmt.setString(2, notice.getNoticeContent());
			stmt.setInt(3, notice.getNoticeId());
			
			row = stmt.executeUpdate();
			if(row != 1) {
				System.out.println("공지사항 수정 실패");
			} else {
				System.out.println("공지사항 수정 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return row;

	}
	
	public int deleteNotice(Notice notice) {
		
		int row = 0;
		
		// 자원준비
		Connection conn = null;
		PreparedStatement stmt = null;
				
		String sql = "DELETE FROM notice WHERE notice_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");// DB연결
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, notice.getNoticeId());
			
			row = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return row;
	}
}	
