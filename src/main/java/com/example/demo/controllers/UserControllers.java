package com.example.demo.controllers;

import com.example.demo.domain.users.RequestUser;
import com.example.demo.domain.users.User;
import com.example.demo.domain.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserControllers {

    private UserRepository userRepository;

    @Autowired
    public UserControllers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/getUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }


    
    @PostMapping(value = "addUser")
    public ResponseEntity<String> addUser(@RequestBody @Valid RequestUser data) {
        try {

            User user = new User(data);


            userRepository.save(user);

            String message = "Usuário adicionado com sucesso!!!";
            return ResponseEntity.ok(message);
        } catch (Exception e) {

            String errorMessage = "Erro ao adicionar o usuário: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }


}
