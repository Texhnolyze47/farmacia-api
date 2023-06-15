package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Client;
import com.texhnolyze.farmacia.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin("*")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return ResponseEntity.ok("Cliente added");
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() { return ResponseEntity.ok(clientService.getAllClients());}

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable Long clientId){return ResponseEntity.ok(clientService.getClient(clientId));}


    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, Client client) {
        return ResponseEntity.ok(clientService.updateClient(clientId,client));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable Long clientId){
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Delete client");
    }
}
