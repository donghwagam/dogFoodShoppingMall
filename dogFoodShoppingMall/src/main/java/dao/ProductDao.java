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
			sql = "SELECT p.name productName, p.price, p.gram, pp.name photoName, (SELECT AVG(r.star) FROM review r) star"
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
				m.put("productName", rs.getString("productName"));
				m.put("price", rs.getInt("price"));
				m.put("gram", rs.getInt("gram"));
				m.put("photoName", rs.getString("photoName"));
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
	
	  // 상세검색 구현을 위한 메서드
	   public List<Map<String, Object>> selectProductListBySearchCategory(int age, int component, int feedType, String size) {
	      List<Map<String,Object>> list = new ArrayList<>();
	      
	      //드라이버 자원 로딩
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      ResultSet rs = null;
	      String sql = "SELECT p.name productName, p.price, p.gram, pp.name photoName, (select AVG(r.star) from review r) star "
	            + "      FROM product p "
	            + "      LEFT JOIN product_photo pp "
	            + "      ON p.product_id=pp.product_id "
	            + "         LEFT JOIN product_category pca "
	            + "         ON p.product_id=pca.product_id "
	            + "            LEFT JOIN purchase_list pl "
	            + "            ON p.product_id = pl.product_id "
	            + "               LEFT JOIN review r "
	            + "               ON r.purchase_id = pl.purchase_id "
	            + "                  LEFT JOIN product_component pco "
	            + "                  ON p.product_id = pco.product_id";
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	         if(age==-1 && component ==-1 && feedType == -1 && "".equals(size)) {
	            sql += " ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            
	         } else if(age!=-1 && component ==-1 && feedType == -1 && "".equals(size)) {
	            sql += " WHERE pca.category_id=? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            
	         } else if(age==-1 && component !=-1 && feedType == -1 && "".equals(size)) {
	            sql += " WHERE pco.component_id != ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, component);
	            
	         } else if(age==-1 && component ==-1 && feedType != -1 && "".equals(size)) {
	            sql += " WHERE pca.category_id=? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, feedType);
	            
	         } else if(age==-1 && component ==-1 && feedType == -1 && !"".equals(size)) {
	            sql += " WHERE p.feed_size=? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, "size");
	            
	         } else if(age!=-1 && component !=-1 && feedType == -1 && "".equals(size)) {
	            sql += " WHERE pca.category_id = ? AND pco.component_id != ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1,age);
	            stmt.setInt(2, component);
	            
	         } else if(age!=-1 && component ==-1 && feedType != -1 && "".equals(size)) {
	            sql += " WHERE pca.category_id=? AND pca.category_id = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            stmt.setInt(2, feedType);
	            
	         } else if(age!=-1 && component ==-1 && feedType == -1 && !"".equals(size)) {
	            sql += " WHERE pca.category_id=? AND p.feed_size = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            stmt.setString(2, "size");
	            
	         } else if(age==-1 && component !=-1 && feedType != -1 && "".equals(size)) {
	            sql += " WHERE pco.component_id != ? AND pca.category_id = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, component);
	            stmt.setInt(2, feedType);
	            
	         } else if(age==-1 && component !=-1 && feedType == -1 && !"".equals(size)) {
	            sql += " WHERE pco.component_id != ? AND p.feed_size = ?ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, component);
	            stmt.setString(2, "size");
	            
	         } else if(age==-1 && component ==-1 && feedType != -1 && !"".equals(size)) {
	            sql += " WHERE pca.category_id=? AND p.feed_size = ?ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, feedType);
	            stmt.setString(2, "size");
	            
	         } else if(age!=-1 && component !=-1 && feedType != -1 && "".equals(size)) {
	            sql += " WHERE pca.category_id = ? AND pco.component_id != ? AND pca.category_id = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            stmt.setInt(2, component);
	            stmt.setInt(3, feedType);
	            
	         } else if(age!=-1 && component !=-1 && feedType == -1 && !"".equals(size)) {
	            sql += " WHERE pca.category_id = ? AND pco.component_id != ? AND pca.category_id = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            stmt.setInt(2, component);
	            stmt.setString(3, "size");
	            
	         } else if(age!=-1 && component ==-1 && feedType != -1 && !"".equals(size)) {
	            sql += " WHERE pca.category_id = ? AND pca.category_id=? AND p.feed_size = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            stmt.setInt(2, feedType);
	            stmt.setString(3, "size");
	            
	         } else if(age==-1 && component !=-1 && feedType != -1 && !"".equals(size)) {
	            sql += " WHERE pco.component_id != ? AND pca.category_id = ? AND p.feed_size =? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, component);
	            stmt.setInt(2, feedType);
	            stmt.setString(3, "size");
	            
	         } else if(age!=-1 && component !=-1 && feedType != -1 && !"".equals(size)) {
	            sql += " WHERE pca.category_id = ? AND pco.component_id != ? AND pca.category_id = ? AND p.feed_size = ? ORDER BY p.create_date LIMIT 0, 10";
	            stmt = conn.prepareStatement(sql);
	            stmt.setInt(1, age);
	            stmt.setInt(2, component);
	            stmt.setInt(3, feedType);
	            stmt.setString(4, "size");   
	         }
	         rs = stmt.executeQuery();
	         while(rs.next()) {
	            Map<String, Object> m = new HashMap<>();
	            m.put("productName", rs.getString("productName"));
	            m.put("price", rs.getInt("price"));
	            m.put("gram", rs.getInt("gram"));
	            m.put("photoName", rs.getString("photoName"));
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
	   
	//-----------------------------------------------------------------------------------------------------
	//상품리스트 출력하는 메서드 
		public List<Map<String, Object>> selectProductList() { 
			List<Map<String, Object>> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.product_id productId"
		            + " , p.name name "
		            + " , p.gram gram"
		            + " , p.price price "
		            + " , pph.photo_id photoId"
		            + " , pph.name pphName"
		            + " FROM product p"
		            + " JOIN product_photo pph"
		            + " ON p.product_id = pph.product_id";
		            
					
					
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("productId",rs.getInt("productId"));
				map.put("name", rs.getString("name"));
				map.put("gram", rs.getInt("gram"));
				map.put("price", rs.getInt("price"));
				map.put("photoId", rs.getInt("photoId"));
				map.put("pphName", rs.getString("pphName"));
				list.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception 예외발생 <-- ProductDao.selectProductList()");
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException 예외발생 <-- ProductDao.selectProductList()");
				}
			}
			return list;
	 	}
		// 카테고리 정보 보여주는 메서드 
		public List<Category> selectCategoryList() {
			List<Category> list = new ArrayList<Category>();
			Connection conn = null; 
			PreparedStatement  stmt = null; 
			ResultSet rs = null;
			String sql = " SELECT category_id categoryId" // 카테고리 id와 카테고리 이름 출력하는 쿼리문 
					+ " , name FROM category";
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					Category c = new Category();
					c.setCategoryId(rs.getInt("categoryId"));
					c.setName(rs.getString("name"));
					list.add(c);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception 예외발생 <-- ProductDao.selectCategoryList()");
			} finally {
				try {
				
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException 예외발생 <-- ProductDao.selectCategoryList()");
				}
			} 
			return list;
		}
		// 상품리스트 최신순으로 보여주는 메서드
		public List<Map<String, Object>> selectProductListByLatest() { 
			List<Map<String, Object>> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.product_id productId"
		            + " , p.name name "
		            + " , p.gram gram"
		            + " , p.price price "
		            + " , pph.photo_id photoId"
		            + " , pph.name pphName"
		            + " FROM product p"
		            + " JOIN product_photo pph"
		            + " ON p.product_id = pph.product_id"
					+ " ORDER BY p.create_date DESC"
					+ " Limit 0,6" ;
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					 Map<String ,Object> map = new HashMap<>();
					 map.put("productId",rs.getInt("productId"));
					 map.put("name", rs.getString("name"));
					 map.put("gram" ,rs.getInt("gram"));
					 map.put("price", rs.getInt("price"));
					 map.put("photoId", rs.getInt("photoId"));
					 map.put("pphName", rs.getString("pphName"));
					 list.add(map);
					 
				}
			} catch (Exception e) { // 예외발생시 출력 
				e.printStackTrace();
				System.out.println("Exception 예외발생 <-- ProductDao.selectProductListByLatest()");
			} finally {
				try {
					
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException 예외발생 <-- ProductDao.selectProductListByLatest()");
				}
			}
			return list;
	 	}
		// 상품리스트를 인기순으로 정렬하는 메소드 
		public List<Map<String, Object>> selectProductListByTopRated() {
			List<Map<String, Object>> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT t.product_id productId " // 상품ID
					+ " ,name " // 상품 이름 
					+ " , price " // 가격 
					+ " , t.sum " // 판매량합계 
					+ " , RANK() OVER (ORDER BY t.sum DESC) result" // 인기순위 
					+ " FROM (SELECT pl.product_id, SUM(pl.quantity) sum"
					+ " FROM purchase_list pl JOIN product p"
					+ " ON pl.product_id = p.product_id"
					+ " GROUP BY pl.product_id) t";
			
			try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			 stmt = conn.prepareStatement(sql);
			 rs = stmt.executeQuery();
			 while(rs.next()) {
				 Map<String ,Object> map = new HashMap<>();
				 map.put("productId",rs.getInt("productId"));
				 map.put("name",rs.getString("name"));
				 map.put("price",rs.getInt("price"));
				 map.put("result",rs.getInt("result"));
				 list.add(map);
			 }
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception 예외발생 <-- ProductDao.selectProductListByTopRated()");
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException 예외발생 <-- ProductDao.selectProductListByTopRated()");
				}
			}
			return list;
	 	}
		public List<Map<String, Object>> selectProductListByCategory(String categoryName) {
			List<Map<String, Object>> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String sql = "SELECT p.product_id productId"
					+ " , p.name name"
					+ " , p.price price"
					+ " , pph.photo_id photoId"
					+ " , pph.name pphName from product p"
					+ " JOIN product_category pc"
					+ " ON p.product_id = pc.product_id"
					+ " JOIN category c"
					+ " ON pc.category_id = c.category_id"
					+ " JOIN product_photo pph"
					+ " ON p.product_id = pph.product_id"
					+ " WHERE c.name = ? " ;
			try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,categoryName);
				 rs = stmt.executeQuery();
				 while(rs.next()) {
					 Map<String ,Object> map = new HashMap<>();
					 map.put("productId",rs.getInt("productId"));
					 map.put("name",rs.getString("name"));
					 map.put("price",rs.getInt("price"));
					 map.put("photoId",rs.getInt("photoId"));
					 map.put("pphName", rs.getString("pphName"));
					 list.add(map);
				 }
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception 예외발생 <— ProductDao.selectProductListByCategory()");
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("SQLException 예외발생 <— ProductDao.selectProductListByCategory()");
				}
			}
			return list;
	 	}
	}


