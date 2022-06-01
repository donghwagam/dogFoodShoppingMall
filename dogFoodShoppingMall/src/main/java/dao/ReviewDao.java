package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReviewDao {
	
	// review count 메서드
	public int selectCountReview(int productId) {
		
		int cnt = 0; 
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) cnt"
				+ " FROM review"
				+ " WHERE product_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();

			if(rs.next()) {
				cnt = rs.getInt(1);
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
		
		return cnt;
	}
	
	
	// 결제 정보 받아오는 메서드(결제전, 결제완료, 배송완료) -> 배송완료 된 후 리뷰작성 해야해서 확인
	public String selectStatus(int purchaseId) {
		
		String status = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT status"
				+ " FROM purchase"
				+ " WHERE purchase_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, purchaseId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				status = rs.getString("status");
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
		
		
		
		return status;
	}
	
	// 리뷰 작성 여부 확인하는 메서드(cnt 1 반환시 리뷰 이미 작성, cnt 0 반환시 리뷰 미작성)
	public int checkInsertReview(Map<String, Object> map) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		String sql = "SELECT COUNT(*) FROM review"
				+ " WHERE purchase_id = ? AND product_id = ?";
				
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, (int)(map.get("purchaseId")));
			stmt.setInt(2, (int)(map.get("productId")));
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		
		
		
		return cnt;
		
	}
	
	// 상품 리뷰 입력하는 메서드
	public int insertReview(Map<String, Object> map){
		
		int row = 0;
		int reviewId = 0;
		
		Connection conn = null;
		PreparedStatement reviewStmt = null;
		PreparedStatement reviewPhotoStmt = null;
		ResultSet rs = null;
		
		// 상품 구매 후 리뷰 등록
		String reviewSql = "INSERT INTO review" 
				+ " (purchase_id"
				+ " , product_id"
				+ " , title"
				+ " , review_content"
				+ " , star"
				+ " , create_date)"
				+ " VALUES"
				+ " (?, ?, ?, ?, ?, NOW())";
		// 리뷰 사진 등록
		String photoReviewSql = "INSERT INTO review_photo"
				+ " (original_name"
				+ " , name"
				+ " , type"
				+ " , review_id)"
				+ " VALUES(?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			conn.setAutoCommit(false); // 오토커밋 off
			reviewStmt = conn.prepareStatement(reviewSql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			reviewStmt.setInt(1, (int)map.get("purchaseId"));
			reviewStmt.setInt(2, (int)map.get("productId"));
			reviewStmt.setString(3, (String)map.get("title"));
			reviewStmt.setString(4, (String)map.get("reviewContent"));
			reviewStmt.setInt(5, (int)map.get("star"));
			reviewStmt.executeUpdate();
			
			rs = reviewStmt.getGeneratedKeys();
			
			if(rs.next()) {
				reviewId = rs.getInt(1);
			}
			
			reviewPhotoStmt = conn.prepareStatement(photoReviewSql);
			
			reviewPhotoStmt.setString(1, (String)map.get("originalName"));
			reviewPhotoStmt.setString(2, (String)map.get("photoName"));
			reviewPhotoStmt.setString(3, (String)map.get("photoType"));
			reviewPhotoStmt.setInt(4, reviewId);
			reviewPhotoStmt.executeUpdate();
			
			conn.commit();
			
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
	
	// 상품 리뷰 평점 가져오는 메서드
	public double selectStarAverage(int productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		double star = 0.0;
		
		String sql = "SELECT"
				+ " product_id productId"
				+ " , ROUND( AVG(star), 1) star"
				+ " FROM review"
				+ " WHERE product_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				star = rs.getDouble("star");
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
		
		return star;
	}
	
	
	// 구매자들이 쓴 리뷰 목록 가져오는 메서드
	public List<Map<String, Object>> selectReview(int productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		String sql = "SELECT"
				+ " rp.name reviewPhotoName"
				+ " , p.member_id memberId"
				+ " , IFNULL(d.spiece, '미등록') spiece"
				+ " , r.title title\r\n"
				+ " , r.review_content reviewContent"
				+ " , r.star star"
				+ " , r.create_date createDate"
				+ " FROM review r"
				+ " JOIN review_photo rp"
				+ " ON r.review_id = rp.review_id"
				+ " JOIN purchase p"
				+ " ON p.purchase_id = r.purchase_id"
				+ " JOIN member m"
				+ " ON m.member_id = p.member_id"
				+ " LEFT JOIN member_dog md"
				+ " ON m.member_id = md.member_id"
				+ " LEFT JOIN dog d"
				+ " ON md.dog_id = d.dog_id"
				+ " WHERE r.product_id = ?"
				+ " ORDER BY r.create_date DESC";
				
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productId);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("reviewPhotoName", rs.getString("reviewPhotoName")); // 리뷰사진
				map.put("memberId", rs.getString("memberId")); // 리뷰작성 고객 ID
				map.put("spiece", rs.getString("spiece")); // 리뷰작성 고객의 견종
				map.put("title", rs.getString("title")); // 리뷰 title
				map.put("reviewContent", rs.getString("reviewContent")); // 리뷰 content
				map.put("star", rs.getString("star")); // 리뷰 평점
				map.put("createDate", rs.getString("createDate")); // 리뷰 작성일자
				list.add(map);
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
}
