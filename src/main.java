
import java.sql.*;
import java.util.*;
import metody.*;
import repo.IRepoArchive;
import repo.IRepo;
import repo.realization.modelRepoArchive;
import repo.realization.UserRepo;


public class main {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost/metodyDB";
		User jnowak = new User();
		User kkowalski = new User();
		
		jnowak.setLogin("s11617");
		jnowak.setPassword("qwerty1234");
		kkowalski.setLogin("test12");
		kkowalski.setPassword("asdf123");
		try{
			Connection connection = DriverManager.getConnection(url, "root", "metody16");
			/*
			String createTableSql = "CREATE TABLE users(id int NOT NULL AUTO_INCREMENT PRIMARY KEY," 
			+ " login VARCHAR(20), password VARCHAR(20))";
			Statement createTable = connection.createStatement();
			createTable.executeUpdate(createTableSql);
			*/
			IRepo<User> users = new UserRepo(connection);
		//	users.save(jnowak);
		//	users.save(kkowalski);
			List<User> usersInDB= users.getAll();
			
		/*	for(User userInDB: usersInDB)
					System.out.println(userInDB.getNumber() + " "
			+ userInDB.getLogin() + " " + userInDB.getPassword());
		*/	
		
		/*	users.delete(usersInDB.get(0));
		
			User u = users.get(5);
			u.setPassword("test");
			users.update(users.get(5));
		*/	
			
			
			for(User userInDB: users.getAll())
				System.out.println(userInDB.getNumber() + " "
						+ userInDB.getLogin() + " " + userInDB.getPassword());
		}catch (SQLException e){
			e.printStackTrace();
	
		}
	
	System.out.println("koniec bazy");
	}
}
