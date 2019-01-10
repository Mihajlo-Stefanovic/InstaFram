package model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 4205334678817897633L;
	private String userName;
	private String password;
	private boolean isAdmin;
	
	public User(String userName, String password, boolean isAdmin) {
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User oth = (User) obj;
			if(oth.getUserName().equals(userName) && oth.getPassword().equals(password) && oth.isAdmin == this.isAdmin)
				return true;
		}
		return false;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean admin) {
		this.isAdmin = admin;
	}
	
}
