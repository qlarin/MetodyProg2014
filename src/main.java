

import metody.*;
import repo.IRepoArchive;
import repo.realization.modelRepoArchive;



public class main {

	public static void main(String[] args) {
		

		IRepoArchive archive = new modelRepoArchive();
		
		Employee tomasz = new Employee();
		tomasz.setFirstName("Tomasz");
		tomasz.setLastName("Kowalski");
		
		archive.getEmployees().save(tomasz);
		
		User tkowalski = new User();
		tkowalski.setLogin("tkowalski");
		tkowalski.setPassword("password");
		archive.getUsers().save(tkowalski);
		
		Task admin = new Task();
		admin.setName("administrator");
		archive.getTasks().save(admin);
		
		tomasz.setUser(tkowalski);
		tkowalski.getTasks().add(admin);
		admin.getUsers().add(tkowalski);
		
		for(User user: archive.getUsers().withTask("administrator"))
			System.out.println(user.getLogin());
		
	}

}
