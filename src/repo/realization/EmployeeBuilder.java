package repo.realization;

import java.sql.ResultSet;
import java.sql.SQLException;

import metody.Employee;

public class EmployeeBuilder  implements IUnitBuilder<Employee>{

	public Employee build(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setNumber(rs.getInt("id"));
		employee.setFirstName(rs.getString("firstName"));
		employee.setLastName(rs.getString("lastName"));
		
		return employee;
	}
	
}
