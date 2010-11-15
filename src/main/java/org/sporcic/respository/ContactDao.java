package com.codezombie.repository;

import com.codezombie.domain.Client;

import java.util.List;

/**
 *
 */
public interface ClientDao {

    public Client findById(Long id);

    public List<Client> searchForClients(String criteria);

    public List<Client> listAll();
    
}
