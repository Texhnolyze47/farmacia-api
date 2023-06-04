package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Client;
import com.texhnolyze.farmacia.exceptions.ClientNotFoundException;
import com.texhnolyze.farmacia.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long clientId){
        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("Client not found"));
    }

    public Client updateClient(Long clientId, Client client) {
        Optional<Client> notFoundClient = clientRepository.findById(clientId);

        Client existClient = notFoundClient.get();
        existClient.setName(client.getName());
        existClient.setNumber(client.getNumber());
        existClient.setEmail(client.getEmail());

        return existClient;
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }



}
