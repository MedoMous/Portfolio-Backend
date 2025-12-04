package com.med.springboot.contact;

import com.med.springboot.email.EmailService;
import com.med.springboot.email.EmailService.*;
import com.med.springboot.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    @Autowired
    EmailService emailService;

    // Get all messages
    public List<ContactMessage> findAll() {
        return repository.findAll();
    }

    // Get unread messages only
    public List<ContactMessage> findUnread() {
        return repository.findByLikedFalse();
    }

    // Get liked/read messages
    public List<ContactMessage> findLiked() {
        return repository.findByLikedTrue();
    }

    // Get message by ID
    public ContactMessage findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Message with id: " + id + " not found"));
    }

    // Save new message (from visitor)
    public ContactMessage save(ContactMessage message) {
        message.setLiked(false); // New messages start as unread
        return repository.save(message);
    }

    // Delete message
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // Mark message as liked/read
    public ContactMessage likeMessage(Long id) {
        ContactMessage message = findById(id);
        message.setLiked(true);
//        emailService.sendThankYouEmail(message.getEmail(), message.getName());

        return repository.save(message);
    }

    public ContactMessage unlikeMessage(Long id) {
        ContactMessage message = findById(id);
        message.setLiked(false);
        return repository.save(message);
    }
}