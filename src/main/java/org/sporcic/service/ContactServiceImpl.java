package com.codezombie.service;

import com.codezombie.domain.Client;
import com.codezombie.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the ClientService interface. Defers operations to the
 * ClientDao implementation.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    public Client findById(Long id) {
        return clientDao.findById(id);

    }

    public List<Client> searchForClient(String criteria) {

        criteria = (criteria == null ? "":criteria.trim());

        if(criteria.length() < 3) {
            throw new IllegalArgumentException("Criteria must be at least 3 characters long");
        }

        return clientDao.searchForClients(criteria);
    }

    public List<Client> getAllClients() {
        return clientDao.listAll();
    }

    public Client addClient(Client client) {

        return null;
    }

    public void deleteClient(int id) {

    }
    

}
