package com.capacitacao.aulas.springweb.services;

import com.capacitacao.aulas.springweb.entities.User;
import com.capacitacao.aulas.springweb.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.get();
    }
    public User insert(User obj){
        return userRepository.save(obj);
    }
    public void deleteById(Long id){
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.err.println("Erro ao excluir o usuário com ID: " + id + ". Usuário não encontrado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public User update(Long id, User updatedUser){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
    }
}
