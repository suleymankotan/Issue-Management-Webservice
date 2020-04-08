package issuemanagement.service;

import issuemanagement.entity.IssueHistory;

import issuemanagement.repository.IssueHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IssueHistoryService {
    @Autowired
    IssueHistoryRepository issueHistoryRepository;

    public IssueHistory save(IssueHistory issueHistory){
        return issueHistoryRepository.save(issueHistory);
    }

    public IssueHistory getById(Long id){
        return issueHistoryRepository.getOne(id);
    }

    public Page<IssueHistory> getAllPageable(Pageable pageable){
        return issueHistoryRepository.findAll(pageable);
    }

    public Boolean delete(IssueHistory issueHistory){
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }

}
