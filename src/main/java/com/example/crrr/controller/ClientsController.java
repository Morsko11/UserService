package com.example.crrr.controller;

import com.example.crrr.dto.ClientsDTO;
import com.example.crrr.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping
    public ResponseEntity<ClientsDTO> createClient(@RequestBody ClientsDTO clientsDTO) {
        return new ResponseEntity<>(clientsService.createClient(clientsDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientsDTO>> getAllClients() {
        return new ResponseEntity<>(clientsService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientsDTO> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(clientsService.getClientById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        clientsService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
