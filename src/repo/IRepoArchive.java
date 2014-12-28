package repo;

import metody.*;

public interface IRepoArchive {

	public IUserRepo getUsers();
	public IRepo<Employee> getEmployees();
	public IRepo<Contact> getContacts();
	public IRepo<Task> getTasks();
	
}
