package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.myuser.MyUser;
//import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.service.MyUserService;
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
public class MyUserController {

    private final MyUserService myUserService;

    @GetMapping
    public List<MyUser> getAllClient() {
        return myUserService.findAll();
    }

    @GetMapping("/{idClient}")
    public MyUser getClientById(@PathVariable Long idClient) {
        return myUserService.findById(idClient);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MyUser createClient(@RequestBody MyUser myUser) {
        return myUserService.save(myUser);
    }

    @PutMapping("/{idClient}")
    @Transactional
    public ResponseEntity<MyUser> updateClient(@PathVariable Long idClient, @RequestBody MyUser updatedMyUser) {
        try {
            MyUser updated = myUserService.update(idClient, updatedMyUser);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{idClient}")
    @Transactional
    public ResponseEntity<Void> deleteClient(@PathVariable Long idClient) {
        try {
            myUserService.delete(idClient);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

  //  @PostMapping("{idClient}/routine")
    //public MyUser addRoutine(@PathVariable("idClient") Long idRoutine, @RequestBody Routine routine) {
      //  return myUserService.addRoutine(idRoutine, routine);
    //}

}



