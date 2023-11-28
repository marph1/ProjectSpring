package com.capacitacao.aulas.springweb.repositories;

import com.capacitacao.aulas.springweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
