package repo.realization;

import java.util.*;
import java.sql.*;

import repo.IRepo;
import metody.User;


public class UserRepo implements IRepo<User> {

	private Connection connection;
	
	private String insertSql= "INSERT INTO users(login,password)" + "VALUES(?,?)";
	private String selectByIDSql= "SELECT * FROM users WHERE id=?";
	private String updateSql= "UPDATE users SET (login,password)=(?,?) WHERE id=?";
	private String deleteSql= "DELETE FROM users WHERE id=?";
	private String selectAllSql= "SELECT * FROM users";
	
	private PreparedStatement insert;
	private PreparedStatement selectByID;
	private PreparedStatement update;
	private PreparedStatement delete;
	private PreparedStatement selectAll;
	
	public UserRepo (Connection connection){
		
		this.connection = connection;
		try{
			insert = connection.prepareStatement(insertSql);
			selectByID = connection.prepareStatement(selectByIDSql);
			update = connection.prepareStatement(updateSql);
			delete = connection.prepareStatement(deleteSql);
			selectAll = connection.prepareStatement(selectAllSql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void save(User unit) {

		try{
			insert.setString(1, unit.getLogin());
			insert.setString(2, unit.getPassword());
			insert.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public void delete(User unit) {

		try{
			delete.setInt(1, unit.getNumber());
			delete.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public void update(User unit) {

		try{
			update.setString(1, unit.getLogin());
			update.setString(2,  unit.getPassword());
			update.setInt(3, unit.getNumber());
			update.executeUpdate();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public User get(int id) {

		try{
			selectByID.setInt(1, id);
			ResultSet rs = selectByID.executeQuery();
			while(rs.next()){
				User result = new User();
				result.setNumber(rs.getInt("id"));
				result.setLogin(rs.getString("login"));
				result.setPassword(rs.getString("password"));
				return result;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}

	public List<User> getAll() {

		List<User> result = new ArrayList<User>();
		
		try{
			ResultSet rs= selectAll.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setNumber(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				result.add(user);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		
		return result;
	}
	
	
	
	
	
	
}
