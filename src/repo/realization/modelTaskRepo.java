package repo.realization;

import java.util.*;

import metody.Task;
import repo.IRepo;


public class modelTaskRepo implements IRepo<Task> {

	modelDatabase database;
	
	public modelTaskRepo(modelDatabase database){
		super();
		this.database = database;
		
	}
	
	
	public void save(Task unit) {
		
		database.tasks.add(unit);
	}

	public void delete(Task unit) {
		
		database.tasks.remove(unit);
	}

	public void update(Task unit) {
		
		
	}


	public List<Task> getAll() {
		
		return database.tasks;
	}

	public Task get(int id) {
		for(Task t : database.tasks)
			if(t.getNumber()==id)
				return t;
		return null;
		
	}
	
	
}
