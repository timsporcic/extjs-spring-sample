package com.codezombie.service;

import com.codezombie.domain.Client;

import java.util.List;

/**
 * Interface for the Client Service
 */
public interface ClientService {

    public Client findById(Long id);

    public List<Client> searchForClient(String criteria);

    public List<Client> getAllClients();

    public Client addClient(Client client);

    public void deleteClient(int id);

}
