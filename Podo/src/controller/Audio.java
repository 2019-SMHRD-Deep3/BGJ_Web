package controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.BookDAO;
import model.BookDTO;

/**
 * Servlet implementation class Audio
 */
@WebServlet("/Audio")
public class Audio extends HttpServlet {
	
	BookDAO dao = new BookDAO();
	BookDTO dto = new BookDTO();
	int cnt = 0;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hi");
		System.out.println(cnt);
        //�̹����� ������ ��� �Է�.
        String folderTypePath = "D:\\ttt";
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
                dto = new BookDTO("�밨��������", cnt, "D:/ttt/" + fileName, "", "");
                dao.bookinsert(dto);
                cnt +=1;
               
            }
            System.out.println("�̹����� �����Ͽ����ϴ�. : " + fileName);
            
        } catch (IOException e) {
            System.out.println("�ȵ���̵� ���� �̹����� �޾ƿɴϴ�.");
        }
       
    
		
	}
	
	

}
