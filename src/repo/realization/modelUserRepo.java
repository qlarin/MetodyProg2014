package repo.realization;

import java.util.*;

import metody.Task;
import metody.User;
import repo.IUserRepo;

public class modelUserRepo implements IUserRepo {

	private modelDatabase database;
	
	public modelUserRepo(modelDatabase database) {
		super();
		this.database = database;
	}

	
	public void save(User unit) {
		
		database.users.add(unit);
	}

	
	public void delete(User unit) {
		
		database.users.remove(unit);
	}

	
	public void update(User unit) {
		
		
	}

	
	public User get(int id) {
		
		for(User u: database.users)
				if(u.getNumber()==id)
						return u;
		
		return null;
	}

	
	public List<User> getAll() {
		
		return database.users;
	}

	
	public List<User> withTask(Task task) {
		
		return withTask(task.getNumber());
	}

	
	public List<User> withTask(String taskName) {
		
		for(Task t:database.tasks)
			if(t.getName().equals(taskName))
			return t.getUsers();
			return new ArrayList<User>();
	}

	
	public List<User> withTask(int taskNumber) {
		
		for(Task t:database.tasks)
			if(t.getNumber()==taskNumber)
			return t.getUsers();
			return new ArrayList<User>();
	}
	
	
	
	
	
}
