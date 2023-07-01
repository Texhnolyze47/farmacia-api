package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Client;
import com.texhnolyze.farmacia.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientControllerTest {
    private final ClientService clientService = Mockito.mock(ClientService.class);
    private final ClientController clientController = new ClientController(clientService);

    @Test
    public void testAddClient() {
        Client client = new Client();
        ResponseEntity<String> response = clientController.addClient(client);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente added", response.getBody());
        Mockito.verify(clientService).saveClient(client);
    }

    @Test
    public void testGetClients() {
        List<Client> clients = new ArrayList<>();
        Mockito.when(clientService.getAllClients()).thenReturn(clients);
        ResponseEntity<List<Client>> response = clientController.getClients();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clients, response.getBody());
    }

    @Test
    public void testGetClient() {
        Client client = new Client();
        Mockito.when(clientService.getClient(1L)).thenReturn(client);
        ResponseEntity<Client> response = clientController.getClient(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client();
        Mockito.when(clientService.updateClient(1L, client)).thenReturn(client);
        ResponseEntity<Client> response = clientController.updateClient(1L, client);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
    }

    @Test
    public void testDeleteClient() {
        ResponseEntity<String> response = clientController.deleteClient(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Delete client", response.getBody());
        Mockito.verify(clientService).deleteClient(1L);
    }

}
