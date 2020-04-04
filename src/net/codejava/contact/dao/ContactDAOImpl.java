package net.codejava.contact.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;

	public ContactDAOImpl(DataSource dataSource) {
	
		this.jdbcTemplate=new JdbcTemplate(dataSource);
}
	
	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO Contact (name, email, adress, phone) VALUES (?,?,?,?)";	
		return	jdbcTemplate.update(sql, c.getName(),c.getEmail(),c.getAdress(),c.getPhone());

	}

	@Override
	public int update(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.List<Contact> List() {
		// TODO Auto-generated method stub
		return null;
	}

}
