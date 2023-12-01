package com.shoggoth.fileserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToMany(targetEntity = RoleEntity.class)
    @JoinColumn(name = "role_id")
    private List<RoleEntity> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<EventEntity> events;

}
