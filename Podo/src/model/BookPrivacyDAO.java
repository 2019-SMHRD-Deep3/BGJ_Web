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
			String sql = "insert into privacybooks values(?,?,?,?,?,sysdate)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setInt(3, dto.getTitleNum());
			psmt.setInt(4, dto.getNum());
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

	public ArrayList<String> bookNumselect(String id,String titlee) {

		/* ArrayList<BookPrivacyDTO> book = new ArrayList<BookPrivacyDTO>(); */
		
	
		String title = "";
		String id2 = id;
		if(id.equals("")) {
			id2 = "호롤롤롤";
		}
	
		ArrayList<String> titles = new ArrayList<>();
		
		try {
			getConnection();
			String sql = "select title,max(date2) date3 from privacybooks where id=? and title!=? group by title order by date3 asc";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id2);
			psmt.setString(2, titlee);
			rs = psmt.executeQuery();
			
			
				while (rs.next()) {
					title = rs.getString(1);
					
					
					titles.add(title);
				}

				
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		

		return titles;
	}

	public int bookupdate(int num, String text) {

		int cnt = 0;
		try {
			getConnection();
			String sql = "update privacybooks set txt = ? where num = ?";
			System.out.println("titlenum : " + num);
			System.out.println("text : " + text);
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, text);
			psmt.setInt(2, num);

			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<String> findbook(BookPrivacyDTO dto) {

		ArrayList<String> book = new ArrayList<String>();
		
		try {
			getConnection();
			String sql = "select * from privacybooks where id = ? and title = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());

			rs = psmt.executeQuery();
			
			while(rs.next()) {
				book.add(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return book;
	}

}
