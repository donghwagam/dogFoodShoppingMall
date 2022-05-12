package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketDao {
   
   // 장바구니에 상품이 담겼을 때 리스트를 출력하기 위한 메서드
	public List<Map<String, Object>> selectBasketList(int productId){
		List<Map<String, Object>> list = new ArrayList<>();
		
		//드라이버 자원 준비 
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT p.product_id productId, pp.name photoName, p.name productName, p.gram, p.price"
				+ "		FROM product p"
				+ "  	 	LEFT JOIN product_photo pp"
				+ "   			ON p.product_id = pp.product_id"
				+ "		WHERE p.product_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("productId", rs.getInt("productId"));
				m.put("photoName", rs.getString("photoName"));
				m.put("productName", rs.getString("productName"));
				m.put("gram", rs.getInt("gram"));
				m.put("price", rs.getInt("price"));
				list.add(m);
			}
		} catch (Exception e) {
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