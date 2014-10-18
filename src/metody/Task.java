package metody;


import java.util.*;

public class Task extends Unit {

	private String name;
	
	private List<Permission> permissions;
	private List<User> users;
	
	public Task()
	{
		permissions = new ArrayList<Permission>();
		users = new ArrayList<User>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
