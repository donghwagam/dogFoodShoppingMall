package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DogDao;
import vo.Allergy;
import vo.Dog;
import vo.MemberDog;

@WebServlet("/insertDogController")
public class InsertDogController extends HttpServlet {
   
   private DogDao dogDao;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.dogDao = new DogDao();
      
      // 강아지 입력폼에 견종 리스트 보여주기 위함
      List<Dog> spieceList = this.dogDao.selectSpiece();
         
       request.setAttribute("spieceList", spieceList);
      
      // 강아지 입력폼에 알러지 리스트 보여주기 위함
      List<Allergy> allergyList = this.dogDao.selectAllergy();
         
       request.setAttribute("allergyList", allergyList);
       
      //디버깅
      for(Dog dog : spieceList) {
         System.out.println("InsertDogController(doGet) dogId: "+dog.getDogId());
         System.out.println("InsertDogController(doGet) spiece: "+dog.getSpiece());
      }

       for(Allergy allergy : allergyList) {
          System.out.println("InsertDogController(doGet) allergyId: "+allergy.getAllergyId());
          System.out.println("InsertDogController(doGet) allergyName: "+allergy.getName());
       }

      // 강아지등록 폼 포워딩
      request.getRequestDispatcher("/WEB-INF/view/insertDog.jsp").forward(request, response); 
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.dogDao = new DogDao(); // 메서드 사용을 위한 DogDao 객체생성
      
     // 세션 호출
      HttpSession session = request.getSession();
      
      // 현재 로그인 된 멤버 아이디 받아오기
      String memberId = (String) session.getAttribute("sessionMemberId");
      
      // 회원가입 입력폼에서 입력된 정보를 각 변수에 저장
      String dogName = request.getParameter("dogName"); // 개 이름
      int dogId = Integer.parseInt(request.getParameter("spiece")); // 견종 번호
      String birth = request.getParameter("birth"); // 태어난 년도
      int weight = Integer.parseInt(request.getParameter("weight")); // 체중
      
      String[] allergy = null; // 알러지 번호 // 여러개라서 배열로 선언
      System.out.println(request.getParameterValues("allergy"));
      if(request.getParameterValues("allergy") != null) {
         allergy = request.getParameterValues("allergy");
         //디버깅
         for(String a : allergy) {
              System.out.println("선택한 알러지 : " + a);
          }
      }
      
      // 디버깅
      System.out.println("InsertDogController.doPost() dogName : " + dogName);
      System.out.println("InsertDogController.doPost() dogId : " + dogId);
      System.out.println("InsertDogController.doPost() birth : " + birth);
      System.out.println("InsertDogController.doPost() weight : " + weight);
      
      
      MemberDog memberDog = new MemberDog();  
      // 데이터바인딩
      memberDog.setMemberId(memberId);
      memberDog.setDogName(dogName); 
      memberDog.setDogId(dogId); 
      memberDog.setBirth(birth); 
      memberDog.setWeight(weight); 
   
      if(allergy==null) { // 알러지 체크 안했다면
         this.dogDao.insertDog(memberDog); // 알러지 등록안하고 강아지 등록만 하는 메서드 실행
      } else { // 알러지 체크했다면
         this.dogDao.insertDogAndAllergy(memberDog, allergy); // 강아지등록 메서드 실행
      }
      
      response.sendRedirect(request.getContextPath()+"/memberOneController"); // 강아지등록 성공 후 마이페이지로 이동
      
   }
}