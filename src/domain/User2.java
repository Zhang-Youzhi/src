package domain;

public class User2 {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User2 [ password=" + password
				+ ", username=" + username + "]";
	}
	public User2() {
		super();
	}
	public User2( String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
