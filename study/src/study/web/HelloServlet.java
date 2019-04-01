package study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//	HttpServlet 을 상속해서 구현
public class HelloServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		//	WAS에 의해 자동으로 최초에 한번 호출(메모리에 적재)
		System.out.println("Hello 서블릿 생성~~");
	}
	
	@Override
	public void destroy() {
		//	WAS에 의해 자동으로 최후에 한번 호출(메모리에 삭제)		
		System.out.println("Hello 서블릿 끝~~~");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	클라이언트에게 제공할 정보 생성(html, json, img 등)
		//	인코딩 변경 또는 content type 설정
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");	//	기본이 text/html
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello~~~</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("서블릿으로 생성한 문서입니다....");
		out.println("</body>");
		out.println("</html>");
	}
	
}
