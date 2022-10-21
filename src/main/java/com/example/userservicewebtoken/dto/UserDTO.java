package com.example.userservicewebtoken.dto;

import com.example.userservicewebtoken.entity.Role;
import com.example.userservicewebtoken.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private Long id;

    private String name;
    private String username;
    private String password;
    private Collection<Role> roles = new ArrayList<>();

    /**
     * Convert UserDTO to entity User
     * @return User entity
     */
    public User toEntity(){
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setRoles(this.roles);
        return user;
    }

}
