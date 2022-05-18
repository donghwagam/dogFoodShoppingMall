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

import vo.Member;

public class AdminDao {
	// 필터에 사용할 관리자, 사용자 구분하는 메서드 
	public int selectAdminFilterList(String memberId) {
		int level = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT level"  // 현재 세션에 있는 member의 level 값을 구하는 쿼리문 
				+ "     FROM member "
				+ "  WHERE member_id = ?";
		try {
			 conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
             stmt = conn.prepareStatement(sql);
             stmt.setString(1,memberId);
             rs = stmt.executeQuery();
             while(rs.next()) {
            	 
            	 level = rs.getInt("level");
            	 
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
		return level;
	}
	// AdminDao
	// 상품별 판매량 
	     public List<Map<String, Object>> selectChartListByProduct() {
	         List<Map<String, Object>> list = new ArrayList<>();
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         String sql = " SELECT p.product_id productId"               // 상품 Id
	               + "           , p.name productName"                  // 상품 이름
	               + "           , p.price price"                     // 상품 가격
	               + "             , SUM(pl.quantity) sum"               // 상품 주문량 총합
	               + "           , p.price*SUM(pl.quantity) AS totalPrice"   // 상품별 판매 총액      
	               + "        FROM purchase_list pl"
	               + "       JOIN product p"
	               + "          ON pl.product_id = p.product_id"
	               + "    GROUP BY productName"                     // 상품 Id로 그룹핑
	               + "    ORDER BY totalPrice DESC";
	         
	         
	         /*
	          ??? 판매 총액 구현 price*sum  
	          */
	         
	         try {
	            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	            while(rs.next()) {
	            Map<String ,Object> map = new HashMap<>();
	            map.put("productId",rs.getInt("productId"));
	            map.put("productName",rs.getString("productName"));
	            map.put("price",rs.getInt("price"));
	            map.put("sum",rs.getInt("sum"));
	            map.put("totalPrice",rs.getInt("totalPrice"));
	            list.add(map);
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("selectChartListByProduct Exception e");
	         }   finally {
	               try {
	                  conn.close();
	               } catch (SQLException e) {
	                  e.printStackTrace();
	                  System.out.println("selectChartListByProduct SQLException e");
	               }
	         }
	         return list;
	         
	      }
	      
	      // 날짜별 판매량
	      public List<Map<String, Object>> selectChartListByDate() {
	         List<Map<String, Object>> list = new ArrayList<>();
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         String sql =  "SELECT SUM(pl.quantity) sum"
	               + "           , SUM(pl.quantity*p.price) AS totalPrice"         // 해당 날짜 상품별 판매량 총합
	               + "           , CAST(pl.update_date AS DATE) AS updateDate"     // datetime -> date 타입으로 변환
	               + "         FROM purchase_list pl"
	               + "         JOIN product p"
	               + "          ON p.product_id = pl.product_id"
	               + "      GROUP BY updateDate"                              // 날짜별로 그룹핑
	               + "      ORDER BY totalPrice DESC";                        // 날짜 순으로 정렬
	      
	         try {
	            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	            
	            while(rs.next()) {
	            Map<String ,Object> map = new HashMap<>();
	            map.put("sum",rs.getInt("sum"));
	            map.put("updateDate",rs.getString("updateDate"));
	            map.put("totalPrice",rs.getInt("totalPrice"));
	            
	            list.add(map);
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }   finally {
	               try {
	                  conn.close();
	               } catch (SQLException e) {
	                  e.printStackTrace();
	               }
	         }
	         return list;
	      }
	      
	      // 카테고리별 판매량
	      public List<Map<String, Object>> selectChartListByCategory() {
	         List<Map<String, Object>> list = new ArrayList<>();
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         String sql = "SELECT c.name categoryName"                  // 카테고리 이름
	               + "          , SUM(pl.quantity) sum"               // 카테고리별 판매량
	               + "          , SUM(pl.quantity*p.price) AS totalPrice"   // 카테고리별 판매 총액
	               + "        FROM purchase_list pl"
	               + "        JOIN product_category pc"
	               + "         ON pc.product_id = pl.product_id"
	               + "        JOIN category c"
	               + "         ON c.category_id = pc.category_id"
	               + "        JOIN product p"
	               + "         ON p.product_id = pl.product_id"
	               + "     GROUP BY categoryName"                     // 카테고리 이름으로 그룹핑
	               + "     ORDER BY totalPrice DESC";                  // 카테고리별 판매 총액 순으로 정렬
	      
	         try {
	            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	            while(rs.next()) {
	            Map<String ,Object> map = new HashMap<>();
	            map.put("categoryName",rs.getString("categoryName"));
	            map.put("sum",rs.getInt("sum"));
	            map.put("totalPrice",rs.getInt("totalPrice"));
	            
	            
	            list.add(map);
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }   finally {
	               try {
	                  conn.close();
	               } catch (SQLException e) {
	                  e.printStackTrace();
	               }
	         }
	         return list;
	      }
	      
	      // 브랜드별 판매량
	      public List<Map<String, Object>> selectChartListByBrand() {
	         List<Map<String, Object>> list = new ArrayList<>();
	         Connection conn = null;
	         PreparedStatement stmt = null;
	         ResultSet rs = null;
	         String sql = "SELECT b.name brandName"                  // 브랜드 이름
	               + "          , SUM(pl.quantity) sum"               // 브랜드별 판매량
	               + "          , SUM(p.price*pl.quantity) AS totalPrice"   // 브랜드별 판매 총액
	              + "        FROM purchase_list pl"
	              + "        JOIN product p"
	              + "         ON p.product_id = pl.product_id"
	              + "        JOIN brand b"
	              + "         ON b.brand_id = p.brand_id"
	              + "     GROUP BY brandName"                        // 브랜드별 그룹핑
	              + "     ORDER BY totalPrice DESC";                  // 판매 총액 순으로 정렬
	      
	         try {
	            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	            stmt = conn.prepareStatement(sql);
	            rs = stmt.executeQuery();
	            
	            while(rs.next()) {
	            Map<String ,Object> map = new HashMap<>();
	            map.put("brandName",rs.getString("brandName"));
	            map.put("sum",rs.getInt("sum"));
	            map.put("totalPrice",rs.getInt("totalPrice"));
	            list.add(map);
	            }
	         } catch (Exception e) {
	            e.printStackTrace();
	         }   finally {
	               try {
	                  conn.close();
	               } catch (SQLException e) {
	                  e.printStackTrace();
	               }
	         }
	         return list;
	      }
	   // 사이트의 멤버 전체 수를 구하는 메서드 
	   public int selectMemberTotalRow() {
		   int totalCount = 0;
		   Connection conn = null;
		   PreparedStatement stmt = null; 
		   ResultSet rs = null;
		   String sql = "SELECT COUNT(*) cnt " // 현재 가입자들중 활성화 된 사람의 수를 구하는 쿼리 
		   		+ "      FROM member "
		   		+ "      where active = 1";
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
	   //선택한 구매자의행 카운트 하는 메서드 
	   public int selectPurchaseListTotalRow(String memberId) {
		   int totalCount = 0;
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql =  "SELECT COUNT(*) cnt"
		   		+ "       FROM purchase p"
		   		+ "      INNER JOIN member m"
		   		+ "        ON m.member_id = p.member_id"
		   		+ "       WHERE active =1 AND p.member_id = ?";
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
		       stmt = conn.prepareStatement(sql);
		       stmt.setString(1, memberId);
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
	   
	   public List<Map<String, Object>> selectMemberListByPage(int beginRow , int rowPerPage) {
		   List<Map<String, Object>> list = new ArrayList<>();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null; 
		   String sql = "SELECT m.member_id memberId"
		   		+ "             ,m.name name"
		   		+ "             ,m.birth birth"
		   		+ "             ,m.phone phone"
		   		+ "             ,m.email email"
		   		+ "             ,m.gender gender"
		   		+ "             ,CONCAT('(', a.zip_code, ') ', a.province, ' ', a.city, ' ', a.town, ' ', a.street, ' ', a.building1, '-',a. building2, ' ', m.detail_addr) addr"
		   		+ "       FROM member m"
		   		+ "		 INNER JOIN address a"
		   		+ "         ON a.address_id = m.address_id"
		   		+ "      LIMIT ?,?";
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
		       stmt = conn.prepareStatement(sql);
		       stmt.setInt(1,beginRow);
		       stmt.setInt(2, rowPerPage);
		       rs = stmt.executeQuery();
		       while (rs.next()) {
		    	   Map<String ,Object> m = new HashMap<>();
		    	   m.put("memberId", rs.getString("memberId"));
		    	   m.put("name", rs.getString("name"));
		    	   m.put("birth", rs.getString("birth"));
		    	   m.put("phone", rs.getString("phone"));
		    	   m.put("email", rs.getString("email"));
		    	   m.put("gender",rs.getString("gender"));
		    	   m.put("addr",rs.getString("addr"));
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
	   //선택한 멤버아이디의 구매목록을 보여주는 메서드 
	   public List<Map<String, Object>> selectPurchaseMemberTotalListByPage(int beginRow, int rowPerPage, String memberId) {
		   List<Map<String, Object>> list = new ArrayList<>();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql = "SELECT pl.purchase_id purchaseId"
			  		+ "          , p.name productName"
			  		+ "          , pl.quantity quantity"
			  		+ "          , pu.member_id memberId"
			  		+ "          , pu.status status"
			  		+ "          , pu.payment payment"
			  		+ "          ,pu.total_price totalPrice"
			  		+ "          ,pu.create_date createDate"
			  		+ "     FROM purchase_list pl"
			  		+ "   JOIN product p"
			  		+ "       ON pl.product_id = p.product_id"
			  		+ "   JOIN purchase pu"
			  		+ "       ON pl.purchase_id = pu.purchase_id"
			  		+ "   WHERE pu.member_id = ?"
			  		+ "   LIMIT ?,?";
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			   stmt = conn.prepareStatement(sql);
			   stmt.setString(1,memberId);
			   stmt.setInt(2,beginRow);
		       stmt.setInt(3, rowPerPage);
		       rs = stmt.executeQuery();
		       while (rs.next()) {
		    	   Map<String, Object> m = new HashMap<>();
		    	   m.put("purchaseId",rs.getInt("purchaseId"));
		    	   m.put("productName",rs.getString("productName"));
		    	   m.put("quantity", rs.getInt("quantity"));
		    	   m.put("memberId", rs.getString("memberId"));
		    	   m.put("status", rs.getString("status"));
		    	   m.put("payment", rs.getString("payment"));
		    	   m.put("totalPrice", rs.getInt("totalPrice"));
		    	   m.put("createDate", rs.getString("createDate"));
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
	  // 상품페이지 update하기전리스트 보여주는 메서드 
	   public List<Map<String, Object>> selectUpdatePurchaseList(int purchaseId) {
		   List<Map<String, Object>> list = new ArrayList<>();
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql = "SELECT pu.purchase_id purchaseId"
		   		+ "            ,COUNT(pl.product_id) cnt"
		   		+ "            ,p.name productName"
		   		+ "            ,pu.member_id memberId"
		   		+ "            ,pu.status status"
		   		+ "            ,pu.payment payment"
		   		+ "            ,pu.total_price totalPrice"
		   		+ "            ,pu.create_date createDate"
		   		+ "      FROM purchase pu"
		   		+ "    JOIN purchase_list pl"
		   		+ "       ON pl.purchase_id = pu.purchase_id"
		   		+ "    JOIN product p"
		   		+ "       ON p.product_id = pl.product_id"
		   		+ "     WHERE pu.purchase_id = ?"
		   		+ "     GROUP BY pu.purchase_id";
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			   stmt = conn.prepareStatement(sql);
			   stmt.setInt(1, purchaseId);
			   rs = stmt.executeQuery();
		       while (rs.next()) {
		    	   Map<String ,Object> m = new HashMap<>();
		    	   m.put("purchaseId",rs.getInt("purchaseId"));
		    	   m.put("cnt", rs.getInt("cnt"));
		    	   m.put("productName",rs.getString("productName"));
		    	   m.put("memberId", rs.getString("memberId"));
		    	   m.put("payment", rs.getString("payment"));
		    	   m.put("status", rs.getString("status"));
		    	   m.put("totalPrice", rs.getInt("totalPrice"));
		    	   m.put("createDate",rs.getString("createDate"));
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
	   // 배송정보 수정하는 메서드 
	   public int updatePurchaseList(String status, int purchaseId) {
		   int row = 0;
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   String sql = "UPDATE purchase"
		   		+ "      SET status = ?"
		   		+ "      WHERE purchase_id = ?";
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			   stmt = conn.prepareStatement(sql);
			   stmt.setString(1,status);
			   stmt.setInt(2, purchaseId);
			   row = stmt.executeUpdate();
			   if (row == 1) {
				   System.out.println("AdminDao updatePurchaseList() 수정성공 ");
			   } else {
				   System.out.println("AdminDao updatePurchaseList() 수정실패 ");
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
		   return row;
	   }
	   //구매목록페이지 검색했을때 보여주는 메서드 
	   public List<Map<String, Object>> selectSearchPurchaseTotalListByPage(int beginRow, int rowPerPage, String memberId, String status ,String aDate, String bDate) {
		  List<Map<String, Object>> list = new ArrayList<>();
		  Connection conn = null;
		  PreparedStatement stmt = null;
		  ResultSet rs = null;
		  String sql = "SELECT pl.purchase_id purchaseId"
		  		+ "          , p.name productName"
		  		+ "          , pl.quantity quantity"
		  		+ "          , pu.member_id memberId"
		  		+ "          , pu.status status"
		  		+ "          , pu.payment payment"
		  		+ "          ,pu.total_price totalPrice"
		  		+ "          ,pu.create_date createDate"
		  		+ "     FROM purchase_list pl"
		  		+ "   JOIN product p"
		  		+ "       ON pl.product_id = p.product_id"
		  		+ "   JOIN purchase pu"
		  		+ "       ON pl.purchase_id = pu.purchase_id";
		  		
		  		
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			  if (status.equals("") && aDate.equals("") && bDate.equals("")) { // 3개다 입력하지 않았을 때 
		       sql +=  "   WHERE pu.member_id = ?"
				  		+ "   LIMIT ?,?";
			   stmt = conn.prepareStatement(sql);
		       stmt.setString(1, memberId);
		       stmt.setInt(2,beginRow);
		       stmt.setInt(3, rowPerPage);
			  } else if (status.equals("") && aDate.equals("") && !bDate.equals("")) { // bDate 만 입력했을때
				  sql +=  "   WHERE pu.member_id = ? AND pu.create_date BETWEEN '0000-01-01' AND ?"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, bDate);
				  stmt.setInt(3, beginRow);
				  stmt.setInt(4, rowPerPage);
			  } else if (status.equals("") && !aDate.equals("") && bDate.equals("")) { // aDate만 입력했을 때 
				  sql +=  "   WHERE pu.member_id = ? AND pu.create_date BETWEEN ? AND NOW()"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, aDate);
				  stmt.setInt(3, beginRow);
				  stmt.setInt(4, rowPerPage);
			  } else if (status.equals("") && !aDate.equals("") && !bDate.equals("")) { // aDate와 bDate 를 둘다 입력했을 때 
				  sql +=  "   WHERE pu.member_id = ? AND pu.create_date BETWEEN ? AND ?"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, aDate);
				  stmt.setString(3, bDate);
				  stmt.setInt(4, beginRow);
				  stmt.setInt(5, rowPerPage);
			  } else if (!status.equals("") && aDate.equals("") && bDate.equals("")) { // 배송정보를 입력했을 때 
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ?"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1,memberId);
				  stmt.setString(2,status);
				  stmt.setInt(3,beginRow);
				  stmt.setInt(4, rowPerPage);
			  } else if (!status.equals("") && aDate.equals("") && !bDate.equals("")) { // 배송정보와 bDate를 입력했을떄 
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ? AND pu.create_date '0000-01-01' BETWEEN ?"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1,memberId);
				  stmt.setString(2, status);
				  stmt.setString(3, bDate);
				  stmt.setInt(4, beginRow);
				  stmt.setInt(4, rowPerPage);
			  } else if (!status.equals("") && !aDate.equals("") && bDate.equals("")) {
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ? AND pu.create_date ? BETWEEN NOW()"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, status);
				  stmt.setString(3, aDate);
				  stmt.setInt(4,beginRow);
				  stmt.setInt(5,rowPerPage);
			  } else if (!status.equals("") && !aDate.equals("") && !bDate.equals("")) {
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ? AND pu.create_date ? BETWEEN ?"
					  		+ "   LIMIT ?,?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1,memberId);
				  stmt.setString(2,status);
				  stmt.setString(3, aDate);
				  stmt.setString(4, bDate);
				  stmt.setInt(5, beginRow);
				  stmt.setInt(6, rowPerPage);
			  }
		       rs = stmt.executeQuery();
		       while (rs.next()) {
		    	   Map<String, Object> m = new HashMap<>();
		    	   m.put("purchaseId",rs.getInt("purchaseId"));
		    	   m.put("productName",rs.getString("productName"));
		    	   m.put("quantity", rs.getInt("quantity"));
		    	   m.put("memberId", rs.getString("memberId"));
		    	   m.put("status", rs.getString("status"));
		    	   m.put("payment", rs.getString("payment"));
		    	   m.put("totalPrice", rs.getInt("totalPrice"));
		    	   m.put("createDate", rs.getString("createDate"));
		    	   list.add(m);
		       }
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
			   try {
				   conn.close();
			   } catch (SQLException e){
				   e.printStackTrace();
			   }
		   }
		   return list;
	   }
	   public int selectSearchPurchaseTotalRow(String memberId, String status ,String aDate, String bDate) {
		   int totalCount = 0;
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   ResultSet rs = null;
		   String sql = "SELECT COUNT(*) cnt"
				   + "     FROM purchase_list pl"
			  		+ "   JOIN product p"
			  		+ "       ON pl.product_id = p.product_id"
			  		+ "   JOIN purchase pu"
			  		+ "       ON pl.purchase_id = pu.purchase_id";
		   try {
			   conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			  if (status.equals("") && aDate.equals("") && bDate.equals("")) { // 3개다 입력하지 않았을 때 
		       sql +=  "   WHERE pu.member_id = ?";
			   stmt = conn.prepareStatement(sql);
		       stmt.setString(1, memberId);
			  } else if (status.equals("") && aDate.equals("") && !bDate.equals("")) { // bDate 만 입력했을때
				  sql +=  "   WHERE pu.member_id = ? AND pu.create_date BETWEEN '0000-01-01' AND ?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, bDate);
			  } else if (status.equals("") && !aDate.equals("") && bDate.equals("")) { // aDate만 입력했을 때 
				  sql +=  "   WHERE pu.member_id = ? AND pu.create_date BETWEEN ? AND NOW()";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, aDate);
			  } else if (status.equals("") && !aDate.equals("") && !bDate.equals("")) { // aDate와 bDate 를 둘다 입력했을 때 
				  sql +=  "   WHERE pu.member_id = ? AND pu.create_date BETWEEN ? AND ?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1, memberId);
				  stmt.setString(2, aDate);
				  stmt.setString(3, bDate);
			  } else if (!status.equals("") && aDate.equals("") && bDate.equals("")) { // 배송정보를 입력했을 때 
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1,memberId);
				  stmt.setString(2,status);
			  } else if (!status.equals("") && aDate.equals("") && !bDate.equals("")) { // 배송정보와 bDate를 입력했을떄 
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ? AND pu.create_date '0000-01-01' BETWEEN ?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1,memberId);
				  stmt.setString(2, status);
				  stmt.setString(3, bDate);
			  } else if (!status.equals("") && !aDate.equals("") && bDate.equals("")) {
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ? AND pu.create_date ? BETWEEN NOW()";
				  stmt.setString(1, memberId);
				  stmt.setString(2, status);
				  stmt.setString(3, aDate);
			  } else if (!status.equals("") && !aDate.equals("") && !bDate.equals("")) {
				  sql +=  "   WHERE pu.member_id = ? AND pu.status = ? AND pu.create_date ? BETWEEN ?";
				  stmt = conn.prepareStatement(sql);
				  stmt.setString(1,memberId);
				  stmt.setString(2,status);
				  stmt.setString(3, aDate);
				  stmt.setString(4, bDate);
			  } 
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
}
