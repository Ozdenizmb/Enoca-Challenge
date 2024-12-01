package com.enoca.challenge.repository;

import com.enoca.challenge.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Page<Product> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Product> findAllByCategoryContainingIgnoreCase(String category, Pageable pageable);

}
