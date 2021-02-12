package model;

import java.time.LocalDate;

public class UserAccount {
	
	private String username;
	private String password;
	private String photo;
	private Gender gender;
	private String degree;
	private LocalDate date;
	private Browser browser;
	
	public UserAccount(String user, String pass, String pic, Gender gender, String career, LocalDate dat, Browser brow){
		
		username  = user;
		password = pass;
		this.gender = gender;
		degree = career;
		date = dat;
		browser = brow;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPhoto() {
		return photo;
	}

	public String getPassword() {
		return password;
	}
	

}
