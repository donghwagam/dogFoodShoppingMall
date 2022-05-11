package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import vo.Address;

public class AddressDao {
	
	public List<Map<String, Object>> searchAddress(String searchAddress) {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT address_id addressId, CONCAT('(', zip_code, ') ', province, ' ', city, ' ', town, ' ', street, ' ', building1, '-', building2, ' ') addr"
				+ " FROM address"
				+ " WHERE CONCAT('(', zip_code, ') ', province, ' ', city, ' ', town, ' ', street, ' ', building1, '-', building2, ' ')"
				+ " LIKE ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%"+searchAddress+"%");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("addressId", rs.getInt("addressId"));
				map.put("addr", rs.getString("addr"));
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
	
	public List<Map<String, Object>> selectAddress() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT address_id addressId, CONCAT('(', zip_code, ') ', province, ' ', city, ' ', town, ' ', street, ' ', building1, '-', building2, ' ') addr"
				+ " FROM address";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Map map = new HashMap();
				map.put("addressId", rs.getInt("addressId"));
				map.put("addr", rs.getInt("addr"));
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
