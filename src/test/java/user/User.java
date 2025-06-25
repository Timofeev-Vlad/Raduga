package user;

public class User {

	private String password;
	private String name;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
}
