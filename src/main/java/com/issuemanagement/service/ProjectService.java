package com.issuemanagement.service;

import com.issuemanagement.entity.Project;
import com.issuemanagement.model.ProjectModel;
import com.issuemanagement.repository.ProjectRepository;
import com.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ModelMapper modelMapper;



    public ProjectModel save(ProjectModel projectModel){
        Project projectCodeCheck = projectRepository.getByProjectCode(projectModel.getProjectCode());
        if (projectCodeCheck != null)
            throw new IllegalArgumentException("Project Code Already Exits Project Code:"+projectModel.getProjectCode());

        return modelMapper.map(projectRepository.save(
                modelMapper.map(projectModel,Project.class)),ProjectModel.class);
    }

    public ProjectModel getById(Long id){
        if (projectRepository.getById(id) == null)
            throw new IllegalArgumentException("Project Id null");
        Project project = projectRepository.getById(id);
        return modelMapper.map(project,ProjectModel.class);
    }

    public ProjectModel updateProject(ProjectModel projectModel,Long id){
        Project project = projectRepository.getById(id);
        if (project == null)
            throw new IllegalArgumentException("Project does Not Exist ID:"+ id);
        Project projectCodeCheck = projectRepository.getByProjectCodeAndIdNot(projectModel.getProjectCode(),id);
        if (projectCodeCheck != null )
            throw new IllegalArgumentException("Project Code Already Exits Project Code:"+projectModel.getProjectCode());

        project.setProjectCode(projectModel.getProjectCode());
        project.setProjectName(projectModel.getProjectName());
        projectRepository.save(project);

        return modelMapper.map( project,ProjectModel.class);
    }

    public TPage<ProjectModel> getAllPageable(Pageable pageable){
        return null;
    }

    public List<Project> getByProjectCodeContains(String projectCode){
        return null;
    }

    public List<Project> getByProjectCode(String projectCode){
        return null;
    }

    public Boolean delete(Long id){
        if (projectRepository.getById(id) != null) {
            projectRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
