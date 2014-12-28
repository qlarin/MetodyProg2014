package repo.realization;

import java.util.*;

import metody.Contact;
import repo.IRepo;

public class modelContactRepo implements IRepo<Contact> {

	private modelDatabase database;

	public modelContactRepo(modelDatabase database) {
		this.database = database;
	}

	
	public void save(Contact unit) {
		// TODO Auto-generated method stub
		database.contacts.add(unit);
	}

	
	public void delete(Contact unit) {
		// TODO Auto-generated method stub
		database.contacts.remove(unit);
	}

	
	public void update(Contact unit) {
		// TODO Auto-generated method stub
		
	}

	
	public Contact get(int id) {
		// TODO Auto-generated method stub
		for (Contact e: database.contacts) 
				if(e.getNumber()==id)
						return e;
		
		return null;
	}

	
	public List<Contact> getAll() {
		// TODO Auto-generated method stub
		return database.contacts;
	}
	
		
}