package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PurchaseDao {
	public Map<String, Object> selectPurchaseByProductOne(int productId, int quantity) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = "SELECT pp.name photoName, p.name productName, p.price price"
				+ " FROM product p JOIN product_photo pp"
				+ " ON p.product_id = pp.product_id"
				+ " WHERE p.product_id=?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, productId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				map.put("photoName", rs.getString("photoName"));
				map.put("productName", rs.getString("productName"));
				map.put("price", rs.getInt("price"));
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
		
		return map; 
		
	}

}
