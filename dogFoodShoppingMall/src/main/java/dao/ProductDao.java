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
import vo.Category;

public class ProductDao {
	
	// Component 이름을 불러오는 메서드
	public List<Component> selectComponent(){
		List<Component> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT component_id componentId, name FROM component";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
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
	
	 // age 정보 불러오는 메서드
	   public List<Category> selectAge() {
	      List<Category> list = new ArrayList<>();
	      
	      //드라이버 자원로딩
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT * FROM category WHERE category_id =1 OR category_id=2 OR category_id=3";
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Category category = new Category();
	            category.setCategoryId(rs.getInt("category_id"));
	            category.setName(rs.getString("name"));
	            list.add(category);
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
	   
	   // feedType 정보 불러오는 메서드
	   public List<Category> selectFeedType() {
	      List<Category> list = new ArrayList<>();
	      
	      //드라이버 자원로딩
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT * FROM category WHERE category_id =5 OR category_id=6 OR category_id=7";
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Category category = new Category();
	            category.setCategoryId(rs.getInt("category_id"));
	            category.setName(rs.getString("name"));
	            list.add(category);
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
	      

	// 최신순으로 상품리스트를 불러오기 위한 메서드
	   public List<Map<String, Object>> selectProductListBySearch() {
	      List<Map<String,Object>> list = new ArrayList<>();
	      
	      // 드라이버 자원 로딩
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      String sql = "";
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
	         sql = "SELECT "
	         		+ "		p.product_id productId"
	         		+ "		, p.name productName"
	         		+ "		, p.price"
	         		+ "		, p.gram"
	         		+ "		, pp.name photoName"
	         		+ " FROM product p"
	         		+ " LEFT JOIN product_photo pp"
	         		+ " 	ON p.product_id = pp.product_id"
	         		+ " ORDER BY p.create_date desc"
	         		+ " LIMIT 0, 10;";
	         stmt = conn.prepareStatement(sql);
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("productId", rs.getInt("productId"));
	            m.put("productName", rs.getString("productName"));
	            m.put("price", rs.getInt("price"));
	            m.put("gram", rs.getInt("gram"));
	            m.put("photoName", rs.getString("photoName"));
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
	   
	     // 상세검색 구현을 위한 메서드
	      public List<Map<String, Object>> selectProductListBySearchCategory(int age, int component, int feedType, String size) {
	         List<Map<String,Object>> list = new ArrayList<>();

	         //드라이버 자원 로딩
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         String sql = "SELECT p.product_id productId, p.name productName, p.price, p.gram, pp.name photoName"
	         		+ "	   FROM (SELECT product_id, GROUP_CONCAT(component_id, ' ') component"
	         		+ "    		FROM product_component"
	         		+ "    		GROUP BY product_id) t"
	         		+ "    LEFT JOIN product_photo pp"
	         		+ "      ON t.product_id=pp.product_id"
	         		+ "    LEFT JOIN product_category pca"
	         		+ "      ON t.product_id=pca.product_id"
	         		+ "    LEFT JOIN product p"
	         		+ "      ON t.product_id = p.product_id"
	         		+ "   WHERE t.component NOT LIKE ?";
	         try {
	            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
	            if(age==-1 && component ==-1 && feedType == -1 && "".equals(size)) {
	               sql += " GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               
	            } else if(age!=-1 && component ==-1 && feedType == -1 && "".equals(size)) {
	               sql += " WHERE pca.category_id=? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               
	            } else if(age==-1 && component !=-1 && feedType == -1 && "".equals(size)) {
	               sql += " GROUP BY p.product_id ORDER BY p.create_date DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               
	            } else if(age==-1 && component ==-1 && feedType != -1 && "".equals(size)) {
	               sql += " WHERE pca.category_id=? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, feedType);
	               
	            } else if(age==-1 && component ==-1 && feedType == -1 && !"".equals(size)) {
	               sql += " WHERE p.feed_size=? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setString(1, size);
	               
	            } else if(age!=-1 && component !=-1 && feedType == -1 && "".equals(size)) {
	               sql += " WHERE pca.category_id = ? AND GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setInt(3, component);
	               
	            } else if(age!=-1 && component ==-1 && feedType != -1 && "".equals(size)) {
	               sql += " WHERE pca.category_id=? AND pca.category_id = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setInt(3, feedType);
	               
	            } else if(age!=-1 && component ==-1 && feedType == -1 && !"".equals(size)) {
	               sql += " WHERE pca.category_id=? AND p.feed_size = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setString(3, size);
	               
	            } else if(age==-1 && component !=-1 && feedType != -1 && "".equals(size)) {
	               sql += " WHERE pca.category_id = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, component);
	               stmt.setInt(3, feedType);
	               
	            } else if(age==-1 && component !=-1 && feedType == -1 && !"".equals(size)) {
	               sql += " WHERE p.feed_size = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, component);
	               stmt.setString(3, size);
	               
	            } else if(age==-1 && component ==-1 && feedType != -1 && !"".equals(size)) {
	               sql += " WHERE pca.category_id=? AND p.feed_size = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, feedType);
	               stmt.setString(3, size);
	               
	            } else if(age!=-1 && component !=-1 && feedType != -1 && "".equals(size)) {
	               sql += " WHERE pca.category_id = ? AND pca.category_id = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setInt(3, feedType);
	               
	            } else if(age!=-1 && component !=-1 && feedType == -1 && !"".equals(size)) {
	               sql += " WHERE pca.category_id = ? AND pca.category_id = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setString(3, size);
	               
	            } else if(age!=-1 && component ==-1 && feedType != -1 && !"".equals(size)) {
	               sql += " WHERE pca.category_id = ? AND pca.category_id=? AND p.feed_size = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setInt(3, feedType);
	               stmt.setString(4, size);
	               
	            } else if(age==-1 && component !=-1 && feedType != -1 && !"".equals(size)) {
	               sql += " WHERE pca.category_id = ? AND p.feed_size =? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, feedType);
	               stmt.setString(3, size);
	               
	            } else if(age!=-1 && component !=-1 && feedType != -1 && !"".equals(size)) {
	               sql += " WHERE pca.category_id = ? AND pca.category_id = ? AND p.feed_size = ? GROUP BY p.product_id ORDER BY p.create_date desc LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, component+"%");
	               stmt.setInt(2, age);
	               stmt.setInt(3, feedType);
	               stmt.setString(4, size);   
	            }

	            rs = stmt.executeQuery();
	            while(rs.next()) {
	               Map<String, Object> m = new HashMap<>();
	               m.put("productId", rs.getInt("productId"));
	               m.put("productName", rs.getString("productName"));
	               m.put("price", rs.getInt("price"));
	               m.put("gram", rs.getInt("gram"));
	               m.put("photoName", rs.getString("photoName"));
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
	