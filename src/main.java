import java.sql.*;
import java.util.*;

import metody.*;
import repo.IRepoArchive;
import repo.IRepo;
import repo.realization.EmployeeBuilder;
import repo.realization.EmployeeRepo;
import repo.realization.modelRepoArchive;
import repo.realization.RepoArchive;
import repo.realization.UserRepo;
import repo.realization.UserBuilder;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;


public class main {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost/metodyDB";
		User jnowak = new User();
		Employee nowak_emp = new Employee();
		Contact nowak_cont = new Contact();
		
		jnowak.setLogin("jnowak");
		jnowak.setPassword("qwerty1234");
		nowak_emp.setFirstName("Janusz");
		nowak_emp.setLastName("Nowak");
		nowak_cont.setEmail("jnowak@alfa.pl");
		nowak_cont.setPhoneNumber("505888501");
		nowak_cont.setCompanyName("Alfa Sp. z o.o.");
		nowak_cont.setRoomNumber("106");
		nowak_cont.setSpecialisation("IT Manager");
		
		
		try{
			Connection connection = DriverManager.getConnection(url, "root", "metody16");
			IUnitOfWork uow = new UnitOfWork(connection);
			
			/*
			String createTableSql = "CREATE TABLE users(id int NOT NULL AUTO_INCREMENT PRIMARY KEY," 
			+ " login VARCHAR(20), password VARCHAR(20))";
			Statement createTable = connection.createStatement();
			createTable.executeUpdate(createTableSql);
			
			String createTableSql = "create table employees(id int not null auto_increment primary key, firstName varchar(20), lastName varchar(20))";
			Statement createTable = connection.createStatement();
			createTable.executeUpdate(createTableSql);
			String createTableSql = "create table contacts(id int not null auto_increment primary key, email varchar(20), phoneNumber varchar(12),"
					+ "companyName varchar(30), roomNumber varchar(3), specialization varchar(20))";
			Statement createTable = connection.createStatement();
			createTable.executeUpdate(createTableSql);
			*/
			IRepoArchive archive = new RepoArchive(connection, uow);
			archive.getUsers().save(jnowak);
			
			List<User> usersInDb = archive.getUsers().getAll();
			
			
			for(User userInDB: usersInDb)
					System.out.println(userInDB.getNumber() + " "
			+ userInDB.getLogin() + " " + userInDB.getPassword());
			
			User u = archive.getUsers().get(3);
			u.setPassword("testowe123");
			archive.getUsers().update(u);
			archive.getUsers().delete(usersInDb.get(0));
			
			for(User userInDB: archive.getUsers().getAll())
				System.out.println(userInDB.getNumber() + " "
						+ userInDB.getLogin() + " " + userInDB.getPassword());
			
		}catch (SQLException e){
			e.printStackTrace();
	
		}
		
	
	System.out.println("koniec bazy");
	}
}
