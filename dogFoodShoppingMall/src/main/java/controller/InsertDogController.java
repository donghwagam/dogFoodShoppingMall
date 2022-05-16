package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DogDao;
import vo.Allergy;

@WebServlet("/insertDogController")
public class InsertDogController extends HttpServlet {
	private DogDao dogDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // 강아지등록 폼 연결
		request.getRequestDispatcher("/WEB-INF/view/insertDog.jsp").forward(request, response); 
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원가입 입력폼에서 입력된 정보를 각 변수에 저장
		String dogName = request.getParameter("dogName"); // 개 이름
		String spiece = request.getParameter("spiece"); // 견종
		String birth = request.getParameter("birth"); // 태어난 년도
		String weight = request.getParameter("weigth"); // 체중
		String allergy = request.getParameter("allergy"); // 알러지
		
		// 디버깅
		System.out.println("InsertDogController.doPost() dogName : " + dogName);
		System.out.println("InsertDogController.doPost() spiece : " + spiece);
		System.out.println("InsertDogController.doPost() birth : " + birth);
		System.out.println("InsertDogController.doPost() weight : " + weight);
		System.out.println("InsertDogController.doPost() allergy : " + allergy);

		Map<String, Object> map = new HashMap<>(); // memberDao.insertMember()메서드의 매개변수로 사용될 Member객체 생성
		// 객체를 이용해 정보저장
		map.put(dogName, "dogName"); 
		map.put(spiece, "spiece"); 
		map.put(birth, "birth"); 
		map.put(weight, "weight"); 
		map.put(allergy, "allergy"); 
	
		this.dogDao = new DogDao(); // 메서드 사용을 위한 DogDao 객체생성
		this.dogDao.insertDog(); // 강아지등록 메서드 실행
		
		System.out.println("강아지등록 성공"); // 디버깅
		response.sendRedirect(request.getContextPath()+"/loginCheck/memberOneController"); // 강아지등록 성공 후 메인페이지로 이동
		
	}

}
