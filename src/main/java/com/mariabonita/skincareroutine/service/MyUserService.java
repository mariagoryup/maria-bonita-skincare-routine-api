package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.myuser.MyUser;
//import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.repository.MyUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public List<MyUser> findAll() {
        return myUserRepository.findAll();
    }

    public MyUser findById(Long idClient) {
        return myUserRepository.findById(idClient).orElseThrow();
    }

    @Transactional
    public MyUser save(MyUser myUser) {
        return myUserRepository.save(myUser);
    }

    @Transactional
    public MyUser update(Long idClient, MyUser updatedMyUser) {
        MyUser existingMyUser = myUserRepository.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
        existingMyUser.setName(updatedMyUser.getName());
        existingMyUser.setEmail(updatedMyUser.getEmail());
        existingMyUser.setAge(updatedMyUser.getAge());
        existingMyUser.setSkinTypeClient(updatedMyUser.getSkinTypeClient());
        existingMyUser.setHowMuch(updatedMyUser.getHowMuch());
        existingMyUser.setPigmentedSkin(updatedMyUser.getPigmentedSkin());
        existingMyUser.setSensitiveSkin(updatedMyUser.getSensitiveSkin());

        return myUserRepository.save(existingMyUser);
    }

    @Transactional
    public void delete(Long idClient) {
        myUserRepository.deleteById(idClient);
    }


 //   @Transactional
   // public MyUser addRoutine(Long idRoutine, Routine routine) {
     //   MyUser myUser = myUserRepository.findById(idRoutine).orElseThrow();
       // myUser.addRoutine(routine);
        //return myUserRepository.save(myUser);
    //}


}
