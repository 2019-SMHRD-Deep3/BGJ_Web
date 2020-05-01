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
	     System.out.println(id+"�߳Ѿ�Գ�");
	      
	      
	      
	   /////////////////////////////////////////////////////////////////////////
	      
	      String folderTypePath = "C:\\Users\\SM025\\git\\BGJ_Web\\Podo\\WebContent\\"+id;
	      
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
                File file = new File(folderTypePath + "\\"+  fileName); 
                file.renameTo(new File(folderTypePath + "\\"+ cnt + ".jpg"));
//                dto = new BookDTO("�밨��������", cnt, folderTypePath + "\\"+ fileName, "", "");
                dto = new BookPrivacyDTO(id , "�밨��������", cnt, "");
                dao.bookinsert(dto);
                
                cnt +=1;


            }
            System.out.println("�̹����� �����Ͽ����ϴ�. : " + fileName);
            
        } catch (IOException e) {
            System.out.println("�ȵ���̵� ���� �̹����� �޾ƿɴϴ�.");
        }
        
        GoogleVisionApiTester2 GVA = new GoogleVisionApiTester2();
        GVA.textreturn(folderTypePath + "\\", cnt);
    
		
	}


}
