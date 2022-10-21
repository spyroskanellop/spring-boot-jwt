package com.example.userservicewebtoken.service;

import com.example.userservicewebtoken.dto.RoleDTO;
import com.example.userservicewebtoken.dto.UserDTO;
import com.example.userservicewebtoken.entity.Role;
import com.example.userservicewebtoken.entity.User;
import com.example.userservicewebtoken.repository.RoleRepository;
import com.example.userservicewebtoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
//@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
//    private final PasswordEncoder passwordEncoder;

    ModelMapper mapper = new ModelMapper();

    @Override
    public UserDTO saveUser(User user) {
        log.info("Saving new user {} to db", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).toDTO();
    }

    @Override
    public RoleDTO saveRole(Role role) {
        log.info("Saving new role {} to db", role.getName());
        return roleRepository.save(role).toDTO();
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        log.info("Getting user {} from db by username", username);
        return userRepository.findByUsername(username).toDTO();
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Get all users from db");
        List<User> users =  userRepository.findAll();
        List<UserDTO> userDTO = Arrays.asList(mapper.map(users, UserDTO[].class));
        return userDTO;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Assign role {} to user {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            log.error("User {} not found in database", username);
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
