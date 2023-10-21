package com.company.user_stories.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {


    private Long userId;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private String deadline;

    @NonNull
    private String status;

}
