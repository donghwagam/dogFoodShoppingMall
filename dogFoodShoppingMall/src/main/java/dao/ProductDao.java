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
	
	 // age 정보 불러오는 메서드
	   public List<Category> selectAge() {
	      List<Category> list = new ArrayList<>();
	      
	      //드라이버 자원로딩
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      
	      String sql = "SELECT * FROM category WHERE category_id =1 OR category_id=2 OR category_id=3";
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
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
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
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
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
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
	      public List<Map<String, Object>> selectProductListBySearchCategory(int age, String component, int feedType, String size) {
	         List<Map<String,Object>> list = new ArrayList<>();

	         //드라이버 자원 준비
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         String sql = "SELECT t.productId, t.productName, t.price, t.gram , t.photoName"
	         		+ "		FROM "
	         		+ "			(SELECT p.product_id productId, p.name productName, p.price, p.gram, pp.name photoName, p.feed_size feedSize ,GROUP_CONCAT(pca.category_id, ' ') categoryId,  GROUP_CONCAT(c.name, ' ') component,  p.create_date createDate"
	         		+ "			FROM product p"
	         		+ "			INNER JOIN product_category pca"
	         		+ "				ON p.product_id = pca.product_id"
	         		+ "			INNER JOIN product_component pc"
	         		+ "				ON p.product_id = pc.product_id"
	         		+ "			INNER JOIN component c"
	         		+ "				ON pc.component_id = c.component_id"
	         		+ "			INNER JOIN product_photo pp"
	         		+ "				ON p.product_id= pp.product_id"
	         		+ "			GROUP BY p.product_id ) t";
	         
	         try {
	            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	            if(age==-1 && "".equals(component) && feedType == -1 && "".equals(size)) { // 아무것도 선택하지 않았을때
	               sql += " ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               
	            } else if(age!=-1 && "".equals(component) && feedType == -1 && "".equals(size)) { // 연령만 검색했을때
	               sql += " WHERE t.categoryId LIKE ? ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+age+"%");
	               
	            } else if(age==-1 && !"".equals(component) && feedType == -1 && "".equals(size)) { // 알러지만 검색했을때
	               sql += " WHERE t.component NOT LIKE ? ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               
	            } else if(age==-1 && "".equals(component) && feedType != -1 && "".equals(size)) { // 사료타입만 검색했을때
	               sql += " WHERE t.categoryId LIKE ? ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+feedType+"%");
	               
	            } else if(age==-1 && "".equals(component) && feedType == -1 && !"".equals(size)) { // 사료 알갱이크기만 검색했을때 
	               sql += " WHERE t.feedSize=? ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, size);
	               
	            } else if(age!=-1 && !"".equals(component) && feedType == -1 && "".equals(size)) { // 연령과 알러지 검색했을때 
	               sql += " WHERE t.component NOT LIKE ? AND t.categoryId LIKE ? ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, "%"+age+"%");
	               
	            } else if(age!=-1 && "".equals(component) && feedType != -1 && "".equals(size)) { // 연령과 사료타입 검색했을때
	               sql += " WHERE t.categoryId LIKE ? AND t.categoryId LIKE ? ORDER BY t.createDate DESC LIMIT 0,10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+age+"%");
	               stmt.setString(2, "%"+feedType+"%");
	               
	            } else if(age!=-1 && "".equals(component) && feedType == -1 && !"".equals(size)) { // 연령과 알갱이크기 검색했을때
	               sql += " WHERE t.categoryId LIKE ? AND t.feedSize=? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+age+"%");
	               stmt.setString(2, size);
	               
	            } else if(age==-1 && !"".equals(component) && feedType != -1 && "".equals(size)) { // 알러지와 사료타입 검색했을때
	               sql += " WHERE t.component NOT LIKE ? AND t.categoryId LIKE ? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, "%"+feedType+"%");
	               
	            } else if(age==-1 && !"".equals(component) && feedType == -1 && !"".equals(size)) { // 알러지와 알갱이크기 검색했을때
	               sql += " WHERE t.component NOT LIKE ? AND t.feedSize=? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, size);
	               
	            } else if(age==-1 && "".equals(component) && feedType != -1 && !"".equals(size)) { // 사료타입과 알갱이크기 검색했을때
	               sql += " WHERE t.categoryId LIKE ? AND t.feedSize=? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+feedType+"%");
	               stmt.setString(2, size);
	               
	            } else if(age!=-1 && !"".equals(component) && feedType != -1 && "".equals(size)) { // 연령과 알러지와 사료타입 검색했을때
	               sql += " WHERE t.component NOT LIKE ? AND t.categoryId LIKE ? AND t.categoryId LIKE ? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, "%"+age+"%");
	               stmt.setString(3, "%"+feedType+"%");
	               
	            } else if(age!=-1 && !"".equals(component) && feedType == -1 && !"".equals(size)) { // 연령과 알러지와 알갱이크기 검색했을때
	               sql += " WHERE t.component NOT LIKE ? AND t.categoryId LIKE ? AND t.feedSize=? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, "%"+age+"%");
	               stmt.setString(3, size);
	               
	            } else if(age!=-1 && "".equals(component) && feedType != -1 && !"".equals(size)) { // 연령과 사료타입과 알갱이크기 검색했을때
	               sql += " WHERE t.categoryId LIKE ? AND t.categoryId LIKE ? AND t.feedSize=? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+age+"%");
	               stmt.setString(2, "%"+feedType+"%");
	               stmt.setString(3, size);
	               
	            } else if(age==-1 && !"".equals(component) && feedType != -1 && !"".equals(size)) { // 알러지와 사료타입과 알갱이크기 검색했을때
	               sql += " WHERE t.component NOT LIKE ? AND t.categoryId LIKE ? AND t.feedSize =? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, "%"+feedType+"%");
	               stmt.setString(3, size);
	               
	            } else if(age!=-1 && !"".equals(component) && feedType != -1 && !"".equals(size)) { // 모두 검색했을때
	               sql += " WHERE t.component NOT LIKE ? AND t.categoryId LIKE ? AND t.categoryId LIKE ? AND t.feedSize=? ORDER BY t.createDate DESC LIMIT 0, 10";
	               stmt = conn.prepareStatement(sql);
	               stmt.setString(1, "%"+component+"%");
	               stmt.setString(2, "%"+age+"%");
	               stmt.setString(3, "%"+feedType+"%");
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
	