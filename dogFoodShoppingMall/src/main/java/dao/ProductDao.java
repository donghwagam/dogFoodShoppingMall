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

import vo.Component;

public class ProductDao {
	
	public List<Component> selectComponent(){
		List<Component> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT component_id componentId, name FROM component";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Component component = new Component();
				component.setComponentId(rs.getInt("componentId"));
				component.setName(rs.getString("name"));
				list.add(component);
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
	public List<Map<String, Object>> selectProductListBySearch() {
		List<Map<String,Object>> list = new ArrayList<>();
		
		// 드라이버 자원 로딩
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			sql = "SELECT p.name, p.price, p.gram, pp.photo_id, (SELECT AVG(r.star) FROM review r) star"
					+ "	FROM product p"
					+ "		LEFT JOIN product_photo pp"
					+ "		ON p.product_id = pp.product_id"
					+ "			LEFT JOIN purchase_list pl"
					+ "			ON p.product_id = pl.product_id"
					+ "				LEFT JOIN review r"
					+ "				ON r.purchase_id = pl.purchase_id"
					+ "	ORDER BY p.create_date desc"
					+ "	LIMIT 0, 10";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("name", rs.getString("name"));
				m.put("price", rs.getInt("price"));
				m.put("gram", rs.getInt("gram"));
				m.put("photoId", rs.getInt("photo_id"));
				m.put("star", rs.getDouble("star"));
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
	
	public List<Map<String, Object>> selectProductListBySearchCategory(String age, String allergy, String feedType, String size) {
		List<Map<String,Object>> list = new ArrayList<>();
		
		//드라이버 자원 로딩
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT p.name, p.price, p.gram, pp.photo_id, (select AVG(r.star) from review r) star "
				+ "		FROM product p "
				+ "		LEFT JOIN product_photo pp "
				+ "		ON p.product_id=pp.product_id "
				+ "			LEFT JOIN product_category pca "
				+ "			ON p.product_id=pca.product_id "
				+ "				LEFT JOIN purchase_list pl "
				+ "				ON p.product_id = pl.product_id "
				+ "					LEFT JOIN review r "
				+ "					ON r.purchase_id = pl.purchase_id "
				+ "						LEFT JOIN product_component pco "
				+ "						ON p.product_id = pco.product_id";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			if("".equals(age) && "".equals(allergy) && "".equals(feedType) && "".equals(size)) {
				sql += " ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				
			} else if(!"".equals(age) && "".equals(allergy) && "".equals(feedType) && "".equals(size)) {
				sql += " WHERE pca.category_id=? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				
			} else if("".equals(age) && !"".equals(allergy) && "".equals(feedType) && "".equals(size)) {
				sql += " WHERE pco.component_id=? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "allergy");
				
			} else if("".equals(age) && "".equals(allergy) && !"".equals(feedType) && "".equals(size)) {
				sql += " WHERE pca.category_id=? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "feedType");
				
			} else if("".equals(age) && "".equals(allergy) && "".equals(feedType) && !"".equals(size)) {
				sql += " WHERE p.feed_size=? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "size");
				
			} else if(!"".equals(age) && !"".equals(allergy) && "".equals(feedType) && "".equals(size)) {
				sql += " WHERE pca.category_id = ? AND pco.component_id=? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "allergy");
				
			} else if(!"".equals(age) && "".equals(allergy) && !"".equals(feedType) && "".equals(size)) {
				sql += " WHERE pca.category_id=? AND pca.cateogry_id = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "feedType");
				
			} else if(!"".equals(age) && "".equals(allergy) && "".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pca.category_id=? AND p.feed_size = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "size");
				
			} else if("".equals(age) && !"".equals(allergy) && !"".equals(feedType) && "".equals(size)) {
				sql += " WHERE pco.component_id=? AND pca.cateogry_id = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "allergy");
				stmt.setString(2, "feedType");
				
			} else if("".equals(age) && !"".equals(allergy) && "".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pco.component_id=? AND p.feed_size = ?ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "allergy");
				stmt.setString(2, "size");
				
			} else if("".equals(age) && "".equals(allergy) && !"".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pca.category_id=? AND p.feed_size = ?ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "feedType");
				stmt.setString(2, "size");
				
			} else if(!"".equals(age) && !"".equals(allergy) && !"".equals(feedType) && "".equals(size)) {
				sql += " WHERE pca.category_id = ? AND pco.component_id=? AND pca.category_id = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "allergy");
				stmt.setString(3, "feedType");
				
			} else if(!"".equals(age) && !"".equals(allergy) && "".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pca.category_id = ? AND pco.component_id=? AND pca.category_id = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "allergy");
				stmt.setString(3, "size");
				
			} else if(!"".equals(age) && "".equals(allergy) && !"".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pca.category_id = ? AND pca.category_id=? AND p.feed_size = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "feedType");
				stmt.setString(3, "size");
				
			} else if("".equals(age) && !"".equals(allergy) && !"".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pco.component_id=? AND pca.category_id = ? AND p.feed_size =? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "allergy");
				stmt.setString(2, "feedType");
				stmt.setString(3, "size");
				
			} else if(!"".equals(age) && !"".equals(allergy) && !"".equals(feedType) && !"".equals(size)) {
				sql += " WHERE pca.category_id = ? AND pco.component_id=? AND pca.category_id = ? AND p.feed_size = ? ORDER BY p.create_date LIMIT 0, 10";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "age");
				stmt.setString(2, "allergy");
				stmt.setString(3, "feedType");
				stmt.setString(4, "size");	
			}
			rs = stmt.executeQuery();
			while(rs.next()) {
				Map<String, Object> m = new HashMap<>();
				m.put("name", rs.getString("name"));
				m.put("price", rs.getInt("price"));
				m.put("gram", rs.getInt("gram"));
				m.put("photoId", rs.getInt("photo_id"));
				m.put("star", rs.getDouble("star"));
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

