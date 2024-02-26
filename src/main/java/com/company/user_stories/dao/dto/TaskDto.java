package com.company.user_stories.dao.dto;

import com.company.user_stories.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDto {

    private String title;

    private String description;

    private LocalDateTime deadline;

    private TaskStatus status;

}
