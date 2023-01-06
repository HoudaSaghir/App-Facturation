package com.elch.produitservice;

import com.elch.produitservice.entities.Produit;
import com.elch.produitservice.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProduitServiceApplication implements CommandLineRunner {
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    ProduitRepository produitRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Produit.class);
            produitRepository.save(new Produit(null,"samsung","SMSG",4500.00));
            produitRepository.save(new Produit(null,"samsung galaxy","SMSGG20",9500.00));
            produitRepository.save(new Produit(null,"MacBook Pro M1","APPLE2",13500.00));
            produitRepository.save(new Produit(null,"Ipad Pro 13","APPLE",10500.00));
    }
}
