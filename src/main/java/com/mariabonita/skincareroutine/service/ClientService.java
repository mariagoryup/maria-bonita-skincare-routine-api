package com.mariabonita.skincareroutine.service;

import com.mariabonita.skincareroutine.domain.client.MyUser;
import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<MyUser> findAll() {
        return clientRepository.findAll();
    }

    public MyUser findById(Long idClient) {
        return clientRepository.findById(idClient).orElseThrow();
    }

    @Transactional
    public MyUser save(MyUser myUser) {
        return clientRepository.save(myUser);
    }

    @Transactional
    public MyUser update(Long idClient, MyUser updatedMyUser) {
        MyUser existingMyUser = clientRepository.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
        existingMyUser.setName(updatedMyUser.getName());
        existingMyUser.setEmail(updatedMyUser.getEmail());
        existingMyUser.setAge(updatedMyUser.getAge());
        existingMyUser.setSkinTypeClient(updatedMyUser.getSkinTypeClient());
        existingMyUser.setHowMuch(updatedMyUser.getHowMuch());
        existingMyUser.setPigmentedSkin(updatedMyUser.getPigmentedSkin());
        existingMyUser.setSensitiveSkin(updatedMyUser.getSensitiveSkin());

        return clientRepository.save(existingMyUser);
    }

    @Transactional
    public void delete(Long idClient) {
        clientRepository.deleteById(idClient);
    }


    @Transactional
    public MyUser addRoutine(Long idRoutine, Routine routine) {
        MyUser myUser = clientRepository.findById(idRoutine).orElseThrow();
        myUser.addRoutine(routine);
        return clientRepository.save(myUser);
    }


}
