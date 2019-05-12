package entity;

import annotation.Property;
import annotation.SetTable;

@SetTable("user")
public class UserEntity 
{
	@Property(value = "user_name", length = 10)
	private String userName;
	
	@Property(value = "user_age", length = 20)
	private String userAge;

	public UserEntity(String userName, String userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public UserEntity() {
		super();
	}

}
