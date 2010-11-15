package org.sporcic.repository;

import org.sporcic.domain.Contact;

import java.util.List;

/**
 *
 */
public interface ContactDao {

    public Contact findById(Long id);

    public List<Contact> searchForContact(String criteria);

    public List<Contact> listAll();
    
}
