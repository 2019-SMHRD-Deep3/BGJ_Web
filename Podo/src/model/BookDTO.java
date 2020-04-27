package model;

public class BookDTO {
	
	private String title;
	private int titleNum;
	private String pic;
	private String txt;
	private String voice;
	
	public BookDTO(String title, int titleNum, String pic, String txt, String voice) {
		super();
		this.title = title;
		this.titleNum = titleNum;
		this.pic = pic;
		this.txt = txt;
		this.voice = voice;
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

	public void setPic(String pic) {
		this.pic = pic;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getTitle() {
		return title;
	}

	public int getTitleNum() {
		return titleNum;
	}

	public String getPic() {
		return pic;
	}

	public String getTxt() {
		return txt;
	}

	public String getVoice() {
		return voice;
	}
	
	

}
