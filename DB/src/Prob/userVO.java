package Prob;

public class userVO {
	private String id;
	private String pw;
	private String name;
	private String role;
	
	public userVO() {
		super();
	}
	public userVO(String id, String pw, String name, String role) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "userVO [id=" + id + ", pw=" + pw + ", name=" + name + ", role=" + role + "]";
	}
}
