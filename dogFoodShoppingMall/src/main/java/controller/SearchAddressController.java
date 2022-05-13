package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDao;

@WebServlet("/searchAddressController")
public class SearchAddressController extends HttpServlet {
	
	private AddressDao addressDao; // 멤버변수 AddressDao 선언
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchAddress = request.getParameter("searchAddress"); // 검색한 주소값 받아오기
		
		// 디버깅
		System.out.println("insertLoginController.doPost() searchAddress : " + searchAddress);
		
		this.addressDao = new AddressDao(); // addressDao.searchAddress() 메서드 사용을 위한 객체 생성
		List<Map<String, Object>> list = addressDao.searchAddress(searchAddress); // 주소 찾기 메서드 실행 후 찾아온 주소 list에 저장
		
		request.setAttribute("searchAddressList", list); // 리스트 값 searchAddressList에 setting
		
		request.getRequestDispatcher("/WEB-INF/view/insertMember.jsp").forward(request, response); // 회원가입 페이지로 이동
	}

}
