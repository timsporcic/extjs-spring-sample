package org.sporcic.service;

import org.sporcic.domain.Contact;
import org.sporcic.repository.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the ClientService interface. Defers operations to the
 * ClientDao implementation.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    public Contact findById(Long id) {
        return contactDao.findById(id);

    }

    public List<Contact> searchForContact(String criteria) {

        criteria = (criteria == null ? "":criteria.trim());

        if(criteria.length() < 3) {
            throw new IllegalArgumentException("Criteria must be at least 3 characters long");
        }

        return contactDao.searchForContact(criteria);
    }

    public List<Contact> getAllContacts() {
        return contactDao.listAll();
    }

    public Contact addContact(Contact client) {

        return null;
    }

    public void deleteContact(int id) {

    }
    

}
