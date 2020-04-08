package issuemanagement.service;

import issuemanagement.entity.Issue;
import issuemanagement.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepository;

    public Issue save(Issue issue){
        return issueRepository.save(issue);
    }

    public Issue getById(Long id){
        return issueRepository.getOne(id);
    }

    public Page<Issue> getAllPageable(Pageable pageable){
        return issueRepository.findAll(pageable);
    }

    public Boolean delete(Issue issue){
        return null;
    }
}
