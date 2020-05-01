package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import GoogleVisionAPITester.GoogleVisionApiTester;
import model.BookDAO;
import model.BookDTO;

/**
 * Servlet implementation class Camera
 */
@WebServlet("/Camera")
public class Camera extends HttpServlet {
	BookDAO dao = new BookDAO();
	BookDTO dto = new BookDTO();
	int cnt = 0;
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * System.out.println("hi"); //�̹����� ������ ��� �Է�. String folderTypePath =
		 * "C:/Users/SM025";
		 * 
		 * String name = new String(); String fileName = new String(); int sizeLimit = 5
		 * * 1024 * 1024; // 5�ް����� ���� �Ѿ�� ���ܹ߻� try { MultipartRequest multi = new
		 * MultipartRequest(request, folderTypePath, sizeLimit, new
		 * DefaultFileRenamePolicy());
		 * 
		 * 
		 * Enumeration files = multi.getFileNames();
		 * 
		 * //���� ������ �ִٸ� if (files.hasMoreElements()) { name = (String)
		 * files.nextElement(); fileName = multi.getFilesystemName(name); }
		 * System.out.println("�̹����� �����Ͽ����ϴ�. : " + fileName); } catch (IOException e) {
		 * System.out.println("�ȵ���̵� ���� �̹����� �޾ƿɴϴ�."); }
		 */
		
		    response.setCharacterEncoding("EUC-KR");
	        PrintWriter out = response.getWriter();
	         
	        String id = request.getParameter("id");
	        System.out.println(id+"�߳Ѿ�Գ�");
	         
	         
	         
	      /////////////////////////////////////////////////////////////////////////
	         
	         String folderTypePath = "D:\\"+id;
	         
	         File Folder = new File(folderTypePath);
	         


	         // �ش� ���丮�� ������� ���丮�� �����մϴ�.
	         if (!Folder.exists()) {
	            try{
	                Folder.mkdir(); //���� �����մϴ�.
	                System.out.println("������ �����Ǿ����ϴ�.");
	                 } 
	                 catch(Exception e){
	                e.getStackTrace();
	            }        
	               }else {
	            System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
	         }
	      
	   
	        String name = new String();
	        String fileName = new String();
	        int sizeLimit = 10 * 1024 * 1024; // 5�ް����� ���� �Ѿ�� ���ܹ߻�
	 
	        try {
	           MultipartRequest multi = new MultipartRequest(request, folderTypePath, sizeLimit,
	                    new DefaultFileRenamePolicy());
	           
	           
	            Enumeration files = multi.getFileNames();
	 
	            //���� ������ �ִٸ�
	            if (files.hasMoreElements()) {
	               
	                name = (String) files.nextElement();
	                fileName = multi.getFilesystemName(name);
	                dto = new BookDTO("�밨��������", cnt, "");
	                dao.bookinsert(dto);
	                cnt +=1;
	               
	            }
	            System.out.println("�̹����� �����Ͽ����ϴ�. : " + fileName);
	            
	        } catch (IOException e) {
	            System.out.println("�ȵ���̵� ���� �̹����� �޾ƿɴϴ�.");
	        }
	        
	        GoogleVisionApiTester GVA = new GoogleVisionApiTester();
	        GVA.textreturn(folderTypePath + "\\", cnt);


	}

}
