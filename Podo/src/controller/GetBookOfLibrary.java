package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookPrivacyDAO;
import model.BookPrivacyDTO;
import model.GetLibraryDAO;

/**
 * Servlet implementation class GetBookOfLibrary
 */
@WebServlet("/GetBookOfLibrary")
public class GetBookOfLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("호로로롤로");
		request.setCharacterEncoding("EUC-KR");
		response.setCharacterEncoding("EUC-KR");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");

		String title = request.getParameter("title");

		GetLibraryDAO dao = new GetLibraryDAO();
		BookPrivacyDAO dao2 = new BookPrivacyDAO();
		ArrayList<String> array = dao.bookselect();
		ArrayList<String> array2 = dao2.bookNumselect(id, title);
		String data = "";
		String data2 = "";
		for (int i = 0; i < array.size(); i++) {
			data += array.get(i) + "#";
		}
		if (!id.equals(".")) {
			for (int i = 0; i < array2.size(); i++) {

				data2 += array2.get(i) + "#";

			}
			if (array2.size() == 0) {
				data2 += "#";
			}
		}
		//data+="d";
		data = data + "/" + data2;

		System.out.println(data);
		if (data != "") {
			out.print(URLEncoder.encode(data, "EUC-KR"));
		} else {
			out.print(false);
		}
	}

}
