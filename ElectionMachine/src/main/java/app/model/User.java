package app.model;

import java.io.Serializable;

public class User implements Serializable{
	private int user_id;
	private String username;
	private float password;


	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getPassword() {
		return password;
	}
	public void setPassword(float password) {
		this.password = password;
	}
}
