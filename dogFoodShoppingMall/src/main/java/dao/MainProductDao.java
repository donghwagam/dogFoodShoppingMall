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

public class MainProductDao {
	//상품리스트 출력하는 메서드 
			public List<Map<String, Object>> selectProductList() { 
				List<Map<String, Object>> list = new ArrayList<>();
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT p.name productName, p.price, p.gram, pp.name photoName, (select AVG(r.star) from review r) star "
			            + "      FROM product p "
			            + "      LEFT JOIN product_photo pp "
			            + "      ON p.product_id=pp.product_id "
			            + "            LEFT JOIN purchase_list pl "
			            + "            ON p.product_id = pl.product_id "
			            + "               LEFT JOIN review r "
			            + "               ON r.purchase_id = pl.purchase_id ";
				            
				            
			            
						
						
				try {
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					while(rs.next()) {
					Map<String, Object> map = new HashMap<>();
					map.put("productName", rs.getString("productName"));
					map.put("gram", rs.getInt("gram"));
					map.put("price", rs.getInt("price"));
					map.put("photoName", rs.getString("photoName"));
					map.put("star", rs.getInt("star"));
					list.add(map);
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception 예외발생 <-- MainProductDao.selectProductList()");
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException 예외발생 <-- MainProductDao.selectProductList()");
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
					System.out.println("Exception 예외발생 <-- MainProductDao.selectCategoryList()");
				} finally {
					try {
					
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException 예외발생 <-- MainProductDao.selectCategoryList()");
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
				String sql = "SELECT p.product_id productId, p.name productName, p.price, p.gram, pp.name photoName, (select AVG(r.star) from review r) star "
			            + "   FROM product p "
			            + "   LEFT JOIN product_photo pp "
			            + "   ON p.product_id=pp.product_id "
			            + "   LEFT JOIN purchase_list pl "
			            + "   ON p.product_id = pl.product_id "
			            + "	  LEFT JOIN review r "
			            + "   ON r.purchase_id = pl.purchase_id "
						+ "   ORDER BY p.create_date DESC"
						+ "   Limit 0,6" ;
				try {
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
					stmt = conn.prepareStatement(sql);
					rs = stmt.executeQuery();
					while(rs.next()) {
						 Map<String ,Object> map = new HashMap<>();
						 map.put("productId",rs.getInt("productId"));
						 map.put("productName", rs.getString("productName"));
						 map.put("gram" ,rs.getInt("gram"));
						 map.put("price", rs.getInt("price"));
						 map.put("photoName", rs.getString("photoName"));
						 map.put("star", rs.getInt("star"));
						 list.add(map);
						 
					}
				} catch (Exception e) { // 예외발생시 출력 
					e.printStackTrace();
					System.out.println("Exception 예외발생 <-- MainProductDao.selectProductListByLatest()");
				} finally {
					try {
						
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException 예외발생 <-- MainProductDao.selectProductListByLatest()");
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
				String sql = "SELECT p.product_id productId ,p.name productName, p.gram gram, p.price price, pp.name photoName, SUM(pl.quantity)  sum FROM purchase_list pl"
						+ " JOIN product p"
						+ " ON pl.product_id = p.product_id"
						+ " JOIN product_photo pp"
						+ " ON pp.product_id = p.product_id"
						+ " GROUP BY pl.product_id"
						+ " ORDER BY SUM desc"; 
				
				try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				 stmt = conn.prepareStatement(sql);
				 rs = stmt.executeQuery();
				 while(rs.next()) {
					 Map<String ,Object> map = new HashMap<>();
					 map.put("productId", rs.getInt("productId"));
					 map.put("productName",rs.getString("productName"));
					 map.put("gram",rs.getString("gram"));
					 map.put("price",rs.getInt("price"));
					 map.put("photoName",rs.getString("photoName"));
					 list.add(map);
				 }
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception 예외발생 <-- MainProductDao.selectProductListByTopRated()");
				}finally {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException 예외발생 <-- MainProductDao.selectProductListByTopRated()");
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
					System.out.println("Exception 예외발생 <— MainProductDao.selectProductListByCategory()");
				}finally {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("SQLException 예외발생 <— MainProductDao.selectProductListByCategory()");
					}
				}
				return list;
		 	}
			public List<Map<String, Object>> selectProductOne(int productId) {
				List<Map<String, Object>> list = new ArrayList<>();
				Connection conn = null;
				PreparedStatement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT"
						+ " p.name productName "
						+ " , p.price price "
						+ " , p.gram gram "
						+ " , p.rate rate "
						+ " , p.feed_size feedSize "
						+ " , p.origin origin "
						+ " , p.info info "
						+ " , b.name brandName "
						+ " , pp.name photoName "
						+ " , cp.name componentName "
						+ " FROM product p "
						+ " JOIN brand b "
						+ " ON b.brand_id = p.brand_id "
						+ " JOIN product_photo pp "
						+ " ON pp.product_id = p.product_id "
						+ " JOIN product_component pc "
						+ " ON pc.product_id = p.product_id "
						+ " JOIN component cp "
						+ " ON cp.component_id = pc.component_id "
						+ " WHERE p.product_id = ?";
				System.out.println("selectProductOne() productId : " + productId);
				try {
					conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, productId);
					rs = stmt.executeQuery();
					while (rs.next()) {
						 Map<String ,Object> map = new HashMap<>();
						 map.put("productName", rs.getString("productName"));
						 map.put("price", rs.getInt("price"));
						 map.put("gram", rs.getDouble("gram"));
						 map.put("rate", rs.getString("rate"));
						 map.put("feedSize", rs.getString("feedSize"));
						 map.put("origin", rs.getString("origin"));
						 map.put("info", rs.getString("info"));
						 map.put("brandName",rs.getString("brandName"));
						 map.put("photoName",rs.getString("photoName"));
						 map.put("componentName",rs.getString("componentName"));
						 list.add(map);
						 
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception 예외발생 <— MainProductDao.selectProductOne()");
				} finally {
					
				} try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Exception 예외발생 <— MainProductDao.selectProductOne()");
				}
				return list;
			}
	}


