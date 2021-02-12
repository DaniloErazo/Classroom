package model;

import java.time.LocalDate;
import java.util.ArrayList;


public class Classroom {
	
	private ArrayList<UserAccount> accounts;
	
	public Classroom() {
		accounts = new ArrayList<UserAccount>();
	}
	
	public void addAccount(String user, String pass, String pic, String gender, String career, LocalDate date, String brow) {
		
		Gender aGender = Gender.valueOf(gender);
		Browser aBrowser = Browser.valueOf(brow);
		UserAccount newUserAccount = new UserAccount(user, pass, pic, aGender, career, date, aBrowser);
		
		accounts.add(newUserAccount);
			
	}
	
	public boolean searchForAccount (String username) {
		boolean found = false;
		
		for (int i = 0; i < accounts.size() && !found ; i++) {
			if(accounts.isEmpty()) {
				found=false;
			}else if (accounts.get(i).getUsername().equals(username)) {
					found=true;
			}
		}
		
		return found;
	}
	
	public boolean verifyPassword(String pss, String user) {
		
		boolean right = false;
		
		for (int i = 0; i < accounts.size() && !right ; i++) {
			 if (accounts.get(i).getUsername().equals(user)) {
				 if(accounts.get(i).getPassword().equals(pss)) {
					 right=true;
				 }
			}
		}
		
		return right;
	}
}
