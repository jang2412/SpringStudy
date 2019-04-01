package study.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Dan6 extends HttpServlet{
	
	//	service -> doGet, doPost, doPost
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	인코딩 설정은 출력객체 사용 전에 정의해야 함.
		//	PrintWriter out 변수 선언을 먼저 하고 출력객체의 설정을 하면 인코딩은 안되어있음. L23과 21,22는 바뀌면 안됨.
		
		//resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>dan</title>");
		out.println("</head>");
		out.println("<body>");
		
		/*	getRemoteAddr() : String : 접근한 클라이언트 IP
		 * 	getParameter(name) : String : 해당 파라미터의 값
		 * 	/gugu?dan=6
		 * 
		 * */
		
		out.println("당신의 IP = " + req.getRemoteAddr());
		String t = req.getParameter("dan");		//해당 파라미터 이름이 없으면 null 리턴
		int dan = 2;		//	기본으로 2단
		if(t != null) {
			dan = Integer.parseInt(t);
		}
		out.println("<h3>" + dan + "단</h3>");
		for(int i=1;i<10;i++) {
			out.println(dan + " * " + i + " = " + (dan * i));
			out.println("<br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
