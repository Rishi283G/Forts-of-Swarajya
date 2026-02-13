package com.forts.service;

import com.forts.model.ContactMessage;
import com.forts.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    public void saveMessage(ContactMessage message) {
        contactMessageRepository.save(message);
    }
}
