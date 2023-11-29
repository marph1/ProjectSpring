package com.capacitacao.aulas.springweb.repositories;

import com.capacitacao.aulas.springweb.entities.Category;
import com.capacitacao.aulas.springweb.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
