package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.GuestBasket;
import vo.MemberBasket;

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
				+ "  	LEFT JOIN product_photo pp"
				+ "   		ON p.product_id = pp.product_id"
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
	
	// 장바구니테이블에 정보 넣기 위한 메서드
	public void insertBasket(int productId, String memberId, int quantity){

		//드라이버 자원 준비 
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql ="INSERT INTO basket VALUES(?,?,?,NOW(), NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			stmt.setString(2, memberId);
			stmt.setInt(3, quantity);
			
			// 입력 성공, 실패 확인할 변수 
			int row = stmt.executeUpdate();
			
			if(row != 1) {
				System.out.println("insertBasket() 입력 실패");
			} else {		
				System.out.println("insertBasket() 입력 성공");
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
	}
	
	//장바구니에 들어있는 상품의 정보와 수량 모두 들고오기 위한 메서드
	public List<MemberBasket> selectMemberBasketList(String memberId) {
		List<MemberBasket> list = new ArrayList<>();
		
		//드라이버 자원 준비 
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql ="SELECT "
				+ "		p.product_id productId"
				+ "		, p.name productName"
				+ "		, p.price"
				+ "		, p.gram"
				+ "		, pp.name photoName"
				+ "		, b.quantity"
				+ " FROM product p"
				+ " LEFT JOIN product_photo pp"
				+ "		ON p.product_id = pp.product_id"
				+ "	LEFT JOIN basket b"
				+ "		ON p.product_id = b.product_id"
				+ " WHERE member_id = ?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			while(rs.next()) {
				MemberBasket memberBasket = new MemberBasket();
				memberBasket.setProductId(rs.getInt("productId"));
				memberBasket.setPhotoName(rs.getString("photoName"));
				memberBasket.setPrice(rs.getInt("price"));
				memberBasket.setGram(rs.getInt("gram"));
				memberBasket.setProductName(rs.getString("productName"));
				memberBasket.setQuantity(rs.getInt("quantity"));
				list.add(memberBasket);
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
	
	// 장바구니 수량 변경하기 위한 메서드
	public void updateBasket(int productId, String memberId, int quantity) {
		//드라이버 자원 준비 
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql ="UPDATE basket SET quantity = quantity+? WHERE product_id = ? AND member_id= ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quantity);
			stmt.setInt(2, productId);
			stmt.setString(3, memberId);
			
			// 수정 성공, 실패 확인할 변수 
			int row = stmt.executeUpdate();
			
			if(row != 1) {
				System.out.println("updateBasket() 입력 실패");
			}
			System.out.println("updateBasket() 입력 성공");
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//장바구니 삭제 하기 위한 메서드
	public void deleteBasket(int productId, String memberId) {
		//드라이버 자원 준비 
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql ="DELETE FROM basket WHERE product_id = ? AND member_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			stmt.setString(2, memberId);
			
			// 삭제 성공, 실패 확인할 변수 
			int row = stmt.executeUpdate();
			
			if(row != 1) {
				System.out.println("deleteBasket() 입력 실패");
			}
			System.out.println("deleteBasket() 입력 성공");
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}