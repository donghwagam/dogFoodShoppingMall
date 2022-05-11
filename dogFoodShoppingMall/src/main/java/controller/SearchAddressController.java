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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchAddress = request.getParameter("searchAddress"); // 검색한 주소값 받아오기
		
		// 디버깅
		System.out.println("insertLoginController.doPost() searchAddress : " + searchAddress);
		
		AddressDao addressDao = new AddressDao(); // 메서드 사용을 위한 객체 생성
		List<Map<String, Object>> list = addressDao.searchAddress(searchAddress);
		
		request.setAttribute("searchAddressList", list); // 리스트 값 searchAddressList에 셋팅
		
		request.getRequestDispatcher("/WEB-INF/view/insertLogin.jsp").forward(request, response);
	}

}
