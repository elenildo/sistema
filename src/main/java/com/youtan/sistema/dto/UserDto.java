package com.youtan.sistema.dto;

import com.youtan.sistema.models.Role;
import com.youtan.sistema.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String username;
    private List<Role> roles;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles();
    }
}
