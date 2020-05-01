package model;

public class BookDTO {
	
	private String title;
	private int titleNum;
	private String txt;
	
	public BookDTO(String title, int titleNum, String txt) {
		super();
		this.title = title;
		this.titleNum = titleNum;
		this.txt = txt;
	}

	public BookDTO() {
		// TODO Auto-generated constructor stub
	}

	public BookDTO(String title) {
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTitleNum(int titleNum) {
		this.titleNum = titleNum;
	}



	public void setTxt(String txt) {
		this.txt = txt;
	}



	public String getTitle() {
		return title;
	}

	public int getTitleNum() {
		return titleNum;
	}



	public String getTxt() {
		return txt;
	}


	
	

}
