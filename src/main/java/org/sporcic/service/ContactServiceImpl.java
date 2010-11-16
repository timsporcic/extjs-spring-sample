package org.sporcic.service;

import org.sporcic.domain.Contact;
import org.sporcic.repository.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ClientService interface. Defers operations to the
 * ClientDao implementation.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    public Contact findById(Integer id) {
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

    @Override
    public List<Contact> addContacts(Contact[] contacts) {

        List<Contact> data = new ArrayList<Contact>();

        for(Contact contact : contacts) {
            Contact newContact = contactDao.addContact(contact);
            data.add(newContact);
        }

        return data;
    }

    @Override
    public List<Contact> updateContacts(Contact[] contacts) {

        List<Contact> data = new ArrayList<Contact>();

        for(Contact contact : contacts) {
            Contact updatedContact = contactDao.updateContact(contact);
            data.add(updatedContact);
        }

        return data;
    }

    @Override
    public void deleteContacts(int[] ids) {

        for(int id : ids ) {
            contactDao.deleteContact(id);
        }
    }
}
