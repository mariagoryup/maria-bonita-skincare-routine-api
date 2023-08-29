package com.example.mariabonitaskincareroutineapi.service;

import com.example.mariabonitaskincareroutineapi.domain.products.Routine;
import com.example.mariabonitaskincareroutineapi.domain.products.Step;
import com.example.mariabonitaskincareroutineapi.repository.UserRepository;
import com.example.mariabonitaskincareroutineapi.repository.ProductsRepository;
import com.example.mariabonitaskincareroutineapi.repository.RoutineRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineService {

    RoutineRepository routineRepository;
    ProductsRepository productsRepository;

    UserRepository userRepository;


    public RoutineService(ProductsRepository productsRepository, UserRepository userRepository) {
        this.productsRepository = productsRepository;
        this.userRepository = userRepository;
    }

    public List<Routine> findAll() {
        return routineRepository.findAll();
    }

    // @Transactional
    //public Routine save(Routine routine) {
    //  return routineRepository.save(routine);
    //}

    public Routine findById(Long idRoutine) {
        return routineRepository.findById(idRoutine).orElseThrow();
    }

    @Transactional
    public Routine update(Long idRoutine, Routine updatedRoutine) {
        Routine existingRoutine = routineRepository.findById(idRoutine)
                .orElseThrow(() -> new EntityNotFoundException("Routine not found"));
        existingRoutine.setName(updatedRoutine.getName());
        existingRoutine.setSteps(updatedRoutine.getSteps());

        return routineRepository.save(existingRoutine);
    }

    @Transactional
    public void delete(Long idRoutine) {
        routineRepository.deleteById(idRoutine);
    }

    @Transactional
    public Routine addStep(Long idStep, Step step) {
        Routine routine = routineRepository.findById(idStep).orElseThrow();
        routine.addStep(step);
        return routineRepository.save(routine);
    }

    private void addStep(List<Step> cleanser) {
    }

    public List<Step> getProductsByCategory(String category) {
        // Category cat = new Category(); // will not work
        // productsRepository.findAllByCategory(cat); // todo fix
        return null;
    }

    public List<Step> getRoutineForClient(String age, String howMuch, String pigmentedSkin, String sensitiveSkin, String skinTypeClient) {
        List<Step> cleanser = new ArrayList<>();

        // based on the client create

        /*
        if ("dry".equals(skinTypeClient)) {
            cleanser.add(productsRepository.findProductsBySkinType("dry", "all"));
        } else if ("oily".equals(skinTypeClient)) {
            cleanser.add(productsRepository.findProductsBySkinType("oily", "all"));

        } else if ("normal".equals(skinTypeClient)) {
            cleanser.add(productsRepository.findProductsBySkinType("normal", "all"));
        } else if ("combination".equals(skinTypeClient)) {
            cleanser.add(productsRepository.findProductsBySkinType("combination", "all"));
        }
        addStep(productsRepository.findProductsByCategory("cleanser"));
*/
        return cleanser;

    }
}




