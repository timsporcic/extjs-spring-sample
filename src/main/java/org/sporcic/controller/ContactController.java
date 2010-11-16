package org.sporcic.controller;

import org.sporcic.domain.Contact;
import org.sporcic.extjs.ExtData;
import org.sporcic.extjs.ExtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sporcic.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controller for Contacts
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {

    private final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ExtResponse getContacts() {

        logger.info("getContacts called");

        ExtData data = new ExtData();

        List<Contact> contacts = contactService.getAllContacts();

        data.add(contacts);
        data.setSuccess(true);

        return data;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ExtResponse addContacts(@RequestBody Contact[] contacts) {

        logger.info("addContacts called");

        ExtData ret = new ExtData();

        List<Contact> updated = contactService.addContacts(contacts);

        ret.add(updated);
        ret.setSuccess(true);
        return ret;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody ExtResponse deleteContacts(@RequestBody int[] ids) {

        logger.info("deleteContacts called");

        contactService.deleteContacts(ids);

        return ExtResponse.SUCCESS;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody ExtResponse updateContacts(@RequestBody Contact[] contacts) {

        logger.info("updateContacts called");

        ExtData ret = new ExtData();

        List<Contact> items = contactService.updateContacts(contacts);

        ret.add(items);
        ret.setSuccess(true);

        return ret;
    }


}
