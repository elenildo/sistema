package com.youtan.sistema.services;

import com.youtan.sistema.models.User;
import com.youtan.sistema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        var usr = userRepository.findByUsername(user.getUsername());
        if(usr.isPresent())
            throw new Error("User already exists");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

}
