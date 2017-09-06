package org.atwjsw.transaction;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneBookJdbcDaoIntegrationTest {
	PhoneBookDao jdbcDao;
	
	@Before
	public void init() {
		jdbcDao = new PhoneBookDaoImpl();
	}
	
	@Test
	public void integration() throws Exception {
		PhoneEntry entry = new PhoneEntry();
		entry.setFirstName("john");
		entry.setLastName("smith");
		entry.setPhoneNumber("12345");
		
		assertTrue(jdbcDao.create(entry));
		List<PhoneEntry> phoneEntries = jdbcDao.searchByFirstName("john");
		//verify create
		assertFalse(phoneEntries.isEmpty());

		//modify last name
		entry.setLastName("doe");
		//update
		assertTrue(jdbcDao.update(entry));
		//retrieve
		phoneEntries = jdbcDao.searchByFirstName("john");
		//verify update
		assertFalse(phoneEntries.isEmpty());
		assertEquals("doe", phoneEntries.get(0).getLastName());

		//delete
		jdbcDao.delete(entry.getPhoneNumber());
		//retrieve
		phoneEntries = jdbcDao.searchByFirstName("john");
		//verify delete
		assertTrue(phoneEntries.isEmpty());
	}
	
}
