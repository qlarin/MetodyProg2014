package repo.realization;

import java.sql.ResultSet;
import java.sql.SQLException;

import metody.Contact;

public class ContactBuilder  implements IUnitBuilder<Contact>{

	public Contact build(ResultSet rs) throws SQLException {
		Contact contact = new Contact();
		contact.setNumber(rs.getInt("id"));
		contact.setEmail(rs.getString("email"));
		contact.setPhoneNumber(rs.getString("phoneNumber"));
		contact.setCompanyName(rs.getString("companyName"));
		contact.setRoomNumber(rs.getString("roomNumber"));
		contact.setSpecialisation(rs.getString("specialisation"));
		
		return contact;
	}
	
}
