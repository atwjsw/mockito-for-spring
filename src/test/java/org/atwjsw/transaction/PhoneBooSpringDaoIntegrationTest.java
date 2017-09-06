package org.atwjsw.transaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration({ "classpath:org.atwjsw.transaction/integration.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneBooSpringDaoIntegrationTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	PhoneBookDao springDao;

	@Before
	public void init() {
		springDao = new PhoneBookDaoSpringImpl(jdbcTemplate);
	}

	@Test
	public void integration() throws Exception {
		PhoneEntry entry = newEntry("12345", "John", "Smith");
		//create
		assertTrue(springDao.create(entry));
		//retrieve
		List<PhoneEntry> phoneEntries = springDao.searchByFirstName("John");
		//verify create
		assertFalse(phoneEntries.isEmpty());

		//modify last name
		entry.setLastName("Kallis");
		//update
		assertTrue(springDao.update(entry));
		//retrieve
		phoneEntries = springDao.searchByFirstName("John");
		//verify update
		assertFalse(phoneEntries.isEmpty());
		System.out.println(phoneEntries.get(0).getLastName());
		assertEquals("Kallis", phoneEntries.get(0).getLastName());

		//delete
		springDao.delete(entry.getPhoneNumber());
		//retrieve
		phoneEntries = springDao.searchByFirstName("John");
		//verify delete
		assertTrue(phoneEntries.isEmpty());

	}

	protected PhoneEntry newEntry(String phoneNumber, String firstName,String lastName) {
		PhoneEntry number = new PhoneEntry();
		number.setFirstName(firstName);
		number.setLastName(lastName);
		number.setPhoneNumber(phoneNumber);
		return number;
	}

}
