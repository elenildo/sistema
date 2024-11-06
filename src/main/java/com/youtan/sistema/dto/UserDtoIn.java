package com.youtan.sistema.dto;

import com.youtan.sistema.models.Role;

import java.util.List;

public record UserDtoIn(String username, List<Role> roles) {
}
