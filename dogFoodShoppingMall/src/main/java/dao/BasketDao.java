package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.GuestBasket;

public class BasketDao {
   
   // 장바구니에 상품을 담기위해 상품 정보를 들고오기 위한 메서드
	public GuestBasket selectGuestBasketList(int productId){
		GuestBasket guestBasket= new GuestBasket();
		
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
				guestBasket.setProductId(rs.getInt("productId"));
				guestBasket.setPhotoName(rs.getString("photoName"));
				guestBasket.setProductName(rs.getString("productName"));
				guestBasket.setGram(rs.getInt("gram"));
				guestBasket.setPrice(rs.getInt("price"));
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
		return guestBasket;
	}

}