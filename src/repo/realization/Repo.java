package repo.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import repo.IRepo;
import metody.Unit;



public abstract class Repo<TUnit extends Unit> implements IRepo<TUnit> {

	protected Connection connection;
	protected PreparedStatement selectByID;
	protected PreparedStatement insert;
	protected PreparedStatement delete;
	protected PreparedStatement update;
	protected PreparedStatement selectAll;
	protected IUnitBuilder<TUnit> builder;
	
	protected String selectByIDSql= "select * from getTableName() where id=?";
	protected String deleteSql= "delete from getTableName() where id=?";
	protected String selectAllSql= "select * from getTableName()";
	
	protected abstract void setupUpdateQuery(TUnit unit) throws SQLException;
	protected abstract void setupInsertQuery(TUnit unit) throws SQLException;
	protected abstract String getTableName();
	protected abstract String getUpdateQuery();
	protected abstract String getInsertQuery();
	
	protected Repo(Connection connection, IUnitBuilder<TUnit> builder)
	{
		this.builder = builder;
		this.connection = connection;
		try {
			selectByID= connection.prepareStatement(selectByIDSql);
			insert= connection.prepareStatement(getInsertQuery());
			delete= connection.prepareStatement(deleteSql);
			update= connection.prepareStatement(getUpdateQuery());
			selectAll= connection.prepareStatement(selectAllSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void save(TUnit unit) {
		
		try {
			 setupInsertQuery(unit);
			 insert.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public void update(TUnit unit) {
		
		try {
			 setupUpdateQuery(unit);
			 update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
public void delete(TUnit unit) {
	
	try {
		 delete.setInt(1, unit.getNumber());
		 delete.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
public TUnit get(int id) {
	
	try {
		 selectByID.setInt(1,  id);
		 ResultSet rs = selectByID.executeQuery();
		 while(rs.next())
		 {
			 return builder.build(rs);
		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}	
	
	public List<TUnit> getAll() {
		List<TUnit> result = new ArrayList<TUnit>();
		
		try {
			ResultSet rs = selectAll.executeQuery();
			while(rs.next())
			{
				result.add(builder.build(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}



}
