package com.example.factureservice.web;

import com.example.factureservice.entities.Facture;
import com.example.factureservice.repositories.FactureRepo;
import com.example.factureservice.repositories.ProduitArticleRepo;
import com.example.factureservice.services.ClientRestClient;
import com.example.factureservice.services.ProduitRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactureRestController {
    @Autowired
    private FactureRepo factureRepo;
    @Autowired
    private ProduitArticleRepo produitArticleRepo;
    @Autowired
    private ProduitRestClient produitRestClient;
    @Autowired
    private ClientRestClient clientRestClient;

   @GetMapping("/fullFacture/{id}")
    public Facture facture(@PathVariable Long id){
       Facture facture=factureRepo.findById(id).get();
       facture.setClient(clientRestClient.findClientById(facture.getClientId()));
       facture.getArticles().forEach(pi->{
           pi.setProduit(produitRestClient.findProduitById(pi.getProductId()));
       });
       return facture;
    }

}
