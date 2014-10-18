
import java.util.*;
import metody.User;
import repo.IRepoArchive;
import repo.realization.modelRepoArchive;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IRepoArchive archive = new modelRepoArchive();
		List<User> managers = archive.getUsers().withTask("manager");
		
	}

}
