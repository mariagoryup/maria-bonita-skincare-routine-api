package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.Role;
import com.mariabonita.skincareroutine.domain.myuser.MyUser;
//import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.repository.MyUserRepository;
import com.mariabonita.skincareroutine.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserService implements UserDetailsService {
    private final MyUserRepository myUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    public List<MyUser> findAll() {
        log.info("Fetching all users");
        return myUserRepository.findAll();
    }

    public MyUser findById(Long idClient) {
        return myUserRepository.findById(idClient).orElseThrow();
    }

    public MyUser getUser(String email) {
        log.info("Fetching user {}", email);
        return myUserRepository.findByEmail(email);
    }

    @Transactional
    public MyUser saveMyUser(MyUser myUser) {
        log.info("Saving new user {} to the database", myUser.getName());
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return myUserRepository.save(myUser);
    }

    @Transactional
    public MyUser update(Long idMyUser, MyUser updatedMyUser) {
        MyUser existingMyUser = myUserRepository.findById(idMyUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        existingMyUser.setName(updatedMyUser.getName());
        existingMyUser.setPassword(updatedMyUser.getPassword());
        existingMyUser.setEmail(updatedMyUser.getEmail());
        existingMyUser.setAge(updatedMyUser.getAge());
        existingMyUser.setSkinTypeClient(updatedMyUser.getSkinTypeClient());
        existingMyUser.setHowMuch(updatedMyUser.getHowMuch());
        existingMyUser.setPigmentedSkin(updatedMyUser.getPigmentedSkin());
        existingMyUser.setSensitiveSkin(updatedMyUser.getSensitiveSkin());

        return myUserRepository.save(existingMyUser);
    }

    @Transactional
    public void delete(Long idMyUser) {
        myUserRepository.deleteById(idMyUser);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MyUser user = myUserRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
        }
    }


        public Role saveRole(Role role) {
            log.info("Saving new role {} to the database", role.getName());
            return roleRepository.save(role);
        }

        public void addRoleToMyUser(String email, String roleName) {
            log.info("Adding role {} to user {}", roleName, email);

            MyUser myUser = myUserRepository.findByEmail(email);
            Role role = roleRepository.findByName(roleName);
            myUser.getRoles().add(role);
            myUserRepository.save(myUser);
        }


    }


 //   @Transactional
   // public MyUser addRoutine(Long idRoutine, Routine routine) {
     //   MyUser myUser = myUserRepository.findById(idRoutine).orElseThrow();
       // myUser.addRoutine(routine);
        //return myUserRepository.save(myUser);
    //}



