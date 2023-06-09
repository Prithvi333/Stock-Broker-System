package main.sbs.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
	String firstName;
	String lastName;
	String userName;
	String passWord;
	String email;
	long mobNumber;
	String address;
	String status;

	public User() {

	}

	public User(String firstName, String lastName, String userName, String passWord, String email, long mob,
			String address, String status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.mobNumber = mob;
		this.address = address;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setFirstName(String fname) {
		this.firstName = fname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lname) {
		this.lastName = lname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setUserName(String uname) {
		this.userName = uname;
	}

	public String getUserName() {
		return userName;
	}

	public void setpassWord(String password) {
		this.passWord = password;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setEMail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setMoblileNumber(long mob) {
		this.mobNumber = mob;
	}

	public long getMobileNumber() {
		return mobNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String toString() {
		return "UserName- " + userName + ", Password- " + passWord + ", Email- " + email + ", Address- " + address;
	}
}
