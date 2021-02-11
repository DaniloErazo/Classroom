package model;

import java.util.ArrayList;


public class Classroom {
	
	private ArrayList<UserAccount> accounts;
	
	public Classroom() {
		
	}
	
	public void addAccount(String user, String pass, String pic, String gender, String career, String date, String brow) {
		
		Gender aGender = Gender.valueOf(gender);
		Browser aBrowser = Browser.valueOf(brow);
		UserAccount newUserAccount = new UserAccount(user, pass, pic, aGender, career, date, aBrowser);
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i)==null) {
				accounts.add(newUserAccount);
			}
		}
	}
	
	public boolean searchForAccount (String username) {
		boolean found = false;
		
		for (int i = 0; i < accounts.size() && !found ; i++) {
			if (accounts.get(i).getUsername().equals(username)) {
				found=true;
			}
		}
		
		return found;
	}
}
