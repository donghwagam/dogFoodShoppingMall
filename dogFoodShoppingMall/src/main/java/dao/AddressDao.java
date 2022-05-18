package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AddressDao {
	
	// 회원가입 할 때 주소 검색하는 메서드
	public List<Map<String, Object>> searchAddress(String searchAddress) {
		List<Map<String, Object>> list = new ArrayList<>(); // 주소를 저장할 리스트 생성
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 주소를 찾는 쿼리 작성
		String sql = "SELECT address_id addressId, CONCAT('(', zip_code, ') ', province, ' ', city, ' ', town, ' ', street) addr"
				+ "   FROM address"
				+ "	  WHERE CONCAT('(', zip_code, ') ', province, ' ', city, ' ', town, ' ', street)"
				+ "   LIKE ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			
			// ?에 정보 입력
			stmt.setString(1, "%"+searchAddress+"%");
			
			rs = stmt.executeQuery(); // 쿼리로 받아온 정보 ResultSet형식으로 저장
			
			while(rs.next()) { // rs에 정보가 있다면
				Map<String, Object> map = new HashMap<>();
				map.put("addressId", rs.getInt("addressId")); // rs에 있는 정보를 addressId키 값에 저장 후 map에 put하기
				map.put("addr", rs.getString("addr")); // rs에 있는 정보 addr키 값에 저장 후 map에 put하기
				list.add(map); // map을 리스트에 저장
			}
			
		} 
		// 예외 처리
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list; // 리턴 값 
	}

}
