package com.example.userservicewebtoken.dto;

import com.example.userservicewebtoken.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Role toEntity(){
        Role role = new Role();
        role.setId(this.id);
        role.setName(this.name);
        return role;
    }
}
