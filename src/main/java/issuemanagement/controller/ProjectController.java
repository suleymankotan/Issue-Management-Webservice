package issuemanagement.controller;

import issuemanagement.model.ProjectModel;
import issuemanagement.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class ProjectController {

    final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectModel> getById( @PathVariable Long id){
        return ResponseEntity.ok(projectService.getById(id));
    }
    @PostMapping
    public ResponseEntity<ProjectModel> createProject(@Valid @RequestBody ProjectModel projectModel){
        return  ResponseEntity.ok(projectService.save(projectModel));
    }


}
