package model;

public class BookPrivacyDTO {
	private String id;
	private String title;
	private int num;
	private int titleNum;
	private String txt;
	
	public BookPrivacyDTO(String id, String title, int num, int titleNum, String txt) {
		this.id = id;
		this.title = title;
		this.num = num;
		this.titleNum = titleNum;
		this.txt = txt;
	}
	
	public BookPrivacyDTO(String title, int num, int titleNum, String txt) {
		this.title = title;
		this.num = num;
		this.titleNum = titleNum;
		this.txt = txt;
	}
	
	public BookPrivacyDTO(String id, String title) {
		this.id = id;
		this.title = title;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BookPrivacyDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookPrivacyDTO(String title) {
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
