package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.client.Client;
import com.example.mariabonitaskincareroutineapi.domain.products.Feature;
import com.example.mariabonitaskincareroutineapi.domain.products.Products;
import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.dtos.ClientRecordDto;
import com.example.mariabonitaskincareroutineapi.dtos.ProductsRecordDto;
import com.example.mariabonitaskincareroutineapi.repository.ClientRepository;
import com.example.mariabonitaskincareroutineapi.repository.ProductsRepository;
import com.example.mariabonitaskincareroutineapi.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getAllClient() {
        return clientService.findAll();
    }

    @GetMapping("/{idClient}")
    public Client getClientById(@PathVariable Long idClient) {
        return clientService.findById(idClient);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{idClient}")
    @Transactional
    public ResponseEntity<Client> updateClient(@PathVariable Long idClient, @RequestBody Client updatedClient) {
        try {
            Client updated = clientService.update(idClient, updatedClient);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{idClient}")
    @Transactional
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient) {
        try {
            clientService.delete(idClient);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{idClient}/routine")
    public Client addRoutine(@PathVariable("idClient") Long idRoutine, @RequestBody Routine routine) {
        return clientService.addRoutine(idRoutine, routine);
    }

}



