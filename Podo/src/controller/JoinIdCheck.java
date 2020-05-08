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


@WebServlet("/JoinIdCheck")
public class JoinIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		System.out.println(id);
		 
		
		MemberDTO dto = new MemberDTO(id);
		MemberDAO dao = new MemberDAO();
		
	
		boolean result = dao.JoinCheck(dto);
		System.out.println(result);
		
		out.print(result);
	
	}

}
