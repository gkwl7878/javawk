package kr.co.sist.lunch.admin.vo;

public class AdminLoginVO {
	private String id, pass;

	public AdminLoginVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}
	
}//AdminLoginVO 
