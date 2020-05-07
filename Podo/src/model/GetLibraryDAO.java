package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetLibraryDAO {

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

	public ArrayList<String> bookselect() {

		ArrayList<String> books = new ArrayList<>();
		String title;

		try {
			getConnection();
			String sql = "select title, MIN(date1) date2 from publicbooks group by title order by date2 asc";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				title = rs.getString(1);

				books.add(title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return books;
	}

}
