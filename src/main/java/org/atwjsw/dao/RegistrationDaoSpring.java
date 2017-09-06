package org.atwjsw.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component("registrationDao")
public class RegistrationDaoSpring implements RegistrationDao {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public RegistrationDaoSpring(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
//		new DatabaseManager().go(null);
	}

//	@Override
//	public boolean isExistingUserId(String userId) {
//		return jdbcTemplate.queryForInt(
//				"SELECT count(*) FROM user_data where userId=?",
//				new Object[] { userId }) > 0;
//	}

	@Override
	public boolean isExistingUserId(String userId) {
		return jdbcTemplate.queryForObject(
				"SELECT count(*) FROM user_data where userId=?", new RowMapper<Boolean>() {
					@Override
					public Boolean mapRow(ResultSet resultSet, int i) throws SQLException {
						System.out.println(resultSet.getInt(1));
						return resultSet.getInt(1) > 0;
					}
				},
				userId);
	}

	@Override
	public void create(String userId, String password, String firstName,
			String lastName) {
		int rowCount = jdbcTemplate.update(
				"insert into user_data values (?,?,?,?)", new Object[] {
						userId, password, firstName, lastName });
		if (rowCount != 1) {
			throw new RuntimeException("Database update row count should be 1");
		}
	}
}
