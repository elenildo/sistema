package com.youtan.sistema.controllers;

import com.youtan.sistema.dto.UserDtoIn;
import com.youtan.sistema.models.User;
import com.youtan.sistema.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER_SELECT')")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(userService.listAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER_SELECT')")
    public ResponseEntity<?> show(@PathVariable String id) {
        return new ResponseEntity<>(userService.find(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('USER_UPDATE')")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UserDtoIn body) {
        return new ResponseEntity<>(userService.update(id, body), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('USER_DELETE')")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return ResponseEntity.ok().build();
    }

}
