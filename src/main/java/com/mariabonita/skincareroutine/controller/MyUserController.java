package com.mariabonita.skincareroutine.controller;

import com.mariabonita.skincareroutine.domain.myuser.MyUser;
//import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.repository.ProductRepository;
import com.mariabonita.skincareroutine.service.MyUserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("myUser")
@RequiredArgsConstructor
public class MyUserController {


    ProductRepository productRepository;
    private final MyUserService myUserService;

    @GetMapping
    public List<MyUser> getAllMyUser() {
        return myUserService.findAll();
    }

    @GetMapping("/{idMyUser}")
    public MyUser getMyUserById(@PathVariable Long idMyUser) {
        return myUserService.findById(idMyUser);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MyUser saveMyUser(@RequestBody MyUser myUser) {
        return myUserService.saveMyUser(myUser);
    }

    @PutMapping("/{idMyUser}")
    @Transactional
    public ResponseEntity<MyUser> updateMyUser(@PathVariable Long idMyUser, @RequestBody MyUser updatedMyUser) {
        try {
            MyUser updated = myUserService.update(idMyUser, updatedMyUser);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{idMyUser}")
    @Transactional
    public ResponseEntity<Void> deleteMyUser(@PathVariable Long idMyUser) {
        try {
            myUserService.delete(idMyUser);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

   // @PostMapping("{idMyUser}/routine")
    //public MyUser addRoutine(@PathVariable("idMyUser") Long idRoutine, @RequestBody Routine routine) {
      //  return myUserService.addRoutine(idRoutine, routine);
    //}

}





  //  @PostMapping("{idClient}/routine")
    //public MyUser addRoutine(@PathVariable("idClient") Long idRoutine, @RequestBody Routine routine) {
      //  return myUserService.addRoutine(idRoutine, routine);
    //}





