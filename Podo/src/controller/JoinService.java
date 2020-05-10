package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberDTO;

/**
 * Servlet implementation class JoinService
 */
@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setCharacterEncoding("EUC-KR");
	      PrintWriter out = response.getWriter();
	      
	      String id = request.getParameter("id");
	      String pw = request.getParameter("pw");
	      String name = request.getParameter("name");
	      
	      
	      System.out.println(id);
	      System.out.println(pw);
	      System.out.println(name);
	      
	      
	      MemberDTO dto = new MemberDTO(id, pw, name);
	      MemberDAO dao = new MemberDAO();
	      boolean result = dao.Join(dto);
	      out.print(result);
	}

}
