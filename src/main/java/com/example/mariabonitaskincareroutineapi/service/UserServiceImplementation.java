package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.domain.user.User;
import com.example.mariabonitaskincareroutineapi.repository.UserRepository;
import com.example.mariabonitaskincareroutineapi.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImplementation extends UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadClientByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            log.error("Client not found in the database");
            throw new UsernameNotFoundException ("Client not found in the database");

        } else {
            log.info("Client found in the database: {}", username);

      //      Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //    user.getRoles().forEach(role -> {
          //      authorities.add(new SimpleGrantedAuthority(role.getName()));
            //});

            //return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }


}
