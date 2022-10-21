package com.example.userservicewebtoken.entity;

import com.example.userservicewebtoken.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role>roles = new ArrayList<>();

    public UserDTO toDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.id);
        userDTO.setName(this.name);
        userDTO.setUsername(this.username);
        userDTO.setPassword(this.password);
        userDTO.setRoles(this.roles);
        return userDTO;
    }

}
