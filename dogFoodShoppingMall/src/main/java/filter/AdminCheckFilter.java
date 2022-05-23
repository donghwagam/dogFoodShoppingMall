package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import vo.Member;
@WebFilter("/adminCheck/*")
public class AdminCheckFilter implements Filter {

	private AdminDao adminDao; 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//Dao 호출
		this.adminDao = new AdminDao();
		
		int level = -1; //관리자랑 사용자 구분하는 변수 생성 

		if(request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = ((HttpServletRequest)request).getSession();
			String memberId = (String)session.getAttribute("sessionMemberId"); //session에 있는 ID 값 받아오기 
			
			System.out.println("AdminCheckFilter memberId : " + memberId); 
			
			
			 level =  adminDao.selectAdminFilterList(memberId); 
			
		
		System.out.println("AdminCheckFilter level : " + level);
		
		
		if (level == 1) {
			if(response instanceof HttpServletResponse) {
			System.out.println("AdminCheckFilter : 사용자");
				((HttpServletResponse)response).sendRedirect(req.getContextPath()+"/mainPageController");
			}
		} else if(level == 0) {
			System.out.println("AdminCheckFilter : 관리자");
		} else {
			return;
		}
		chain.doFilter(request, response);
	}


	}
}
