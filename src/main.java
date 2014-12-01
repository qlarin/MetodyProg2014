import java.sql.*;
import java.util.*;

import metody.*;
import repo.IRepoArchive;
import repo.IRepo;
import repo.realization.EmployeeBuilder;
import repo.realization.EmployeeRepo;
import repo.realization.modelRepoArchive;
import repo.realization.UserRepo;
import repo.realization.UserBuilder;


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
		//	IRepo<User> users = new UserRepo(connection, new UserBuilder());
		//	users.save(jnowak);
			IRepo<Employee> employees = new EmployeeRepo(connection, new EmployeeBuilder());
		//	employees.save(nowak_emp);
			
			for(Employee employeeInDB: employees.getAll()){
				System.out.println(employeeInDB.getFirstName() + " " + employeeInDB.getLastName());
			}
		//	List<User> usersInDB= users.getAll();
			
		/*	for(User userInDB: usersInDB)
					System.out.println(userInDB.getNumber() + " "
			+ userInDB.getLogin() + " " + userInDB.getPassword());
		*/	
		
		/*	users.delete(usersInDB.get(0));
		
			User u = users.get(5);
			u.setPassword("test");
			users.update(users.get(5));
		
			
			
			for(User userInDB: users.getAll())
				System.out.println(userInDB.getNumber() + " "
						+ userInDB.getLogin() + " " + userInDB.getPassword());
						
			*/			
		}catch (SQLException e){
			e.printStackTrace();
	
		}
		
	
	
	System.out.println("koniec bazy");
	}
}
