package repo.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import metody.Employee;
import repo.IRepo;

public class EmployeeRepo extends Repo<Employee>{

	public EmployeeRepo(Connection connection, IUnitBuilder<Employee> builder) {
		super(connection, builder);
	}
	
	protected void setupUpdateQuery(Employee unit) throws SQLException {
		update.setString(1, unit.getFirstName());
		update.setString(2, unit.getLastName());
		update.setInt(3, unit.getNumber());
	}
	
	protected void setupInsertQuery(Employee unit) throws SQLException {
		insert.setString(1, unit.getFirstName());
		insert.setString(2, unit.getLastName());	
	}
	
	protected String getTableName() {
		return "employees";
	}
	
	protected String getUpdateQuery() {
		return "update employees set (firstName, lastName)=(?,?) where id=?";
		
	}
	
	protected String getInsertQuery() {
		return "insert into employees(firstName, lastName) values(?,?)";
	}
	
}
