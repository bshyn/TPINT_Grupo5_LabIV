package Model;

public class Login {
	private int id;
	private String userLogin;
	private String password;
	private boolean statusLogin;

	public Login(String userLogin, String password, boolean statusLogin) {
		super();
		this.userLogin = userLogin;
		this.password = password;
		this.statusLogin = statusLogin;
	}

	public Login(int id, String userLogin, String password, boolean statusLogin) {
		super();
		this.id = id;
		this.userLogin = userLogin;
		this.password = password;
		this.statusLogin = statusLogin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(boolean statusLogin) {
		this.statusLogin = statusLogin;
	}
	
	
}
