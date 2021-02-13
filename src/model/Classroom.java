package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Classroom {
	
	private static List<UserAccount> accounts;
	
	public Classroom() {
		accounts = new ArrayList<UserAccount>();
	}
	
	public static List<UserAccount> getAccounts(){
		return accounts;
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
	
	public String getUserImage(String username) {
		String imagePath = "";
		
		for (int i = 0; i < accounts.size() ; i++) {
			UserAccount auxAccount = accounts.get(i);
			 if (auxAccount.getUsername().equals(username)) {
				 imagePath= auxAccount.getPhoto();
			}
		}
		
		return imagePath;
	}
	
	public boolean verifyPassword(String pss, String user) {
		
		boolean right = false;
		
		for (int i = 0; i < accounts.size() ; i++) {
			UserAccount auxAccount = accounts.get(i);
			 if (auxAccount.getUsername().equals(user)) {
				 if(auxAccount.getPassword().equals(pss)) {
					 right=true;
				 }
			}
		}
		
		return right;
	}
}
