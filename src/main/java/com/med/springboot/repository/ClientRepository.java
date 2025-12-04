package com.med.springboot.repository;

import com.med.springboot.client.Client;
import com.med.springboot.contact.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
