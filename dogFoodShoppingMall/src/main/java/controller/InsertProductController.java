package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import java.io.File;

import vo.Brand;
import vo.Component;
import vo.ProductPhoto;
import dao.AdminDao;

@WebServlet("/insertProductController")
public class InsertProductController extends HttpServlet {
	private AdminDao adminDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao();
		List<Component> componentList = adminDao.selectComponentList();
		System.out.println("InsertProductController.doGet() componentList.size() :" + componentList.size());
		List<Brand> brandList = adminDao.selectBrandList();
		System.out.println("InsertProductController.doGet() brandList.size() :" + brandList.size());
		request.setAttribute("brandList", brandList);
		request.setAttribute("componentList", componentList);
		
		request.getRequestDispatcher("WEB-INF/view/insertProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("productName");
		int price = Integer.parseInt(request.getParameter("price"));
		double gram = Double.parseDouble(request.getParameter("gram"));
		String rate = request.getParameter("rate");
		String feedSize = request.getParameter("feedSize");
		String origin = request.getParameter("origin");
		String info = request.getParameter("info");
		String productPhoto = request.getParameter("productPhoto");
		String infoPhoto = request.getParameter("infoPhoto");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int brandId = Integer.parseInt(request.getParameter("brandId")); 
		String [] component = request.getParameterValues("component");
		int dogSize = Integer.parseInt(request.getParameter("dogSize"));
		int feed = Integer.parseInt(request.getParameter("feed"));
		
		
		String path = request.getSession().getServletContext().getRealPath("/images");
		System.out.println("InsertProductController 사진 경로 : " + path);
		
		MultipartRequest multiReq = new MultipartRequest(request, path, 1024*1024*100,"utf-8", new DefaultFileRenamePolicy());
		
		String productPhotoOriginalName = multiReq.getOriginalFileName("productPhoto");
		System.out.println("InsertProductController.doPost() productPhotoOrigianlName :" + productPhotoOriginalName);
		String productPhotoName = multiReq.getFilesystemName("productPhoto");
		System.out.println("InsertProductController.doPost() productPhotoName :" + productPhotoName);
		String productPhotoType = multiReq.getContentType("productPhoto");
		System.out.println("InsertProductController.doPost() productPhotoType :" + productPhotoType);
		if(productPhotoType.equals("image/gif") || productPhotoType.equals("image/png") || productPhotoType.equals("image/jpeg")) {
			ProductPhoto p = new ProductPhoto();
			p.setName(productPhotoName);
			p.setOriginalName(productPhotoOriginalName);
			p.setType(productPhotoType);
		}
		String infoPhotoOriginalName = multiReq.getOriginalFileName("infoPhoto");
		System.out.println("InsertProductController.doPost() infoPhotoOrigianlName :" + infoPhotoOriginalName);
		String infoPhotoName = multiReq.getFilesystemName("infoPhoto");
		System.out.println("InsertProductController.doPost() infoPhotoName :" + infoPhotoName);
		String infoPhotoType = multiReq.getContentType("productPhoto");
		System.out.println("InsertProductController.doPost() infoPhotoType :" +infoPhotoType);
		if(infoPhotoType.equals("image/gif") || infoPhotoType.equals("image/png") || infoPhotoType.equals("image/jpeg")) {
			ProductPhoto p = new ProductPhoto();
			p.setName(infoPhotoName);
			p.setOriginalName(infoPhotoOriginalName);
			p.setType(infoPhotoType);
		}
		System.out.println("insertProductController.doPost() productName :" + productName);
		System.out.println("insertProductController.doPost() price :" +price);
		System.out.println("insertProductController.doPost() gram :" +gram);
		System.out.println("insertProductController.doPost() rate :" +rate);
		System.out.println("insertProductController.doPost() feedSize :" +feedSize);
		System.out.println("insertProductController.doPost() origin :" +origin);
		System.out.println("insertProductController.doPost() info  :" +info);
		System.out.println("insertProductController.doPost() productPhoto :" +productPhoto);
		System.out.println("insertProductController.doPost() infoPhoto :" +infoPhoto);
		System.out.println("insertProductController.doPost() stock :" +stock);
		System.out.println("insertProductController.doPost() brandId :" +brandId);
		for(int i=0; i<component.length; i++) {
			System.out.println("insertProductController.doPost() component :" + component[i]);
		}
		System.out.println("insertProductController.doPost() dogSize :" + dogSize);
		System.out.println("insertProductController.doPost() feed :" + feed);
	}

}
