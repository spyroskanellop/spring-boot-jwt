package com.example.userservicewebtoken.service;

import com.example.userservicewebtoken.dto.RoleDTO;
import com.example.userservicewebtoken.dto.UserDTO;
import com.example.userservicewebtoken.entity.Role;
import com.example.userservicewebtoken.entity.User;

import javax.management.relation.RoleStatus;
import java.util.List;

public interface UserService {
    UserDTO saveUser(User user);
    RoleDTO saveRole(Role role);
    UserDTO getUserByUsername(String username);
    List<UserDTO> getUsers();


    void addRoleToUser(String username, String roleName);
}
