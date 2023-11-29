package com.capacitacao.aulas.springweb.repositories;

import com.capacitacao.aulas.springweb.entities.Category;
import com.capacitacao.aulas.springweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
