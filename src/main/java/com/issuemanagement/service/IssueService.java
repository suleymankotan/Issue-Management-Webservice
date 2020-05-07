package com.issuemanagement.service;

import com.issuemanagement.entity.Issue;
import com.issuemanagement.model.IssueModel;
import com.issuemanagement.repository.IssueRepository;
import com.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueService {

    @Autowired
    IssueRepository issueRepository;
    @Autowired
    ModelMapper modelMapper;

    public IssueModel save(IssueModel issueModel){
        if (issueModel.getDate()==null)
            throw  new IllegalArgumentException("Issue Date cannot be null");

        Issue issueDb = modelMapper.map(issueModel,Issue.class);
        issueDb= issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueModel.class);
    }

    public IssueModel getById(Long id){

        return null;
    }

    public TPage<IssueModel> getAllPageable(Pageable pageable){
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueModel> page = new TPage();
        IssueModel[]issueModels =modelMapper.map(data.getContent(),IssueModel[].class);
        page.setStat(data, Arrays.asList(issueModels));
        return page;
    }

    public Boolean delete(Long id){
        return null;
    }

    public IssueModel updateIssue(IssueModel issueModel, Long id) {
        return null;
    }
}
