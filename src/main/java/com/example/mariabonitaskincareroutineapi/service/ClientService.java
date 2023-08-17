package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.repository.ClientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

}
