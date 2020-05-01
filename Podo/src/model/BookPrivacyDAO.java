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
			String sql = "insert into privacybooks values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setInt(3, dto.getTitleNum());
			psmt.setString(4, dto.getTxt());

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

	public ArrayList<BookDTO> bookselect(BookDTO dto) {

		ArrayList<BookDTO> book = new ArrayList<BookDTO>();
		
		BookDTO info = null;
		String title = null;
		int titleNum = 0;
		String txt = null;

		try {
			getConnection();
			String sql = "select * from privacybooks where title =? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle()); 

			rs = psmt.executeQuery();

			while (rs.next()) {
				title = rs.getString(1); 
				titleNum = rs.getInt(2);
				txt = rs.getString(3);

				info = new BookDTO(title, titleNum, txt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return book;
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
