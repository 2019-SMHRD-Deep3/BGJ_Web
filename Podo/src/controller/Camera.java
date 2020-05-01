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
		 * System.out.println("hi"); //이미지를 저장할 경로 입력. String folderTypePath =
		 * "C:/Users/SM025";
		 * 
		 * String name = new String(); String fileName = new String(); int sizeLimit = 5
		 * * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생 try { MultipartRequest multi = new
		 * MultipartRequest(request, folderTypePath, sizeLimit, new
		 * DefaultFileRenamePolicy());
		 * 
		 * 
		 * Enumeration files = multi.getFileNames();
		 * 
		 * //파일 정보가 있다면 if (files.hasMoreElements()) { name = (String)
		 * files.nextElement(); fileName = multi.getFilesystemName(name); }
		 * System.out.println("이미지를 저장하였습니다. : " + fileName); } catch (IOException e) {
		 * System.out.println("안드로이드 부터 이미지를 받아옵니다."); }
		 */
		
		    response.setCharacterEncoding("EUC-KR");
	        PrintWriter out = response.getWriter();
	         
	        String id = request.getParameter("id");
	        System.out.println(id+"잘넘어왔네");
	         
	         
	         
	      /////////////////////////////////////////////////////////////////////////
	         
	         String folderTypePath = "D:\\"+id;
	         
	         File Folder = new File(folderTypePath);
	         


	         // 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
	         if (!Folder.exists()) {
	            try{
	                Folder.mkdir(); //폴더 생성합니다.
	                System.out.println("폴더가 생성되었습니다.");
	                 } 
	                 catch(Exception e){
	                e.getStackTrace();
	            }        
	               }else {
	            System.out.println("이미 폴더가 생성되어 있습니다.");
	         }
	      
	   
	        String name = new String();
	        String fileName = new String();
	        int sizeLimit = 10 * 1024 * 1024; // 5메가까지 제한 넘어서면 예외발생
	 
	        try {
	           MultipartRequest multi = new MultipartRequest(request, folderTypePath, sizeLimit,
	                    new DefaultFileRenamePolicy());
	           
	           
	            Enumeration files = multi.getFileNames();
	 
	            //파일 정보가 있다면
	            if (files.hasMoreElements()) {
	               
	                name = (String) files.nextElement();
	                fileName = multi.getFilesystemName(name);
	                dto = new BookDTO("용감한포도잼", cnt, "");
	                dao.bookinsert(dto);
	                cnt +=1;
	               
	            }
	            System.out.println("이미지를 저장하였습니다. : " + fileName);
	            
	        } catch (IOException e) {
	            System.out.println("안드로이드 부터 이미지를 받아옵니다.");
	        }
	        
	        GoogleVisionApiTester GVA = new GoogleVisionApiTester();
	        GVA.textreturn(folderTypePath + "\\", cnt);


	}

}
