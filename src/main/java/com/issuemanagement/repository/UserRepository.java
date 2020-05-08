package com.issuemanagement.repository;

import com.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User getById(Long id);
}
