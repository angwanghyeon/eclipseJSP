package com.keduit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 안 깨지게 하기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		String name = request.getParameter("name");
		String pers = request.getParameter("pers_1")+"-"+request.getParameter("pers_2");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		if(request.getParameter("email_dns").trim() == "") {
			email += "@"+request.getParameter("emailaddr");
		}else {
			email += "@"+request.getParameter("email_dns");
		}
		String zip = request.getParameter("zip");
		String addr = request.getParameter("addr1")+request.getParameter("addr2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String interests[] = request.getParameterValues("interest");
		
		out.println("이름 네이름이 무엇이냐 : "+name);
		out.print("<br>");
		out.println("주민번호 : "+pers);
		out.print("<br>");
		out.println("아이디 : "+id);
		out.print("<br>");
		out.println("비밀번호 : "+pwd);
		out.print("<br>");
		out.println("이메일 : "+email);
		out.print("<br>");
		out.println("우편번호 : "+zip);
		out.print("<br>");
		out.println("주소 : "+addr);
		out.print("<br>");
		out.println("핸드폰 번호 : "+phone);
		out.print("<br>");
		out.println("직업 : "+job);
		out.print("<br>");
		out.println("관심분야 : ");
		
		if(interests == null) {
			out.print("선택한 항목이 없습니다");
		}else {
			for(String interest : interests) {
				out.print(interest+ " ");
			}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}