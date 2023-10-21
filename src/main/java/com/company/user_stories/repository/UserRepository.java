package com.company.user_stories.repository;

import com.company.user_stories.model.entity.Organization;
import com.company.user_stories.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    List<User> findByOrganization(Organization organization);
}
