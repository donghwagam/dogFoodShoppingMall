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

import vo.Allergy;
import vo.Dog;
import vo.MemberDog;

public class DogDao {
   
   // allergy 정보 불러오는 메서드
   public List<Allergy> selectAllergy(){
      List<Allergy> list = new ArrayList<>();
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT allergy_id allergyId, name FROM allergy";
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
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
   
   // dog테이블 정보 불러오는 메서드
   public List<Dog> selectSpiece(){
      List<Dog> list = new ArrayList<>();
      
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "SELECT dog_id dogId, spiece FROM dog";
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery();
         
         while(rs.next()) {
            Dog dog = new Dog();
            dog.setDogId(rs.getInt("dogId"));
            dog.setSpiece(rs.getString("spiece"));
            list.add(dog);
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
      
   // 강아지 등록기능 구현 위한 메서드 (알러지 없을때)
   public void insertDog(MemberDog memberDog) {
      // 자원 준비
     Connection conn = null;
     PreparedStatement stmt = null;
     String sql = "INSERT INTO member_dog (member_id, dog_id, dog_name, birth, weight, create_date, update_date)"
           + "      VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
     try {
        conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
        stmt = conn.prepareStatement(sql); 
        stmt.setString(1, memberDog.getMemberId());
          stmt.setInt(2, memberDog.getDogId());
          stmt.setString(3, memberDog.getDogName());
          stmt.setString(4, memberDog.getBirth());
          stmt.setDouble(5, memberDog.getWeight());
            
          int row = stmt.executeUpdate();
          if(row != 1) {
             System.out.println("insertDog 입력 실패");
          } else {
             System.out.println("insertDog 입력 성공");
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
   }
   
   // 강아지 등록기능 구현 위한 메서드 (알러지 있을때)
   public void insertDogAndAllergy(MemberDog memberDog, String[] allergy) {
      // 자원 준비
      int memberDogRow = 0;
      Connection conn = null;
      PreparedStatement memberDogStmt = null;
      PreparedStatement memberDogAllergyStmt = null;
      ResultSet rs = null;
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234"); // DB 연결
         conn.setAutoCommit(false); // 자동커밋을 해제

         // 강아지등록을 해줄 쿼리문 작성
         // 1. 등록할 강아지의 강아지이름, 견종, 태어난해, 체중을 db에 저장
         String memberDogSql = "INSERT INTO member_dog (member_id, dog_id, dog_name, birth, weight, create_date, update_date)"
               + "      VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
         
         // sql(insert)만 실행하는게 아니라 select(방금 생성된 행의 키값)도 같이 실행 
         memberDogStmt = conn.prepareStatement(memberDogSql, PreparedStatement.RETURN_GENERATED_KEYS); 

         memberDogStmt.setString(1, memberDog.getMemberId());
         memberDogStmt.setInt(2, memberDog.getDogId());
         memberDogStmt.setString(3, memberDog.getDogName());
         memberDogStmt.setString(4, memberDog.getBirth());
         memberDogStmt.setDouble(5, memberDog.getWeight());
         
         memberDogRow = memberDogStmt.executeUpdate(); 
         rs = memberDogStmt.getGeneratedKeys(); // 방금입력한 select member_dog_id from member_dog;
         
         if(memberDogRow != 1) { // 입력한 행이 1개가 아니라면
            System.out.println("insertDogAndAllergy : memberDog 입력실패");
         } else {
            System.out.println("insertDogAndAllergy : memberDog 입력성공");
         }
      
         int memberDogId = 0; //초기값 0으로 세팅
         if(rs.next()) {
           memberDogId = rs.getInt(1);
         }

        // 2. 등록할 강아지의 알러지를 db에 저장
        for(String a : allergy) { // for문은 a 사이즈 개수만큼
            String memberDogAllergySql = "INSERT INTO member_dog_allergy(member_dog_id, allergy_id, update_date) VALUES(?,?,NOW())";
            memberDogAllergyStmt = conn.prepareStatement(memberDogAllergySql);
            memberDogAllergyStmt.setInt(1, memberDogId);
            memberDogAllergyStmt.setString(2, a); // for문 순서대로 
            
            int memberDogAllergyRow = memberDogAllergyStmt.executeUpdate();
            
            if(memberDogAllergyRow != 1) { // 입력한 행이 1개가 아니라면
               System.out.println("insertDogAndAllergy : memberDogAllergy 입력실패");
            } else {
               System.out.println("insertDogAndAllergy : memberDogAllergy 입력성공");
            }
          
         }
         conn.commit();

      } catch (Exception e) { // 예외 처리
         try {
            conn.rollback();
         } catch (SQLException e1) {
            e1.printStackTrace();
         }
         e.printStackTrace();
      } finally {
         try {
            conn.close(); // 자원 반환
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   // 애견정보를 보여주는 메서드
   public List<Map<String, Object>> selectDog(String memberId) {
      List<Map<String, Object>> list = new ArrayList<>();
      // DB연결을 위한 자원 준비
      Connection conn = null;
      PreparedStatement stmt = null;
      ResultSet rs = null;
      
      // 쿼리작성
      String sql = "SELECT md.member_dog_id memberDogId, md.dog_name dogName, d.spiece, md.birth, md.weight, IFNULL(GROUP_CONCAT(a.name),'알러지 없음') allergyName"
            + "         FROM member_dog md "
            + "         LEFT JOIN dog d"
            + "            ON md.dog_id = d.dog_id"
            + "         LEFT JOIN member_dog_allergy mda"
            + "            ON md.member_dog_id = mda.member_dog_id"
            + "         LEFT JOIN allergy a"
            + "            ON mda.allergy_id = a.allergy_id"
            + "         WHERE md.member_id = ?"
            + "      	GROUP BY md.member_dog_id";
      
      try {
      conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
      stmt = conn.prepareStatement(sql); // sql문 전송
      stmt.setString(1, memberId );
      rs = stmt.executeQuery();
      
      while(rs.next()) {
         Map<String, Object> map = new HashMap<>();
         map.put("memberDogId", rs.getInt("memberDogId"));
         map.put("dogName", rs.getString("dogName"));
         map.put("spiece", rs.getString("spiece"));
         map.put("birth", rs.getString("birth"));
         map.put("weight", rs.getDouble("weight"));
         map.put("allergyName", rs.getString("allergyName"));
         
         list.add(map);
      }
   } catch (Exception e) {
      e.printStackTrace();
   }
      return list;
   }

   
   //강아지 삭제기능 구현 위한 메서드
   public void deleteDog(int memberDogId) {
      Connection conn = null;
      PreparedStatement memberDogAllergyStmt = null;
      PreparedStatement memberDogStmt = null;
      String memberDogAllergySql = "DELETE FROM member_dog_allergy WHERE member_dog_id=?";
      String memberDogSql = "DELETE FROM member_dog WHERE member_dog_id=?";
      
      try {
         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","mariadb1234");
         conn.setAutoCommit(false); // 자동커밋을 해제

         //memberDogAllergy 삭제
         memberDogAllergyStmt = conn.prepareStatement(memberDogAllergySql);
         memberDogAllergyStmt.setInt(1, memberDogId);
         int memberDogAllergyRow = memberDogAllergyStmt.executeUpdate();
         
         if(memberDogAllergyRow != 1) {
            System.out.println("memberDogAllergy 삭제 실패");
         } else {
            System.out.println("memberDogAllergy 삭제 성공");
         }
         
         //memberDog 삭제
         memberDogStmt = conn.prepareStatement(memberDogSql);
         memberDogStmt.setInt(1, memberDogId);
         int memberDogRow = memberDogStmt.executeUpdate();
         
         if(memberDogRow != 1) {
            System.out.println("memberDog 삭제 실패");
         } else {
            System.out.println("memberDog 삭제 성공");
         }
         
         conn.commit();
      } catch (Exception e) { //예외 처리
         try {
         conn.rollback();
      } catch (SQLException e1) {
         e1.printStackTrace();
      }
         
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