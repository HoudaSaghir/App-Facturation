package com.example.factureservice.models;

import lombok.Data;

@Data
public class Produit {
    private Long id ;
    private String name ;
    private String reference ;
    private Double prix ;
}
