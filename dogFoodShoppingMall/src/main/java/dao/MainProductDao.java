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
import vo.ProductPhoto;
import vo.Category;

public class MainProductDao {
   //상품리스트 출력하는 메서드 
         public List<Map<String, Object>> selectProductList(int beginRow , int rowPerPage) { 
            List<Map<String, Object>> list = new ArrayList<>();
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String sql = "SELECT p.product_id productId " // 상품 id
                  + "         ,p.name productName" // 상품 이름 
                  + "         ,p.price price" // 가격 
                  + "         ,p.gram gram" //그램 
                  + "         ,r.star star" //별점 
                  + "         ,pp.name photoName" // 사진이름 
                     + "    FROM product p "
                     + "    LEFT JOIN product_photo pp "
                     + "      ON p.product_id=pp.product_id "
                     + "    LEFT JOIN review r"
                     + "      ON r.review_id = p.product_id"
                     + "    LIMIT ?,?";
                     
            try {
               conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, beginRow);
               stmt.setInt(2, rowPerPage);
               rs = stmt.executeQuery();
               while(rs.next()) {
               Map<String, Object> map = new HashMap<>();
               map.put("productId",rs.getInt("productId"));
               map.put("productName", rs.getString("productName"));
               map.put("gram", rs.getInt("gram"));
               map.put("star", rs.getInt("star"));
               map.put("price", rs.getInt("price"));
               map.put("photoName", rs.getString("photoName"));
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
        public int selectProductTotalRow() {
        	int totalCount = 0;
        	Connection conn = null;
        	PreparedStatement stmt = null;
        	ResultSet rs = null;
        	String sql = "SELECT COUNT(*) cnt"
        			+ "     FROM product";
        
        	try {
        		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
        		 stmt = conn.prepareStatement(sql);
        		 rs = stmt.executeQuery();
  		       if(rs.next()) {
  		    	   totalCount = rs.getInt("cnt"); // totalCount 변수에 cnt 저장 
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
        	return totalCount;
        }
        public int selectProductTotalRowByCategory(String categoryName) {
        	int totalCount = 0;
        	Connection conn = null;
        	PreparedStatement stmt = null;
        	ResultSet rs = null;
        	String sql = "SELECT COUNT(*) cnt"
        			+ "	    FROM product p"
        			+ "     JOIN product_category pc"
        			+ "       ON p.product_id = pc.product_id"
        			+ "     JOIN category c"
        			+ "       ON c.category_id = pc.category_id"
        			+ "    WHERE c.name = ?";
        try {
        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
   		 stmt = conn.prepareStatement(sql);
   		 stmt.setString(1, categoryName);
   		 rs = stmt.executeQuery();
	       if(rs.next()) {
	    	   totalCount = rs.getInt("cnt"); // totalCount 변수에 cnt 저장 
	       }
        } catch (Exception e) {
        	e.printStackTrace();
        	} finally {
        		try {
        			conn.close();
        		} catch(SQLException e) {
        			e.printStackTrace();
        		}
        	}
        return totalCount;
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
            String sql = "SELECT p.product_id productId"
                  + "         ,p.name productName"
                  + "         ,p.price price"
                  + "         ,p.gram gram"
                  + "         ,r.star star"
                  + "         ,pp.name photoName"
                     + "    FROM product p "
                     + "   LEFT JOIN product_photo pp "
                     + "      ON p.product_id=pp.product_id "
                     + "   LEFT JOIN purchase_list pl "
                     + "      ON p.product_id = pl.product_id "
                     + "   LEFT JOIN review r"
                     + "      ON r.product_id = p.product_id"
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
                   map.put("star", rs.getInt("star"));
                   map.put("price", rs.getInt("price"));
                   map.put("photoName", rs.getString("photoName"));
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
            String sql = "SELECT p.product_id productId "
                  + "         ,p.name productName"
                  + "         ,p.gram gram"
                  + "         ,p.price price"
                  + "         ,r.star star"
                  + "         ,pp.name photoName"
                  + "         ,SUM(pl.quantity) sum "
                  + "      FROM purchase_list pl"
                  + "    JOIN product p"
                  + "     ON pl.product_id = p.product_id"
                  + "    JOIN product_photo pp"
                  + "     ON pp.product_id = p.product_id"
                  + "    LEFT JOIN review r"
                  + "     ON r.product_id = p.product_id"
                  + "    GROUP BY pl.product_id"
                  + "    ORDER BY SUM desc"
                  + "      Limit 0,6"; 
            
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
                map.put("star", rs.getInt("star"));
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
         public List<Map<String, Object>> selectProductListByCategory(String categoryName,int beginRow, int rowPerPage) {
            List<Map<String, Object>> list = new ArrayList<>();
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String sql = "SELECT p.product_id productId"
                  + "       ,p.name productName"
                  + "       ,p.price price"
                  + "       ,pph.name photoName"
                  + "       ,r.star star"
                  + "      FROM product p"
                  + "    JOIN product_category pc"
                  + "     ON p.product_id = pc.product_id"
                  + "    JOIN category c"
                  + "     ON pc.category_id = c.category_id"
                  + "    JOIN product_photo pph"
                  + "     ON p.product_id = pph.product_id"
                  + "   LEFT JOIN review r"
                  + "     ON r.product_id = p.product_id"
                  + "    WHERE c.name = ? "
                  + "     LIMIT ?, ?" ;
            try {
               conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
            
               stmt = conn.prepareStatement(sql);
               stmt.setString(1,categoryName);
               stmt.setInt(2, beginRow);
               stmt.setInt(3, rowPerPage);
                rs = stmt.executeQuery();
                while(rs.next()) {
                   Map<String ,Object> map = new HashMap<>();
                   map.put("productId",rs.getInt("productId"));
                   map.put("productName",rs.getString("productName"));
                   map.put("price",rs.getInt("price"));
                   map.put("photoName", rs.getString("photoName"));
                   map.put("star", rs.getInt("star"));
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
            String sql = "SELECT p.name productName "  // 상품이름 
                  + "       ,p.price price " // 가격 
                  + "       ,p.gram gram " // 그램 
                  + "       ,p.rate rate " // 등급 
                  + "       ,p.feed_size feedSize " //알갱이 크기 
                  + "       ,p.origin origin " // 원산지 
                  + "       ,p.stock stock" // 재고 
                  + "       ,p.info info " // 정보 
                  + "       ,r.star star "
                  + "       ,b.name brandName " //브랜드 이름 
                  + "       ,pp.name photoName "  //사진 
                  + "       ,GROUP_CONCAT(DISTINCT cp.name,' ') componentName"  // CONCAT(cp.name, ', ')
                  + "    FROM product p "
                  + "    JOIN brand b "
                  + "       ON b.brand_id = p.brand_id "
                  + "    JOIN product_photo pp "
                  + "     ON pp.product_id = p.product_id "
                  + "    JOIN product_component pc "
                  + "      ON pc.product_id = p.product_id "
                  + "    JOIN component cp "
                  + "     ON cp.component_id = pc.component_id"
                  + "   LEFT JOIN review r"
                  + "     ON r.product_id = p.product_id "
                  + "      WHERE p.product_id = ?"
                  + "    GROUP BY p.product_id";
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
                   map.put("stock" , rs.getInt("stock"));
                   map.put("info", rs.getString("info"));
                   map.put("star",rs.getInt("star"));
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
         public List<ProductPhoto> selectPhotoList(int ProductId) {
        	 List<ProductPhoto> list = new ArrayList<ProductPhoto>();
        	 Connection conn = null;
        	 PreparedStatement stmt = null;
        	 ResultSet rs = null;
        	String sql = "select name photoName "
        			+ "     FROM product_photo"
        			+ "    WHERE product_id = ? AND name LIKE '%info%'" ;
        	try {
        		conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, ProductId);
                rs = stmt.executeQuery();
                if(rs.next()) {
                	 ProductPhoto p = new ProductPhoto();
                	 p.setName(rs.getString("photoName"));
                	 list.add(p);
                }
        	} catch(Exception e) {
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


