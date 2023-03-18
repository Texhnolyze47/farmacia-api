package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Client;
import com.texhnolyze.farmacia.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ControllerClient {

    private final ClientService clientService;


    public ControllerClient(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client newClient = clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> allClient = clientService.getAllClients();
        return ResponseEntity.ok(allClient);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClient(@PathVariable Long clientId){
        return null;
    }
}
