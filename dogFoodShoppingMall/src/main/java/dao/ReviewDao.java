package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReviewDao {
	
	public List<Map<String, Object>> selectReview(int productId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		String sql = "SELECT"
				+ " rp.name reviewPhotoName"
				+ ", p.member_id memberId"
				+ ", d.spiece spiece"
				+ ", r.title title"
				+ ", r.review_content reviewContent"
				+ ", r.create_date createDate"
				+ " FROM review r"
				+ "	JOIN purchase p"
				+ "	ON r.purchase_id = p.purchase_id"
				+ "		JOIN member_dog md"
				+ "		ON p.member_id = md.member_id"
				+ "			JOIN dog d"
				+ "			ON md.dog_id = d.dog_id"
				+ "				JOIN review_photo rp"
				+ "				ON r.review_id = rp.review_id"
				+ "					JOIN purchase_list pl"
				+ "					ON p.purchase_id = pl.purchase_id"
				+ " WHERE pl.product_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productId);
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("reviewPhotoName", rs.getString("reviewPhotoName"));
				map.put("memberId", rs.getString("memberId"));
				map.put("spiece", rs.getString("spiece"));
				map.put("title", rs.getString("title"));
				map.put("reviewContent", rs.getString("reviewContent"));
				map.put("createDate", rs.getString("createDate"));
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
