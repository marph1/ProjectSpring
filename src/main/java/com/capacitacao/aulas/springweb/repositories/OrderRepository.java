package com.capacitacao.aulas.springweb.repositories;

import com.capacitacao.aulas.springweb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
