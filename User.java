import java.io.*;

public class User implements Serializable  {
	protected String FirstName;
	protected String LastName;
	protected String UserName;
	protected String Password;
	
	//Standard Constructor
	public User() {
	}
	
	public User(String UN, String Pass) {
		this.UserName = UN;
		this.Password = Pass;
	}
	//Use 'super' keyword to call this in Student
	//Student Constructor
	public User(String FN, String LN, String UN, String Pass) {
		this.FirstName = FN;
		this.LastName = LN;
		this.UserName = UN;
		this.Password = Pass;
	}
	
//Mutators below
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
