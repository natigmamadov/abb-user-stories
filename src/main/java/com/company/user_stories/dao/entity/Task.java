package com.company.user_stories.dao.entity;

import com.company.user_stories.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private String deadline;

    @Enumerated(STRING)
    private TaskStatus status;

    @ManyToMany(mappedBy = "tasks",cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<User> users;
}
