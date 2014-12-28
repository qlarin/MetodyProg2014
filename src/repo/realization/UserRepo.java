package repo.realization;

import java.sql.*;
import java.util.*;
import repo.IUserRepo;
import unitofwork.IUnitOfWork;
import metody.Task;
import metody.User;

public class UserRepo extends Repo<User> implements IUserRepo{
	
	public UserRepo(Connection connection, IUnitBuilder<User> builder, IUnitOfWork uow) {
		super(connection, builder, uow);
	}
	
	protected String getTableName() {
		return "users";
	}
	protected String getUpdateQuery() {
		return "UPDATE users SET (login,password)=(?,?) WHERE id=?";
	}
	protected String getInsertQuery() {
		return "INSERT INTO users(login,password) VALUES(?,?)";
	}
	
	protected void setupInsertQuery(User unit) throws SQLException {
		insert.setString(1, unit.getLogin());
		insert.setString(2, unit.getPassword());
	}
	
	protected void setupUpdateQuery(User unit) throws SQLException {
		update.setString(1,  unit.getLogin());
		update.setString(2,  unit.getPassword());
		update.setInt(3,  unit.getNumber());
	}
	
	public List<User> withTask(Task task) {
		return null;
	}
	
	public List<User> withTask(String taskName) {
		return null;
	}
	
	public List<User> withTask(int taskId) {
		return null;
	}
	
}