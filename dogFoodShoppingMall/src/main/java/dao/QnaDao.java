package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Qna;

public class QnaDao {
	
	public List<Qna> selectQna(int productId){
		
		List<Qna> list = new ArrayList<Qna>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT"
				+ " qna_kind qnaKind"
				+ " , memo"
				+ " , member_id memberId"
				+ " , create_date createDate"
				+ " FROM qna"
				+ " WHERE product_id = ?";

		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Qna qna = new Qna();
				qna.setQnaKind(rs.getString("qnaKind"));
				qna.setMemo(rs.getString("memo"));
				qna.setMemberId(rs.getString("memberId"));
				qna.setCreateDate(rs.getString("createDate"));
				list.add(qna);
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
		
		
		return list;
	}
	
	
	public int insertQna (Qna qna) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int row = 0;
		
		String sql = "INSERT into qna (qna_kind, memo, member_id, product_id, create_date)"
				+ " VALUES (?, ?, ?, ?, NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
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
