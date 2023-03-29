package main.sbs.entity;

public class User {
     
	String userName;
	String passWord;
	String email;
	String address;
	
	public User() {
		
	}
	
	public User (String userName,String passWord,String email,String address) {
		this.userName=userName;
		this.passWord=passWord;
		this.email=email;
		this.address=address;
	}
	
	public void setUserName(String uname) {
		this.userName=uname;
	}
	public String getUserName() {
		return userName;
	}
	public void setpassWord(String password) {
		this.passWord=password;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setEMail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public String getAddress() {
		return address;
	}
	public String toString() {
		return "UserName- " + userName + ", Password- " + passWord + ", Email- " + email + ", Address- " + address;
	}
}
