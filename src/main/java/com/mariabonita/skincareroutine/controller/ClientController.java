package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.client.MyUser;
import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
    public List<MyUser> getAllClient() {
        return clientService.findAll();
    }

    @GetMapping("/{idClient}")
    public MyUser getClientById(@PathVariable Long idClient) {
        return clientService.findById(idClient);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MyUser createClient(@RequestBody MyUser myUser) {
        return clientService.save(myUser);
    }

    @PutMapping("/{idClient}")
    @Transactional
    public ResponseEntity<MyUser> updateClient(@PathVariable Long idClient, @RequestBody MyUser updatedMyUser) {
        try {
            MyUser updated = clientService.update(idClient, updatedMyUser);
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
    public MyUser addRoutine(@PathVariable("idClient") Long idRoutine, @RequestBody Routine routine) {
        return clientService.addRoutine(idRoutine, routine);
    }

}



