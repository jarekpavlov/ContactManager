package net.codejava.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

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
	public int update(Contact c) {
		String sql = "UPDATE Contact SET name=?, email=?, adress=?, phone=? WHERE contact_id=?";	
		return	jdbcTemplate.update(sql, c.getName(),c.getEmail(),c.getAdress(),c.getPhone(),c.getId());
	}

	@Override
	public Contact get(Integer id) {
		String sql="SELECT * FROM Contact WHERE contact_id="+id;
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String name=rs.getString("name");
					String email=rs.getString("email");
					String adress=rs.getString("adress");
					String phone=rs.getString("phone");
					return new Contact(id,name,email,adress,phone);
					
				}
				return null;
			}
		};
		return	jdbcTemplate.query(sql, extractor);
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
