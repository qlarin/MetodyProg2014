package repo;

import metody.*;

public interface IRepoArchive {

	public IUserRepo getUsers();
	public IRepo<Employee> getEmployees();
	
}
