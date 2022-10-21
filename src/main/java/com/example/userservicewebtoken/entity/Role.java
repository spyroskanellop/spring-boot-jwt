package com.example.userservicewebtoken.entity;

import com.example.userservicewebtoken.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public RoleDTO toDTO(){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(this.id);
        roleDTO.setName(this.name);
        return roleDTO;
    }
}
