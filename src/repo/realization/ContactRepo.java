package repo.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import metody.Contact;
import repo.IRepo;
import unitofwork.IUnitOfWork;

public class ContactRepo extends Repo<Contact>{

	protected ContactRepo(Connection connection, IUnitBuilder<Contact> builder, IUnitOfWork uow) {
		super(connection, builder, uow);
	}
	
	protected void setupUpdateQuery(Contact unit) throws SQLException {
		update.setString(1, unit.getEmail());
		update.setString(2, unit.getPhoneNumber());
		update.setString(3, unit.getCompanyName());
		update.setString(4, unit.getRoomNumber());
		update.setString(5, unit.getSpecialisation());
		update.setInt(6,  unit.getNumber());
	}
	
	protected void setupInsertQuery(Contact unit) throws SQLException {
		insert.setString(1, unit.getEmail());
		insert.setString(2, unit.getPhoneNumber());
		insert.setString(3, unit.getCompanyName());
		insert.setString(4, unit.getRoomNumber());
		insert.setString(5, unit.getSpecialisation());
	}
	
	protected String getTableName() {
		return "contacts";
	}
	
	protected String getUpdateQuery() {
		return "update contacts set (email, phoneNumber, companyName, roomNumber, specialization)=(?,?,?,?,?) where id=?";
		
	}
	
	protected String getInsertQuery() {
		return "insert into contacts(email, phoneNumber, companyName, roomNumber, specialization) values(?,?,?,?,?)";
	}
	
}
