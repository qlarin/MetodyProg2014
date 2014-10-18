package repo.realization;

import java.util.*;

import metody.Task;
import metody.User;
import metody.Unit;
import repo.IUserRepo;

public class modelUserRepo implements IUserRepo {

	private modelDatabase database;
	
	public modelUserRepo(modelDatabase database) {
		super();
		this.database = database;
	}

	@Override
	public void save(User unit) {
		// TODO Auto-generated method stub
		database.users.add(unit);
	}

	@Override
	public void delete(User unit) {
		// TODO Auto-generated method stub
		database.users.remove(unit);
	}

	@Override
	public void update(User unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		for(User u: database.users)
				if(u.getNumber()==id)
						return u;
		
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return database.users;
	}

	@Override
	public List<User> withTask(Task task) {
		// TODO Auto-generated method stub
		return withTask(task.getNumber());
	}

	@Override
	public List<User> withTask(String taskName) {
		// TODO Auto-generated method stub
		for(Task r:database.tasks)
			if(r.getName().equals(taskName))
			return r.getUsers();
			return new ArrayList<User>();
	}

	@Override
	public List<User> withTask(int taskNumber) {
		// TODO Auto-generated method stub
		for(Task r:database.tasks)
			if(r.getNumber()==taskNumber)
			return r.getUsers();
			return new ArrayList<User>();
	}
	
	
	
	
	
}
