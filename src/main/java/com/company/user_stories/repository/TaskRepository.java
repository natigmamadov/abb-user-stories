package com.company.user_stories.repository;

import com.company.user_stories.dao.entity.Task;
import com.company.user_stories.model.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task,Long> {
    Optional<Task> findByIdAndStatusNot(Long id, TaskStatus status);

//    @Modifying
//    @Query("update Task t set t.userId = ?2 where t.id = ?1")
//    void setUserIdForPresentTask(Long taskId,Long userId);
}
