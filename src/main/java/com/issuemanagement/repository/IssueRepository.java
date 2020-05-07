package com.issuemanagement.repository;

import com.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long>{
    Issue getById(Long id);
}
