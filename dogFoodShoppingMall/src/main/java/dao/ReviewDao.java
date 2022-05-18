package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReviewDao {
	
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
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
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
				+ " , p.member_id memberId\r\n"
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
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
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
