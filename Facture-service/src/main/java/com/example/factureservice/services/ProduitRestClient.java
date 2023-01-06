package com.example.factureservice.services;

import com.example.factureservice.models.Produit;
import org.apache.catalina.WebResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitRestClient {
    @GetMapping(path = "/produits")
    PagedModel<Produit> pageProduit(@RequestParam(value = "page") int page,
                                    @RequestParam(value = "taille") int taille);
    @GetMapping(path = "/produits/{id}")
    Produit getProduitById(@PathVariable Long id);
    @GetMapping(path = "/produits")
    PagedModel<Produit> listProduits();
    @GetMapping(path = "/produits/{id}")
    Produit findProduitById(@PathVariable Long id);
}
