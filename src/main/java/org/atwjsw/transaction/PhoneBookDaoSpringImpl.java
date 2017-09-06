package org.atwjsw.transaction;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PhoneBookDaoSpringImpl implements PhoneBookDao {

	private final JdbcTemplate jdbcTemplate;
	
	public PhoneBookDaoSpringImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean create(PhoneEntry entry) {
		int rowCount = jdbcTemplate.update("insert into PhoneBook values (?,?,?)",
				new Object[] { entry.getPhoneNumber(), entry.getFirstName(),
						entry.getLastName() });
		return rowCount == 1;
	}

	@Override
	public boolean update(PhoneEntry entry) {
		return jdbcTemplate.update("update PhoneBook set fname=?, lname=? where num=?",
				new Object[] { entry.getFirstName(),
						entry.getLastName(),entry.getPhoneNumber() }) == 1;
	}

	@Override
	public List<PhoneEntry> searchByNumber(String number) {
		return jdbcTemplate.query("SELECT * FROM PhoneBook where num=?", new Object[] { number}, new PhoneEntryRowMapper());
	}

	@Override
	public List<PhoneEntry> searchByFirstName(String firstName) {
		return jdbcTemplate.query("SELECT * FROM PhoneBook where fname=?", new Object[] { firstName}, new PhoneEntryRowMapper());
	}

	@Override
	public List<PhoneEntry> searchByLastName(String lastName) {
		return jdbcTemplate.query("SELECT * FROM PhoneBook where lname=?", new Object[] { lastName}, new PhoneEntryRowMapper());
	}

	@Override
	public boolean delete(String number) {
		return jdbcTemplate.update("delete from PhoneBook where num=?",
				new Object[] { number}) > 0;
	}

	}
