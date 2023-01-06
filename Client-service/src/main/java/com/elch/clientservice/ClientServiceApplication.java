package com.elch.clientservice;

import com.elch.clientservice.entities.Client;
import com.elch.clientservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class ClientServiceApplication implements CommandLineRunner {
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    ClientRepository clientRepository;
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        for (int i=0;i<5;i++){
            clientRepository.save(new Client(null,"client"+i,"client"+i+"@gmail.com"));
        }
    }
}
