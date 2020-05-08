package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import GoogleVisionAPITester.GoogleVisionApiTester2;
import model.BookPrivacyDAO;
import model.BookPrivacyDTO;

/**
 * Servlet implementation class Audio
 */
@WebServlet("/AudioPrivacy")

public class AudioPrivacy extends HttpServlet {
	
	BookPrivacyDAO dao = new BookPrivacyDAO();
	BookPrivacyDTO dto = new BookPrivacyDTO();
	
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    int cnt = Integer.parseInt(request.getParameter("cnt"));
	    String id = request.getParameter("id");
	    String title = request.getParameter("title");
	    System.out.println(id+"�߳Ѿ�Գ�");
	    System.out.println("title ��" + title);
	    System.out.println("���������������");
	      
	      
	      
	   /////////////////////////////////////////////////////////////////////////
	    dto = new BookPrivacyDTO(id, title);
	    
	    
        int num = dao.bookNumselect(id,title).size();
        System.out.println(num+"�־ȳ���?");
        
	      String folderTypePath = "C:\\Users\\SM016\\git\\BGJ_Web\\Podo\\WebContent\\"+id;
	      String folderTypePath2 = folderTypePath+"\\"+id+"_"+num;
	      
	      File Folder = new File(folderTypePath);
	      File Folder2 = new File(folderTypePath2);


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
	      
	      if (!Folder2.exists()) {
	    	  
		         try{
		             Folder2.mkdir(); //���� �����մϴ�.
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
        	MultipartRequest multi = new MultipartRequest(request, folderTypePath2, sizeLimit,
                    new DefaultFileRenamePolicy());
        	
           
            Enumeration files = multi.getFileNames();
 
            //���� ������ �ִٸ�
            if (files.hasMoreElements()) {
            	
                name = (String) files.nextElement();
                fileName = multi.getFilesystemName(name);
                File file = new File(folderTypePath2 + "\\"+  fileName); 
                file.renameTo(new File(folderTypePath2 + "\\"+ cnt + ".jpg"));
//                dto = new BookDTO("�밨��������", cnt, folderTypePath + "\\"+ fileName, "", "");
                
                System.out.println("num" + num);
                dto = new BookPrivacyDTO(id, title, num, cnt, "");
                dao.bookinsert(dto);
                
                //cnt -=1;


            }
            System.out.println("�̹����� �����Ͽ����ϴ�. : " + fileName);
            
        } catch (IOException e) {
            System.out.println("�ȵ���̵� ���� �̹����� �޾ƿɴϴ�.");
        }
        
        GoogleVisionApiTester2 GVA = new GoogleVisionApiTester2();
        GVA.textreturn(folderTypePath2 + "\\", cnt);
    
		
	}


}
