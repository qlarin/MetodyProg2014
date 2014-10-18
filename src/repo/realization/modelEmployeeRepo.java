package repo.realization;

import java.util.*;

import metody.Employee;
import repo.IRepo;

public class modelEmployeeRepo implements IRepo<Employee> {

	private modelDatabase database;

	public modelEmployeeRepo(modelDatabase database) {
		super();
		this.database = database;
	}

	@Override
	public void save(Employee unit) {
		// TODO Auto-generated method stub
		database.employees.add(unit);
	}

	@Override
	public void delete(Employee unit) {
		// TODO Auto-generated method stub
		database.employees.remove(unit);
	}

	@Override
	public void update(Employee unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		for (Employee e: database.employees) 
				if(e.getNumber()==id)
						return e;
		
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return database.employees;
	}
	
	
	
	
}
