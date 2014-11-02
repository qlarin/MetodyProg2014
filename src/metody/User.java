package metody;

import java.util.*;

public class User extends Unit {

	
	private String login;
	private String password;
	private Employee employee;
	
	private List<Task> tasks;
	public User()
	{
		tasks = new ArrayList<Task>();
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
		if(!this.equals(employee.getUser()))
			employee.setUser(this);
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}


