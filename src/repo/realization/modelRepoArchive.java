package repo.realization;


import metody.Employee;
import metody.Task;
import repo.IRepo;
import repo.IRepoArchive;
import repo.IUserRepo;


public class modelRepoArchive implements IRepoArchive {

	private modelDatabase database = new modelDatabase();

	public IUserRepo getUsers() {
		
		return new modelUserRepo(database);
	}

	
	public IRepo<Employee> getEmployees() {
		
		return new modelEmployeeRepo(database);
	}
	
	public IRepo<Task> getTasks() {
		
		return new modelTaskRepo(database);
	}
	
	
}
