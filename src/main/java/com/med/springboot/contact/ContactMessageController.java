package com.med.springboot.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactMessageController {
    @Autowired
    private ContactMessageService service;

    @GetMapping
    public List<ContactMessage> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ContactMessage findById(
            @PathVariable long id){
        return service.findById(id);
    }

    @GetMapping("/unread")
    public List <ContactMessage> findUnread(){
        return service.findUnread();
    }

    @GetMapping("/liked")
    public List<ContactMessage> findLiked(){
        return service.findLiked();
    }
    @PostMapping
    public ContactMessage save(
            @RequestBody ContactMessage message){
        return service.save(message);
    }

    @PutMapping("/{id}/like")
    public ContactMessage likeMessage(
            @PathVariable Long id){
        return service.likeMessage(id);
    }

    @PutMapping("/{id}/unlike")
    public ContactMessage unlikeMessage(
            @PathVariable Long id){
        return service.unlikeMessage(id);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id){
        service.deleteById(id);
    }
}
