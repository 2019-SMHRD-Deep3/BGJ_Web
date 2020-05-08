package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

/**
 * Servlet implementation class Loginserice
 */
@WebServlet("/Loginserice")
public class Loginserice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		System.out.println(id); System.out.println(pw);
		 
		
		MemberDTO dto = new MemberDTO(id, pw);
		MemberDAO dao = new MemberDAO();
		
	
		boolean result = dao.login(dto);
		System.out.println(result);
		if(result) {
			out.print(id);
		}else {
			out.print(result);
		}
		
		
		
		
		
	}

}
