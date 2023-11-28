package com.capacitacao.aulas.springweb.resources;

import com.capacitacao.aulas.springweb.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "carlin avassalador", "email@email","12313231", "1234");
        return ResponseEntity.ok().body(u);
    }

}
