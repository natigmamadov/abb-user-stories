package com.company.user_stories.repository;

import com.company.user_stories.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends JpaRepository<Task,Long> {

    @Modifying
    @Query("update Task t set t.userId = ?2 where t.id = ?1")
    void setUserIdForPresentTask(Long taskId,Long userId);
}
