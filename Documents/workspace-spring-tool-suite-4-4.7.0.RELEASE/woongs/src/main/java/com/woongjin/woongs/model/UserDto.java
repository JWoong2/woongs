package com.woongjin.woongs.model;

import java.util.Date;

public class UserDto {
	private int no;
	private String email;
	private String user_id;
	private String password;
	private String user_name;
	private String nick_name;
	private Date reg_Date;
	private Date birth;
	private int gender;
	private String image;
	private String favoriate;
	private int cash;
	private int point;
	private int date;
	private char status;
	private int isAdmin;
	
	
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public Date getReg_Date() {
		return reg_Date;
	}
	public void setReg_Date(Date reg_Date) {
		this.reg_Date = reg_Date;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFavoriate() {
		return favoriate;
	}
	public void setFavoriate(String favoriate) {
		this.favoriate = favoriate;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "UserDto [no=" + no + ", email=" + email + ", password=" + password + ", user_name=" + user_name
				+ ", nick_name=" + nick_name + ", reg_Date=" + reg_Date + ", birth=" + birth + ", gender=" + gender
				+ ", image=" + image + ", favoriate=" + favoriate + ", cash=" + cash + ", point=" + point + ", date="
				+ date + ", status=" + status + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
}