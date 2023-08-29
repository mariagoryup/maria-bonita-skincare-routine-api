package com.example.mariabonitaskincareroutineapi.controller;

import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.service.UserService;
import com.example.mariabonitaskincareroutineapi.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return userService.getUsers();
    }

    @GetMapping("/{idUser}")
    public User getUserById(@PathVariable Long idUser) {
        return userService.findById(idUser);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{idUser}")
    @Transactional
    public ResponseEntity<User> updateUser(@PathVariable Long idUser, @RequestBody User updatedUser) {
        try {
            User updated = userService.update(idUser, updatedUser);
            return ResponseEntity.ok(updated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{idUser}")
    @Transactional
    public ResponseEntity<Void> deleteUser(@PathVariable Long idUser) {
        try {
            userService.delete(idUser);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{idUser}/routine")
    public User addRoutine(@PathVariable("idUser") Long idRoutine, @RequestBody Routine routine) {
        return userService.addRoutine(idRoutine, routine);
    }

}



