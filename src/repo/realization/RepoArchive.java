package repo.realization;

import java.sql.Connection;

import metody.Employee;
import metody.Task;
import repo.IRepo;
import repo.IRepoArchive;
import repo.IUserRepo;
import unitofwork.IUnitOfWork;



public class RepoArchive implements IRepoArchive {

	private Connection connection;
	private IUnitOfWork uow;
	
	public RepoArchive(Connection connection, IUnitOfWork uow) {
		super();
		this.connection = connection;
		this.uow = uow;
	}
	
	public IUserRepo getUsers() {
		return new UserRepo(connection, new UserBuilder(), uow);
	}
	public IRepo<Employee> getEmployees() {
		return new EmployeeRepo(connection, new EmployeeBuilder(), uow);
	}
	public IRepo<Task> getTasks(){
		return null;
	}
	
	
}
