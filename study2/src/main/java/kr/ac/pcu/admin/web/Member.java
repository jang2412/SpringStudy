package kr.ac.pcu.admin.web;

public class Member {

	//	멤버변수의 코드 스타일
	private String id="";
	private String name="";
	private int point;
	private String birth="";
	private String tel="";
	private String address="";
	private String localeCd="";
	private String regDate="";
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocaleCd() {
		return localeCd;
	}
	public void setLocaleCd(String localeCd) {
		this.localeCd = localeCd;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}
