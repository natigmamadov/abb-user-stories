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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    private String name;
    private String surname;
    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
    private String email;
    private String defaultPassword;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @ManyToMany
    @JoinColumn(name = "task_id")
    private List<Task> tasks;
}
