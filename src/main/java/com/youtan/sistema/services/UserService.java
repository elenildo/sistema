package com.youtan.sistema.services;

import com.youtan.sistema.dto.UserDto;
import com.youtan.sistema.dto.UserDtoIn;
import com.youtan.sistema.models.Role;
import com.youtan.sistema.models.User;
import com.youtan.sistema.repositories.RoleRepository;
import com.youtan.sistema.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User create(User user) {
        var usr = userRepository.findByUsername(user.getUsername());
        if(usr.isPresent())
            throw new Error("User already exists");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<UserDto> listAll() {
        return userRepository.findAll().stream().map(UserDto::new).toList();
    }

    private User findById(String userId) {
        var user = userRepository.findById(Long.parseLong(userId));
        if(user.isEmpty())
            throw new RuntimeException("User not found");

        return user.get();
    }

    public UserDto update(String id, UserDtoIn body) {
        var usr = findById(id);
        usr.setUsername(body.username());
        usr.setRoles(getUserRoles(body.roles()));
        userRepository.save(usr);
        return new UserDto(usr);
    }

    private List<Role> getUserRoles(List<Role> roles) {
        return roleRepository.findAllById(roles.stream().map(Role::getId).toList());
    }

    public UserDto find(String id) {
        var usr = findById(id);
        return new UserDto(usr);
    }

    public void delete(String id) {
        userRepository.deleteById(Long.parseLong(id));
    }
}
