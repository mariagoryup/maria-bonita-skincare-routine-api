package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.client.Client;
import com.example.mariabonitaskincareroutineapi.domain.products.Category;
import com.example.mariabonitaskincareroutineapi.domain.products.Products;
import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long idClient) {
        return clientRepository.findById(idClient).orElseThrow();
    }

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client update(Long idClient, Client updatedClient) {
        Client existingClient = clientRepository.findById(idClient)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setAge(updatedClient.getAge());
        existingClient.setSkinTypeClient(updatedClient.getSkinTypeClient());
        existingClient.setHowMuch(updatedClient.getHowMuch());
        existingClient.setPigmentedSkin(updatedClient.getPigmentedSkin());
        existingClient.setSensitiveSkin(updatedClient.getSensitiveSkin());

        return clientRepository.save(existingClient);
    }

    @Transactional
    public void delete(Long idClient) {
        clientRepository.deleteById(idClient);
    }


    @Transactional
    public Client addRoutine(Long idRoutine, Routine routine) {
        Client client = clientRepository.findById(idRoutine).orElseThrow();
        client.addRoutine(routine);
        return clientRepository.save(client);
    }







}
