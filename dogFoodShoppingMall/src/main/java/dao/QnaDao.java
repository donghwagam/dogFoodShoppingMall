package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import vo.Qna;

public class QnaDao {
	
	public int insertQna (Qna qna) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		
		String sql = "INSERT into qna (qna_kind, memo, member_id, product_id, create_date)"
				+ " VALUES (?, ?, ?, ?, NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, qna.getQnaKind());
			stmt.setString(2, qna.getMemo());
			stmt.setString(3, qna.getMemberId());
			stmt.setInt(4, qna.getProductId());
			
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
	
	
	
}
