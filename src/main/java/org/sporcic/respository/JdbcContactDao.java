package com.codezombie.repository;

import com.codezombie.domain.Client;
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
 * JDBC implementation of the ClientDao. This class makes use of Spring's
 * SimpleJdcbTemplate, along with other Spring JDBC classes, for all its
 * operations.
 */
@Repository
public class JdbcClientDao implements ClientDao {


    private final static String SQL_SELECT = "SELECT id, login_name, last_name, first_name, last_login FROM clients ";
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Autowired
	public void init(DataSource dataSource) {
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

    @Transactional(readOnly = true)
    @Cacheable(cacheName="clientCache")
    public Client findById(Long id) {

        Client user;
		try {
			user = this.simpleJdbcTemplate.queryForObject(
					SQL_SELECT + "WHERE id=?",
					BeanPropertyRowMapper.newInstance(Client.class),
					id);
		}
		catch (EmptyResultDataAccessException ex) {
			throw new ObjectRetrievalFailureException(Client.class, id);
		}

        return user;
    }

    @Transactional(readOnly = true)
    public List<Client> searchForClients(String criteria) {

        Map<String,String> params = new HashMap<String,String>();
        params.put("criteria","%" + criteria + "%");

        List<Client> users = this.simpleJdbcTemplate.query(
				SQL_SELECT + "WHERE login_name LIKE :criteria OR first_name LIKE :criteria OR last_name LIKE :criteria",
				BeanPropertyRowMapper.newInstance(Client.class), params);

        return users;

    }

    @Transactional(readOnly = true)
    public List<Client> listAll() {

        List<Client> users = this.simpleJdbcTemplate.query(
				SQL_SELECT + "ORDER BY id DESC",
				BeanPropertyRowMapper.newInstance(Client.class));

        return users;
    }

}
