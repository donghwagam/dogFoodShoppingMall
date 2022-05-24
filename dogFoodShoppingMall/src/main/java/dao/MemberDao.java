package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import vo.Member;

public class MemberDao {
	
	public int updateMemberActive(String memberId) {
		int row = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "UPDATE member"
				+ "	  SET active='0'"
				+ "	  WHERE member_id = ?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
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
	
	public Map<String, Object> selectMemberInfo(String memberId) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		
		String sql = "SELECT"
				+ " 	m.member_id memberId"
				+ "		, m.member_pw memberPw"
				+ "		, m.name"
				+ "		, m.birth"
				+ "		, m.phone"
				+ "		, m.email"
				+ "		, m.gender"
				+ "		, m.level"
				+ "		, m.active"
				+ "		, m.address_id addressId"
				+ "		, CONCAT('(', a.zip_code, ') ', a.province, ' ', a.city, ' ', a.town, ' ', a.street, m.detail_addr) addr"
				+ "		, m.create_date createDate"
				+ "		, m.update_date updateDate"
				+ "   FROM member m JOIN address a"
				+ "   ON m.address_id = a.address_id"
				+ "   WHERE m.member_id = ?";
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
				
			if(rs.next()) {
				map.put("memberId", rs.getString("memberId"));
				map.put("memberPw", rs.getString("memberPw"));
				map.put("name", rs.getString("name"));
				map.put("birth", rs.getString("birth"));
				map.put("phone", rs.getString("phone"));
				map.put("email", rs.getString("email"));
				map.put("gender", rs.getString("gender"));
				map.put("level", rs.getString("level"));
				map.put("active", rs.getString("active"));
				map.put("addressId", rs.getInt("addressId"));
				map.put("addr", rs.getString("addr"));
				map.put("createDate", rs.getString("createDate"));
				map.put("updateDate", rs.getString("updateDate"));
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
		
		return map; // 업데이트가 성공했으면 1을 반환 실패했으면 0을 반환 
	}
	
	// 주소 변경 메서드
	public int updateAddress(Member member) {
		int row = 0; //반환값으로 사욜할 row 선언
		
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "UPDATE member SET address_id=?, detail_addr=? WHERE member_id=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, member.getAddressId());
			stmt.setString(2, member.getDetailAddr());
			stmt.setString(3, member.getMemberId());
			
			row = stmt.executeUpdate();
			
			if(row == 1) {
				System.out.println("updateAddress 성공");
			} else {
				System.out.println("updateAddress 실패");
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
	
	// 비밀번호 변경 메서드(비밀번호 찾기시)
	public int updateMemberPw(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		int row = 0; // 반환값으로 이용할 row 선언
		
		// 비밀번호를 업데이트 하는 쿼리 저장
		String sql = "UPDATE member SET member_pw=PASSWORD(?), pw_update_date = now()"
				+ " WHERE member_id=? AND phone=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			
			// ?에 정보 입력
			stmt.setString(1, member.getMemberPw()); // 바꿀 비밀번호
			stmt.setString(2, member.getMemberId()); // 아이디
			stmt.setString(3, member.getPhone()); // 휴대폰번호
			row = stmt.executeUpdate(); // 쿼리 실행 후 row에 반환 값 저장
		} 
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return row; // 업데이트가 성공했으면 1을 반환 실패했으면 0을 반환 
	}
	
	// 비밀번호 변경 메서드(마이페이지 통한 비밀번호변경시)
	public int updateMemberPwByMyPage(String nowPw, Member member) {
		
		int row = 0; // 행 개수 반환할 변수 생성
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "UPDATE member SET member_pw=PASSWORD(?), pw_update_date = now()"
				+ "   WHERE member_id=? AND member_pw=PASSWORD(?)";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			stmt.setString(3, nowPw);
			row = stmt.executeUpdate();
			
			if(row != 1) {
				System.out.println("updateMemberPwByMyPage 입력 실패");
			} else {
				System.out.println("updateMemberPwByMyPage 입력 성공");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return row;
	}
	//비밀번호 변경 후 비밀번호 이력테이블에 추가하는 메서드
	public void insertPwRecordByUpdate(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO member_pw_record VALUES(?,PASSWORD(?),NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			
			int row = stmt.executeUpdate();
			
			if(row != 1) {
				System.out.println("insertPwRecordByUpdate 추가 실패");
			} else {
				System.out.println("insertPwRecordByUpdate 추가 성공");
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
	}
	
	// DB에 저장된 비밀번호 찾기
	public String searchMemberPw(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String memberPw = null; // 쿼리문에서 가져올 비밀번호를 저장할 변수 선언
		
		// DB에 저장된 비밀번호 가져오는 쿼리
		String sql = "SELECT member_pw memberPw"
				+ " FROM member"
				+ " WHERE member_id=? And name=? AND phone=?";
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			stmt.setString(1, member.getMemberId()); // 아이디
			stmt.setString(2, member.getName()); // 이름
			stmt.setString(3, member.getPhone()); // 핸드폰번호
			
			rs = stmt.executeQuery(); // 쿼리로 받아온 정보 ResultSet형식으로 저장
			
			if(rs.next()) { // rs에 정보가 있다면
				memberPw = rs.getString("memberPw"); // rs에 있는 정보 memberPw 변수에 저장
			}
			
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberPw; // 받아온 비밀번호 반환
		
	}
	
	// 아이디 찾기 메서드
	public String searchMemberId(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String memberId = null; // 쿼리문에서 찾아올 아이디를 저장한 변수 선언
		
		// 아이디를 찾아올 쿼리 저장
		String sql = "SELECT member_id memberId"
						+ " FROM member"
						+ " WHERE name=? AND phone=?";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			stmt.setString(1, member.getName()); // 이름
			stmt.setString(2, member.getPhone()); // 핸드폰번호
			
			rs = stmt.executeQuery(); // 쿼리문으로 받아온 정보 ResultSet형식으로 저장
			
			if(rs.next()) { // rs에 저장된 정보가 있다면
				memberId = rs.getString("memberId"); // 쿼리문에서 찾아온 아이디 저장
			}
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return memberId; // 아이디값 반환
	}
	
	//비밀번호 이력테이블에 비밀번호 추가 
	public void insertPwRecord(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member_pw_record (member_id, pw_record, update_date) VALUES (?,PASSWORD(?),now())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			int row = stmt.executeUpdate(); // 쿼리 실행
			if(row == 1) {
				System.out.println("insertPwRecord 입력 성공");
			} else {
				System.out.println("insertPwRecord 입력 실패");
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
	}
	
	// 회원가입 메서드
	public void insertMember(Member member) {
		// 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 회원가입을 해줄 쿼리문 작성
		String sql = "INSERT INTO member (member_id, member_pw, name, birth, phone, email, gender, address_id, detail_addr, create_date, update_date,pw_update_date)"
				+ " VALUES"
				+ " (?, PASSWORD(?), ?, ?, ?, ?, ?, ?, ?, NOW(), NOW(),NOW())";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // 쿼리 작성
			// ?에 정보 입력
			stmt.setString(1, member.getMemberId()); // 아이디
			stmt.setString(2, member.getMemberPw()); // 비밀번호
			stmt.setString(3, member.getName()); // 이름
			stmt.setString(4, member.getBirth()); // 생년월일
			stmt.setString(5, member.getPhone()); // 핸드폰번호
			stmt.setString(6, member.getEmail()); // 이메일
			stmt.setString(7, member.getGender()); // 성별
			stmt.setInt(8, member.getAddressId()); // 주소
			stmt.setString(9, member.getDetailAddr()); // 상세주소
			stmt.executeUpdate(); // 쿼리 실행
			
		}
		// 예외 처리
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 로그인 유효성 검사 메서드
	public String selectMemberByIdPw(Member member) {
		String memberId = null; // 변수 memberId 생성
		
		// DB연결을 위한 자원 준비
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// 쿼리 작성
		String sql = "SELECT member_id memberId FROM member WHERE member_id=? AND member_pw=PASSWORD(?)";
		
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234"); // DB 연결
			stmt = conn.prepareStatement(sql); // sql문 전송
			stmt.setString(1, member.getMemberId()); // ? 값에 memberId 값 넣어주기
			stmt.setString(2, member.getMemberPw()); // ? 값에 memberPw 값 넣어주기
			
			rs = stmt.executeQuery(); // select한 값 rs에 저장
			
			if(rs.next()) { // rs에 정보가 있을때, memberId에 값 저장
				memberId = rs.getString("memberId"); // 반환해줄 변수에 값 저장
			}
		}
		// 예외 처리
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close(); // 자원 반환
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberId; // 리턴값
	}
	

	
	// 회원정보 수정 메서드
	public int updateMember(Member member) {
	      
	      // DB연결을 위한 자원 준비
	      Connection conn = null;
	      PreparedStatement stmt = null;
	      int row = 0;
	      String sql = "UPDATE member "
	      		+ "		SET name=?"
	      		+ "			,birth=?"
	      		+ "			,phone=?"
	      		+ "			,email=?"
	      		+ "			,gender=?"
	      		+ "			,update_date=now()"
	      		+ "		WHERE member_id=?";
	      
	      try {
	         conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
	         
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, member.getName());
	         stmt.setString(2, member.getBirth());
	         stmt.setString(3, member.getPhone());
	         stmt.setString(4, member.getEmail());
	         stmt.setString(5, member.getGender());
	         stmt.setString(6, member.getMemberId());
	         
	         row = stmt.executeUpdate();
	         
	         if(row == 1) {
	            System.out.println("updateMember 수정 성공");
	         } else {
	            System.out.println("updateMember 수정 실패");
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
	      return row;
	}    
	
	// 회원정보 삭제 메서드
		public int deleteMember(int memberDogId, String memberId, String checkPw) {
			  int memberRow = 0;
			  // DB연결을 위한 자원 준비
		      Connection conn = null;
		      PreparedStatement basketStmt = null;
		      PreparedStatement memberDogAllergyStmt = null;
		      PreparedStatement memberDogStmt = null;
		      PreparedStatement pwRecordStmt = null;
		      PreparedStatement memberStmt = null;
		      
		      String basketSql = "DELETE FROM basket WHERE member_id=?";
		      String memberDogAllergySql = "DELETE FROM member_dog_allergy WHERE member_dog_id=?";
		      String memberDogSql =  "DELETE FROM member_dog WHERE member_id=?";
		      String pwRecordSql = "DELETE FROM member_pw_record WHERE member_id=?";
		      String memberSql = "DELETE FROM member WHERE member_id=? AND member_pw = PASSWORD(?)";
		      
		      try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				conn.setAutoCommit(false); // 자동커밋을 해제
				
				// 장바구니 삭제 
				basketStmt = conn.prepareStatement(basketSql);
				basketStmt.setString(1, memberId);
				int basketRow = basketStmt.executeUpdate();
				
				if(basketRow != 1) {
					System.out.println("basket 삭제 실패");
				} else {
					System.out.println("basket 삭제 성공");
				}
				
				// memberDogAllergy 삭제
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
				memberDogStmt.setString(1, memberId);
				int memberDogRow = memberDogStmt.executeUpdate();
				
				if(memberDogRow != 1) {
					System.out.println("memberDog 삭제 실패");
				} else {
					System.out.println("memberDog 삭제 성공");
				}
				
				//비밀번호 이력 삭제
				pwRecordStmt = conn.prepareStatement(pwRecordSql);
				pwRecordStmt.setString(1, memberId);
				
				int pwRecordRow = pwRecordStmt.executeUpdate();
				
				if(pwRecordRow != 1) {
					System.out.println("pwRecord 삭제 실패");
				} else {
					System.out.println("pwRecord 삭제 성공");
				}
				
				//member 삭제
				memberStmt = conn.prepareStatement(memberSql);
				memberStmt.setString(1, memberId);
				memberStmt.setString(2, checkPw);
				
				memberRow = memberStmt.executeUpdate();
				
				if(memberRow != 1) {
					System.out.println("member 삭제 실패");
				} else {
					System.out.println("member 삭제 성공");
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
		      
		    return memberRow;
		}
		
		// dogId 들고오기 위한 메서드
		public int selectMemberDogId(String memberId) {
			
		    int memberDogId = -1;
		    
			Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet rs = null;
		    String sql = "SELECT member_dog_id memberDogId"
		    		+ "	  FROM member_dog"
		    		+ "	  WHERE member_id=?";

		    try {
				conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shopping","root","java1234");
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, memberId);
				rs = stmt.executeQuery();
				if(rs.next()) {
			    	memberDogId = rs.getInt("memberDogId");
			    }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return memberDogId;
		}
}






















