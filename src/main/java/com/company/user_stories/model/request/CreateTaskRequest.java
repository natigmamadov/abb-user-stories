package com.company.user_stories.model.request;

import com.company.user_stories.model.enums.TaskStatus;
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
    private TaskStatus status;

}
