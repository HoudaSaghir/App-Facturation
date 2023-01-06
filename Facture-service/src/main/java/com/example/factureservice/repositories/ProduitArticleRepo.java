package com.example.factureservice.repositories;

import com.example.factureservice.entities.Article;
import com.example.factureservice.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitArticleRepo extends JpaRepository<Article,Long> {
}
