package com.company.user_stories.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "organization_name")
    private String organizationName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    private String userName;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]{6,}$\n")
    private String password;
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<User> users;



}
