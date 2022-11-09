package org.example.controller;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO = new UserDAO();

    @GetMapping("/{id}")
    public User get(@PathVariable long id) {
        return userDAO.getUser(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody User user) {
        userDAO.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userDAO.deleteUser(id);
    }

}
