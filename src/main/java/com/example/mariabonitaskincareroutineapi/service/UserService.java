package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.repository.RoleRepository;
import com.example.mariabonitaskincareroutineapi.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }


    public User findById(Long idUser) {
        return userRepository.findById(idUser).orElseThrow();
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);

        User user = userRepository.findByUsername(username);
        Role role = RoleRepository.findByName(roleName);

        user.getRoles().add(role);

        // Save the user to persist the changes
        userRepository.save(user);
    }


    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User update(Long idUser, User updatedUser) {
        User existingUser = userRepository.findById(idUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setSkinTypeClient(updatedUser.getSkinTypeClient());
        existingUser.setHowMuch(updatedUser.getHowMuch());
        existingUser.setPigmentedSkin(updatedUser.getPigmentedSkin());
        existingUser.setSensitiveSkin(updatedUser.getSensitiveSkin());

        return userRepository.save(existingUser);
    }

    @Transactional
    public void delete(Long idUser) {
        userRepository.deleteById(idUser);
    }


    @Transactional
    public User addRoutine(Long idRoutine, Routine routine) {
        User user = userRepository.findById(idRoutine).orElseThrow();
        user.addRoutine(routine);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user with the given username
        User user = userRepository.findByUsername(username);
        // Check if user exists
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            // Create a collection of SimpleGrantedAuthority objects from the user's roles
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            // Return the user details, including the username, password, and authorities
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        // Encode the user's password for security before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}





}
