package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import GoogleVisionAPITester.GoogleVisionApiTester2;
import model.BookDAO;
import model.BookDTO;
import model.BookPrivacyDAO;
import model.BookPrivacyDTO;

/**
 * Servlet implementation class Audio
 */
@WebServlet("/AudioPrivacy")
public class AudioPrivacy extends HttpServlet {
	
	BookPrivacyDAO dao = new BookPrivacyDAO();
	BookPrivacyDTO dto = new BookPrivacyDTO();
	int cnt = 0;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("EUC-KR");
	    PrintWriter out = response.getWriter();
	      
	     String id = request.getParameter("id");
	     System.out.println(id+"잘넘어왔네");
	      
	      
	      
	   /////////////////////////////////////////////////////////////////////////
	      
	      String folderTypePath = "C:\\Users\\SM025\\git\\BGJ_Web\\Podo\\WebContent\\"+id;
	      
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
                File file = new File(folderTypePath + "\\"+  fileName); 
                file.renameTo(new File(folderTypePath + "\\"+ cnt + ".jpg"));
//                dto = new BookDTO("용감한포도잼", cnt, folderTypePath + "\\"+ fileName, "", "");
                dto = new BookPrivacyDTO(id , "용감한포도잼", cnt, "");
                dao.bookinsert(dto);
                
                cnt +=1;


            }
            System.out.println("이미지를 저장하였습니다. : " + fileName);
            
        } catch (IOException e) {
            System.out.println("안드로이드 부터 이미지를 받아옵니다.");
        }
        
        GoogleVisionApiTester2 GVA = new GoogleVisionApiTester2();
        GVA.textreturn(folderTypePath + "\\", cnt);
    
		
	}


}
