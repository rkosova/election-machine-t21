package elmachine.register.bean;
 
public class RegisterBean {
	public RegisterBean() {}
	public RegisterBean(int userID, String firstName, String lastName, String role, String email,  String userName, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	public RegisterBean(String firstName, String lastName, String role, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	
 private String firstName;
 private String lastName;
 private int userID;
 private String role;
 private String email;
 private String userName;
 private String password;
 
 public String getUserName() {
 return userName;
 }
 public int getUserID() {
	 return userID;
	 }
 public void setUserID(int userID) {
 this.userID = userID;
 }
 public void setUserName(String userName) {
 this.userName = userName;
 }
 public String getRole() {
 return role;
 }
 public void setRole(String role) {
 this.role = role;
 }
 public String getPassword() {
 return password;
 }
 public void setPassword(String password) {
 this.password = password;
 }
 public void setFirstName(String firstName) {
 this.firstName = firstName;
 }
 public String getFirstName() {
 return firstName;
 }
 public void setLastName(String lastName) {
 this.lastName = lastName;
 }
 public String getLastName() {
 return lastName;
 }
 public void setEmail(String email) {
 this.email = email;
 }
 public String getEmail() {
 return email;
 }
}