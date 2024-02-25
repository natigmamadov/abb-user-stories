package com.company.user_stories.repository;

import com.company.user_stories.dao.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByUserNameAndEmail(String userName,String email);

    Organization findByUserNameAndPassword(String userName, String password);
}
