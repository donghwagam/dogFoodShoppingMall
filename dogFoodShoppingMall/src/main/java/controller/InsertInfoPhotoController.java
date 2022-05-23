package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.AdminDao;
 	
@WebServlet("/insertInfoPhotoController")
public class InsertInfoPhotoController extends HttpServlet {
	private AdminDao adminDao;// 지역변수 AdminDao 선언 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.adminDao = new AdminDao(); //AdminDao 호출
	
	int productId = Integer.parseInt(request.getParameter("productId")); //사진추가할 productId 값 받아오기 
	System.out.println("InsertInfoPhotoController.doGet() productId : " + productId);
	
	
	List<Map<String, Object>> list = adminDao.selectProductManagementOne(productId);
	for(Map<String, Object> m : list) {
		System.out.println("InsertInfoPhtoController.doGet() productName : " +m.get("productName"));
		System.out.println("InsertInfoPhtoController.doGet() productName : " +m.get("brandName"));
		}
	
		request.setAttribute("list",list);
		
	request.getRequestDispatcher("WEB-INF/view/insertInfoPhoto.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int row = 0;
		this.adminDao = new AdminDao();
		String path = request.getSession().getServletContext().getRealPath("/images"); //사진을 담을 경로설정 
		System.out.println("InsertProductController.doPost() 사진 경로 : " + path); // 사진 경로 확인 디버깅 
		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
		
		int productId = Integer.parseInt(multiReq.getParameter("productId"));
		String InfoPhotoOriginalName = multiReq.getOriginalFileName("InfoPhoto");
		String InfoPhotoName = multiReq.getFilesystemName("InfoPhoto");
		String InfoPhotoType = multiReq.getContentType("InfoPhoto");
		
		System.out.println("InsertInfoPhotoController.doPost() productId: " + productId);
		System.out.println("InsertInfoPhotoController.doPost() InfoPhotoOriginalName :" + InfoPhotoOriginalName);
		System.out.println("InsertInfoPhotoController.doPost() InfoPhotoName :" + InfoPhotoName);
		System.out.println("InsertInfoPhotoController.doPost() InfoPhotoType :" + InfoPhotoType);
		
		if(InfoPhotoType.equals("image/png") || InfoPhotoType.equals("image/jpeg")) {
		 row = adminDao.insertInfoPhotoByProduct(productId ,InfoPhotoOriginalName,InfoPhotoName,InfoPhotoType);
		}
		
		if (row == 1) {
			System.out.println("InsertInfoPhotoController.doPost() 사진 추가 완료");
			response.sendRedirect(request.getContextPath() + "/productManagementController");
		} else {
			System.out.println("InsertInfoPhotoController.doPost() 사진 추가 실패");
			File file = new File(path + "//" + InfoPhotoName); //잘못된 파일 불러 오기 
			file.delete(); // 파일 삭제 
			response.sendRedirect(request.getContextPath() + "/insertInfoPhotoController?productId=" + productId);
		}
		
	}

}
