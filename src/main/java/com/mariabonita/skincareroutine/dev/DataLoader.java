package com.mariabonita.skincareroutine.dev;

import com.mariabonita.skincareroutine.controller.MyUserController;
import com.mariabonita.skincareroutine.controller.ProductsController;
import com.mariabonita.skincareroutine.domain.products.Category;
import com.mariabonita.skincareroutine.domain.products.Feature;
import com.mariabonita.skincareroutine.domain.products.Product;
import com.mariabonita.skincareroutine.domain.products.SkinType;
import com.mariabonita.skincareroutine.repository.*;
import com.mariabonita.skincareroutine.service.MyUserService;
import com.mariabonita.skincareroutine.service.ProductsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev")
public class DataLoader implements ApplicationListener<ApplicationReadyEvent> {

    private final ProductsRepository productsRepository;
    private final SkinTypeRepository skinTypeRepository;
    private final CategoryRepository categoryRepository;
    private final FeatureRepository featureRepository;
    private final ProductsService productsService;
    private final ProductsController productsController;
    private final MyUserRepository myUserRepository;
    private final MyUserController myUserController;
    private final MyUserService myUserService;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        var skinTypes = saveSkinTypes();
        var features = saveFeatures();
        var categories = saveCategories();
        var products = saveProducts(skinTypes, features, categories);





        log.info("Closing the data Loader");
        System.exit(42); // to comment if you want to run the application fully
    }


    private List<Product> saveProducts(List<SkinType> skinTypes, List<Feature> features, List<Category> categories) {
        // var faker = new Faker();
        //  var example = faker.animal().name();

        var product1 = new Product(9.99F, "THE PERFECT PRODUCT", "THE PERFECT COMPANY" );
        product1.addSkinType(skinTypes.get(0));
        product1.addFeature(features.get(0));
        product1.addCategory(categories.get(0));

        var product2 = new Product(11.99F, "THE NEW PERFECT PRODUCT", "THE PERFECT COMPANY" );
        product2.addSkinType(skinTypes.get(3));
        product2.addFeature(features.get(1));
        product2.addFeature(features.get(2));
        product2.addCategory(categories.get(3));

        var product3 = new Product(8.39F, "Cleanance Hydra Soothing Cleanse Cream", "Eau Thermale Avène" );
        product3.addSkinType(skinTypes.get(4));
        product3.addFeature(features.get(1));
        //  product3.addFeature(features.get(2));
        product3.addCategory(categories.get(1));


        System.out.println("======================");
        log.info("Persisting all Products");
        var allProducts = productsRepository.saveAll(List.of(product1, product2));
        allProducts.forEach(System.out::println);
        System.out.println("======================");
        return allProducts;
    }

    private List<SkinType> saveSkinTypes() {
        var skinType1 = new SkinType("DRY");
        var skinType2 = new SkinType("OILY");
        var skinType3 = new SkinType("NORMAL");
        var skinType4 = new SkinType("COMBINATION");
        var skinType5 = new SkinType("ALL");
        System.out.println("======================");
        log.info("Persisting all Skin types");
        var skinTypes = skinTypeRepository.saveAll(List.of(skinType1, skinType2, skinType3, skinType4, skinType5));
        skinTypes.forEach(System.out::println);
        System.out.println("======================");
        return skinTypes;
    }

    private List<Feature> saveFeatures() {
        var feature1 = new Feature("SENSITIVE SKIN");
        var feature2 = new Feature("ANTI AGE");
        var feature3 = new Feature("ANTI PIGMENTATION");
        System.out.println("=========================");
        log.info("Persisting all features");
        var features = featureRepository.saveAll(List.of(feature1,feature2, feature3));
        features.forEach(System.out::println);
        System.out.println("====================");
        return features;
    }

    private List<Category> saveCategories() {
        var category1 = new Category("CLEANSER");
        var category2 = new Category("TONIC");
        var category3 = new Category("SERUM");
        var category4 = new Category("MOISTURIZER");
        var category5 = new Category("SUNSCREEN");
        var category6 = new Category("TWICE A WEEK");
        var category7 = new Category("TIME TO GLOW");

        System.out.println("=========================");
        log.info("Persisting all Categories");
        var categories = categoryRepository.saveAll(List.of(category1,category2, category3, category4,category5, category6, category7));
        categories.forEach(System.out::println);
        System.out.println("====================");
        return categories;
    }


}



