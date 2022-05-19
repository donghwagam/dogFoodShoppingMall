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

public class PurchaseDao {
	
	// 사용자가 구매한 상품 수량만큼 재고 수량 빼주는 메서드
	public int updateStockByProduct(int stock, int quantity, int productId) {
		int row = 0; // executeUpdate() 반환값 담을 변수
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 재고 업데이트 쿼리
		String sql = "UPDATE product"
				+ "   SET stock = ? - ?"
				+ "   WHERE product_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 작성
			stmt.setInt(1, stock);
			stmt.setInt(2, quantity);
			stmt.setInt(3, productId);
			// update 쿼리 실행 -> 성공 : 1 / 실패 : 2 반환
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
	
	// 사용자가 구매한 상품의 재고 출력하는 메서드
	public int selectStockByProduct(int productId) {
		int stock = 0; // 사용자가 구매한 상품의 재고량 받아줄 변수 선언
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 사용자가 구매한 상품의 재고량 출력하는 쿼리
		String sql = "SELECT stock"
				+ "   FROM product"
				+ "   WHERE product_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			stmt.setInt(1, productId); // ?에 정보 작성
			rs = stmt.executeQuery(); // 쿼리 실행 후 나온 정보 rs에 담기
			
			if(rs.next()) { // rs에 정보가 있으면
				stock = rs.getInt("stock"); // 재고량 저장
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
		
		return stock;
	}
	
	// 구매목록 DB에 저장하는 메서드
	public int insertPurchaseByProduct(Map<String, Object> map) {
		int row = 0; // executeUpdate() 반환값 담을 변수
		int purchaseId = 0; // 주문번호
		// 자원 준비
		Connection conn = null;
		PreparedStatement purchaseStmt = null;
		PreparedStatement purchaseListStmt = null;
		PreparedStatement purchaseAddressStmt = null;
		ResultSet rs = null;
		
		// 구매 정보를 DB에 입력하는 쿼리
		String purchaseSql = "INSERT INTO purchase("
				+ " 			member_id"
				+ "				, payment"
				+ "				, total_price"
				+ "				, create_date"
				+ "				, update_date)"
				+ " 		  VALUES("
				+ "				?"
				+ "				, ?"
				+ "				, ?"
				+ "				, NOW()"
				+ "				, NOW())";
		
		// 구매한 상품의 종류와 수량 DB에 입력하는 쿼리
		String purchaseListSql = "INSERT INTO purchase_list("
				+ "					purchase_id"
				+ "					, product_id"
				+ "					, quantity"
				+ "					, update_date)"
				+ "				  VALUES("
				+ "					?"
				+ "					, ?"
				+ "					, ?"
				+ "					, NOW())";
		
		// 배송정보 DB에 입력하는 쿼리
		String purchaseAddressSql = "INSERT INTO purchase_address"
				+ "					 VALUES("
				+ "						?"
				+ "						, ?"
				+ "						, ?"
				+ "						, ?"
				+ "						, NOW())";
	
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			conn.setAutoCommit(false); // 오토커밋 off
			purchaseStmt = conn.prepareStatement(purchaseSql, PreparedStatement.RETURN_GENERATED_KEYS); // 쿼리 작성, insert한 키값 가져오는거 셋팅
			// ?에 정보 작성
			purchaseStmt.setString(1, (String)map.get("memberId"));
			purchaseStmt.setString(2, (String)map.get("payment"));
			purchaseStmt.setInt(3, (int)map.get("totalPriceByProduct"));
			purchaseStmt.executeUpdate(); // purchaseSql 쿼리 실행
			rs = purchaseStmt.getGeneratedKeys(); // purchaseSql의 키값 가져와서 rs에 저장
			
			if(rs.next()) { // rs에 정보가 있으면
				purchaseId = rs.getInt(1); // 키값 저장
			}
			
			purchaseListStmt = conn.prepareStatement(purchaseListSql); // 쿼리 작성
			// ?에 정보 작성
			purchaseListStmt.setInt(1, purchaseId);
			purchaseListStmt.setInt(2, (int)map.get("productId"));
			purchaseListStmt.setInt(3, (int)map.get("quantity"));
			row = purchaseListStmt.executeUpdate(); // purchaseListSql 쿼리 실행 -> 성공 1 / 실패 : 0 반환
			
			purchaseAddressStmt = conn.prepareStatement(purchaseAddressSql);
			purchaseAddressStmt.setInt(1, purchaseId);
			purchaseAddressStmt.setString(2, (String)map.get("purchaseName"));
			purchaseAddressStmt.setString(3, (String)map.get("purchasePhone"));
			purchaseAddressStmt.setString(4, (String)map.get("address"));
			purchaseAddressStmt.executeUpdate();
			
			conn.commit(); // 커밋
		} catch (SQLException e) {
			try {
				conn.rollback(); // 실패하면 rollback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	
	// 구매한 상품의 정보 가져오는 메서드
	public Map<String, Object> selectPurchaseByProduct(int productId, int quantity) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 쿼리로 나오는 정보 받을 map 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 구매한 상품의 정보가 나오는 쿼리
		String sql = "SELECT pp.name photoName, p.name productName, p.price price"
				+ " FROM product p JOIN product_photo pp"
				+ " ON p.product_id = pp.product_id"
				+ " WHERE p.product_id=?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리작성
			stmt.setInt(1, productId); // ?에 정보 작성
			rs = stmt.executeQuery(); // 쿼리 실행 후 나오는 정보 rs에 저장
			
			if(rs.next()) { // rs에 정보가 있으면
				// map에 정보 저장
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
	
	// 구매내역을 위한 메서드
	   public List<Map<String, Object>> selectPurchaseMemberListByPage(String memberId) {
	      List<Map<String, Object>> list = new ArrayList<>();
	      
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT pr.product_id productId, p.purchase_id purchaseId, pp.original_name originalName, pr.name, pr.gram/1000 gram, pr.price, pl.quantity, p.status, pr.price*pl.quantity totalPrice"
	            + "      FROM purchase p"
	            + "      JOIN purchase_list pl"
	            + "         ON p.purchase_id = pl.purchase_id"
	            + "      JOIN product pr"
	            + "         ON pl.product_id = pr.product_id"
	            + "      JOIN product_photo pp"
	            + "         ON pr.product_id = pp.product_id"
	            + "      WHERE p.member_id =?";
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, memberId);
	         rs = stmt.executeQuery();
	         
	         while(rs.next()) {
	            Map<String, Object> map = new HashMap<>();
	            map.put("productId", rs.getInt("productId"));
	            map.put("purchaseId", rs.getInt("purchaseId"));
	            map.put("originalName", rs.getString("originalName"));
	            map.put("name", rs.getString("name"));
	            map.put("gram", rs.getDouble("gram"));
	            map.put("price", rs.getInt("price"));
	            map.put("quantity", rs.getInt("quantity"));
	            map.put("status", rs.getString("status"));
	            map.put("totalPrice", rs.getInt("totalPrice"));
	            list.add(map);
	            
	            
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
