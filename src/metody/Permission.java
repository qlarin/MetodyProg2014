package metody;

import java.util.*;

public class Permission extends Unit {

	
	private String name;
	private List<Task> tasks;
	
	public Permission()
	{
		tasks = new ArrayList<Task>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	
	
	
}
