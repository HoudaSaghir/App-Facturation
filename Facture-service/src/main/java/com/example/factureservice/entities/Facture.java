package com.example.factureservice.entities;

import com.example.factureservice.models.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private Date factureDate;
    private Long clientId;
    @OneToMany(mappedBy = "facture")
    private List<Article> articles;
    private double prixTotal;
    @Transient
    private Client client;



}
