package metody;

import java.util.List;
import java.util.ArrayList;

public class Employee extends Unit {

	public Employee() {
			super();
			this.contacts = new ArrayList<Contact>();
	}
	
	private String firstName;
	private String lastName;
	private String id;
	
	private User user;
	private List<Contact> contacts;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
		
	
}
