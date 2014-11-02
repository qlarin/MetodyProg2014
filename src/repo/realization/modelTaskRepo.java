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
	
	
	@Override
	public void save(Task unit) {
		
		database.tasks.add(unit);
	}

	@Override
	public void delete(Task unit) {
		
		database.tasks.remove(unit);
	}

	@Override
	public void update(Task unit) {
		
		
	}


	@Override
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
