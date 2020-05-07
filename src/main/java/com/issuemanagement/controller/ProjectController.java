package com.issuemanagement.controller;

import com.issuemanagement.model.ProjectModel;
import com.issuemanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @GetMapping("/{id}")
    public ResponseEntity<ProjectModel> getById( @PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(projectService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectModel> createProject(@Valid @RequestBody ProjectModel projectModel){
        return  ResponseEntity.ok(projectService.save(projectModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectModel> updateProject(@PathVariable(value = "id", required = true) Long id,@Valid @RequestBody ProjectModel projectModel){
        return ResponseEntity.ok(projectService.updateProject(projectModel,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(projectService.delete(id));
    }



}
