package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Client;

import java.util.List;

public interface ClientService {

    Client addClient(Client client);

    Client getClient(Long idClient);

    List<Client> getAllClients();

}
