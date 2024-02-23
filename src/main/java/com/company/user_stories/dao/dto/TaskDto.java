package com.company.user_stories.dao.dto;

import com.company.user_stories.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TaskDto {

    private String title;

    private String description;

    private String deadline;

    private TaskStatus status;

}
