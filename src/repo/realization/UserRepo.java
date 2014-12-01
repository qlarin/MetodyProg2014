package repo.realization;

import java.sql.*;
import metody.User;

public class UserRepo extends Repo<User>{
	
	protected String insertSql= "insert into users(login, password) values(?,?)";
	protected String updateSql= "update users set (login, password)=(?,?) where id=?";
	
	public UserRepo(Connection connection, IUnitBuilder<User> builder) {
		super(connection, builder);
	}
	
	protected String getTableName() {
		return "users";
	}
	protected String getUpdateQuery() {
		return updateSql;
	}
	protected String getInsertQuery() {
		return insertSql;
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
	
	
	
}