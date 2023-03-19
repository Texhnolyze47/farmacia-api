package com.texhnolyze.farmacia.service.impl;

import com.texhnolyze.farmacia.entities.Client;
import com.texhnolyze.farmacia.exception.ClientNotFoundException;
import com.texhnolyze.farmacia.repositories.ClientRepository;
import com.texhnolyze.farmacia.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(Long idClient) {
        return clientRepository.findById(idClient).orElseThrow(() -> new ClientNotFoundException(
                "id is not found on server" + idClient ));
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
