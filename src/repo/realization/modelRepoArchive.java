package repo.realization;

import java.util.*;
import metody.Employee;
import repo.IRepo;
import repo.IRepoArchive;
import repo.IUserRepo;


public class modelRepoArchive implements IRepoArchive {

	private modelDatabase database = new modelDatabase();

	@Override
	public IUserRepo getUsers() {
		// TODO Auto-generated method stub
		return new modelUserRepo(database);
	}

	@Override
	public IRepo<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return new modelEmployeeRepo(database);
	}
	
	
	
}
