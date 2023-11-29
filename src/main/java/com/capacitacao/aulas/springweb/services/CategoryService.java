package com.capacitacao.aulas.springweb.services;

import com.capacitacao.aulas.springweb.entities.Category;
import com.capacitacao.aulas.springweb.entities.Order;
import com.capacitacao.aulas.springweb.repositories.CategoryRepository;
import com.capacitacao.aulas.springweb.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
