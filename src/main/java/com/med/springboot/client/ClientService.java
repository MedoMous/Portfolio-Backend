package com.med.springboot.client;

import com.med.springboot.repository.ClientRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client save(
            Client client){
        return clientRepository.save(client);
    }

    public Client findById(
            Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client with this id :"+id+" not found"));
    }

    public Client update(
            Long id,Client client){
        Client client_ = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client with this ID: "+id+" not found"));
        client_.setName(client.getName());
        client_.setEmail(client.getEmail());
        client_.setWantedProduct(client.getWantedProduct());

        return clientRepository.save(client_);
    }

    public void delete(
            Long id){
        clientRepository.deleteById(id);
    }

}
