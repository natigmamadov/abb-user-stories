package com.company.user_stories.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String organizationName;

    private String phoneNumber;

    private String address;
    private String userName;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]{6,}$\n")
    private String password;

    @OneToMany(mappedBy = "organization")
    private List<User> users;



}
