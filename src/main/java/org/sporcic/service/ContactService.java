package org.sporcic.service;

import org.sporcic.domain.Contact;

import java.util.List;

/**
 * Interface for the Client Service
 */
public interface ContactService {

    public Contact findById(Long id);

    public List<Contact> searchForContact(String criteria);

    public List<Contact> getAllContacts();

    public Contact addContact(Contact client);

    public void deleteContact(int id);

}
