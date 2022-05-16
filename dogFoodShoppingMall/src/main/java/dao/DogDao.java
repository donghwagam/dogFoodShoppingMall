package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Allergy;

public class DogDao {
	
	// Allergy 이름을 불러오는 메서드
	public List<Allergy> selectAllergy(){
		List<Allergy> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT allergy_id allergyId, name FROM allergy";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Allergy allergy = new Allergy();
				allergy.setAllergyId(rs.getInt("allergyId"));
				allergy.setName(rs.getString("name"));
				list.add(allergy);
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
	
	// 강아지등록 메서드
	public void insertDog() {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 강아지등록을 해줄 쿼리문 작성
		String sql = "insert into dog values()";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			
			stmt.executeUpdate(); // 쿼리 실행
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}	

