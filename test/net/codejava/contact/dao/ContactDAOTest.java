package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	private void setupBeforeEach() {
		dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("pit_bull");
		
		dao=new ContactDAOImpl(dataSource);
	
	}

	@Test
	void testSave() {

		Contact contact = new Contact("Bill", "bill@alan.com","WA","987654321");
		int result = dao.save(contact);
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {

		Contact contact = new Contact(18, "Bill", "bill@microsoft.com","WA","987654321");
		int result = dao.update(contact);
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		int id=18;
		Contact contact=dao.get(id);
		if (contact != null) {
			System.out.println(contact);
		}
		assertNotNull(contact);
		
		
	}

	@Test
	void testDelete() {
		int id = 18;
		int result = dao.delete(id);
		assertTrue(result>0);
		
	}

	@Test
	void testList() {
		
		List<Contact> listContact=dao.List();
		for(Contact Contacta:listContact) {
			System.out.println(Contacta);
		}
		assertTrue(!listContact.isEmpty());
	}

}
