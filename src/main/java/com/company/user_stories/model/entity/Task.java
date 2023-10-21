package com.company.user_stories.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "title")
    @NonNull
    private String title;
    @Column(name = "description")
    @NonNull
    private String description;
    @Column(name = "deadline")
    @NonNull
    private String deadline;
    @Column(name = "status")
    @NonNull
    private String status;

    private Long userId;

    @ManyToMany(mappedBy = "tasks")
    private List<User> users;
}
