package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAO {

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

	public void bookinsert(BookDTO dto) {
		try {
			getConnection();
			String sql = "insert into publicbooks values(?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getTitle());
			psmt.setInt(2, dto.getTitleNum());
			psmt.setString(3, dto.getPic());
			psmt.setString(4, dto.getTxt());
			psmt.setString(5, dto.getVoice());

			int cnt = psmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("å��� ����");
			} else {
				System.out.println("å��� ����");
			}
		}

		catch (SQLException e) {

			e.printStackTrace();

		} finally {

			close();

		}
	}

	public ArrayList<BookDTO> bookselect(BookDTO dto) {

		ArrayList<BookDTO> bookpath = new ArrayList<BookDTO>();
		
		BookDTO info = null;

		String title = null;
		int titleNum = 0;
		String pic = null;
		String txt = null;
		String voice = null;

		try {
			getConnection();
			String sql = "select * from publicbooks where title =? ";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle()); 

			rs = psmt.executeQuery();

			while (rs.next()) {
				title = rs.getString(1); 
				titleNum = rs.getInt(2);
				pic = rs.getString(3);
				txt = rs.getString(4);
				voice = rs.getString(5);

				info = new BookDTO(title, titleNum, pic, txt, voice);
				bookpath.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return bookpath;
	}
	
	public int bookupdate(int titlenum, String text ) { 
		
	
		int cnt = 0;
		try {
			getConnection();
			String sql = "update publicbooks set txt = ? where titlenum = ?";
			System.out.println("titlenum : " + titlenum);
			System.out.println("text : " +text);
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