package com.issuemanagement.controller;

import com.issuemanagement.model.IssueModel;
import com.issuemanagement.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class IssueController {
    @Autowired
    IssueService issueService;


    @GetMapping("/{id}")
    public ResponseEntity<IssueModel> getById(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueService.getById(id));
    }

    @PostMapping
    public ResponseEntity<IssueModel> createProject(@Valid @RequestBody IssueModel issueModel){
        return  ResponseEntity.ok(issueService.save(issueModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueModel> updateProject(@PathVariable(value = "id", required = true) Long id,@Valid @RequestBody IssueModel issueModel){
        return ResponseEntity.ok(issueService.updateIssue(issueModel,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(issueService.delete(id));
    }

}
