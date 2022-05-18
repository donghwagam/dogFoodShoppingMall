package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PurchaseDao {
	public int updateStockByProduct(int stock, int quantity, int productId) {
		int row = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "UPDATE product"
				+ "   SET stock = ? - ?"
				+ "   WHERE product_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, stock);
			stmt.setInt(2, quantity);
			stmt.setInt(3, productId);
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
	
	public int selectStockByProduct(int productId) {
		int stock = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT stock"
				+ "   FROM product"
				+ "   WHERE product_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				stock = rs.getInt("stock");
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
	
	public int insertPurchaseByProduct(Map<String, Object> map) {
		int row = 0;
		int purchaseId = 0;
		Connection conn = null;
		PreparedStatement purchaseStmt = null;
		PreparedStatement purchaseListStmt = null;
		ResultSet rs = null;
		
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
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			conn.setAutoCommit(false);
			purchaseStmt = conn.prepareStatement(purchaseSql, PreparedStatement.RETURN_GENERATED_KEYS);
			purchaseStmt.setString(1, (String)map.get("memberId"));
			purchaseStmt.setString(2, (String)map.get("payment"));
			purchaseStmt.setInt(3, (int)map.get("totalPriceByProduct"));
			purchaseStmt.executeUpdate();
			rs = purchaseStmt.getGeneratedKeys();
			
			if(rs.next()) {
				purchaseId = rs.getInt(1);
			}
			
			purchaseListStmt = conn.prepareStatement(purchaseListSql);
			purchaseListStmt.setInt(1, purchaseId);
			purchaseListStmt.setInt(2, (int)map.get("productId"));
			purchaseListStmt.setInt(3, (int)map.get("quantity"));
			row = purchaseListStmt.executeUpdate();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
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
