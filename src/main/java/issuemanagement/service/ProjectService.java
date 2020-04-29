package issuemanagement.service;

import issuemanagement.entity.Project;
import issuemanagement.model.ProjectModel;
import issuemanagement.repository.ProjectRepository;
import issuemanagement.util.TPage;
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
        return modelMapper.map(projectRepository.save(modelMapper.map(projectModel,Project.class)),ProjectModel.class);
    }

    public ProjectModel getById(Long id){
        Project project = projectRepository.getById(id);
        return modelMapper.map(project,ProjectModel.class);
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

    public Boolean delete(Project project){
        return null;
    }
}
