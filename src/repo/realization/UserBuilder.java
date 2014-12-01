package repo.realization;

import java.sql.ResultSet;
import java.sql.SQLException;

import metody.User;

public class UserBuilder implements IUnitBuilder<User> {
	
	public User build(ResultSet rs) throws SQLException {
		User result = new User();
		result.setNumber(rs.getInt("id"));
		result.setLogin(rs.getString("login"));
		result.setPassword(rs.getString("password"));;
		return result;
	}
}