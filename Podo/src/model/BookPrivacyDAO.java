package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookPrivacyDAO {

	private PreparedStatement psmt;
	private Connection conn;
	private ResultSet rs;
	private boolean result;

	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "hr";
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void bookinsert(BookPrivacyDTO dto) {
		try {
			getConnection();
			String sql = "insert into privacybooks values(?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setInt(3, dto.getNum());
			psmt.setInt(4, dto.getTitleNum());
			psmt.setString(5, dto.getTxt());

			int cnt = psmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("책등록 성공");
			} else {
				System.out.println("책등록 실패");
			}
		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}
	}

	public int bookNumselect(BookPrivacyDTO dto) {

		/* ArrayList<BookPrivacyDTO> book = new ArrayList<BookPrivacyDTO>(); */
		int num = 0;
		
		BookDTO info = null;
		String title = null;
		int titleNum = 0;
		String txt = null;
	
		try {
			getConnection();
			String sql = "select * from privacybooks where id=? and title=?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); 
			psmt.setString(2, dto.getTitle()); 
			
			rs = psmt.executeQuery();
			if(!rs.next()) {
				
			}else if (rs.next()) {
				title = rs.getString(2); 
				num = rs.getInt(3);
				titleNum = rs.getInt(4);
				txt = rs.getString(5);
			

				//info = new BookDTO(title, titleNum, txt);
				num++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return num;
	}
	
	public int bookupdate(int titlenum, String text ) { 
		
	
		int cnt = 0;
		try {
			getConnection();
			String sql = "update privacybooks set txt = ? where titlenum = ?";
			System.out.println("titlenum : " + titlenum);
			System.out.println("text : " + text);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, text);
			psmt.setInt(2, titlenum);
			

			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

}
