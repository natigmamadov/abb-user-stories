package com.company.user_stories.repository;

import com.company.user_stories.model.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByUserName(String userName);

    Organization findByUserNameAndPassword(String userName, String password);
}
