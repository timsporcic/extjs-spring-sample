package org.sporcic.repository;

import org.sporcic.domain.Contact;
import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.*;

/**
 * JDBC implementation of the ContactDao. This class makes use of Spring's
 * SimpleJdcbTemplate, along with other Spring JDBC classes, for all its
 * operations.
 */
@Repository
public class JdbcContactDao implements ContactDao {



    private final static String SQL_SELECT = "SELECT id, login_name, last_name, first_name, last_login FROM clients ";
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

    @Transactional(readOnly = true)
    @Cacheable(cacheName="contactCache")
    public Contact findById(Long id) {

        Contact user;
		try {
			user = this.simpleJdbcTemplate.queryForObject(
					SQL_SELECT + "WHERE id=?",
					BeanPropertyRowMapper.newInstance(Contact.class),
					id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Contact.class, id);
		}

        return user;
    }

    @Transactional(readOnly = true)
    public List<Contact> searchForContact(String criteria) {

        Map<String,String> params = new HashMap<String,String>();
        params.put("criteria","%" + criteria + "%");

        List<Contact> users = this.simpleJdbcTemplate.query(
				SQL_SELECT + "WHERE login_name LIKE :criteria OR first_name LIKE :criteria OR last_name LIKE :criteria",
				BeanPropertyRowMapper.newInstance(Contact.class), params);

        return users;

    }

    @Transactional(readOnly = true)
    public List<Contact> listAll() {

        List<Contact> users = this.simpleJdbcTemplate.query(
				SQL_SELECT + "ORDER BY id DESC",
				BeanPropertyRowMapper.newInstance(Contact.class));

        return users;
    }

}
