package issuemanagement.service;

import issuemanagement.entity.Project;
import issuemanagement.model.ProjectModel;
import issuemanagement.repository.ProjectRepository;
import issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    ProjectRepository projectRepository;
    ModelMapper modelMapper;

    public ProjectService(ProjectRepository projectRepository,ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper= modelMapper;
    }

    public ProjectModel save(Project project){
        return null;
    }

    public ProjectModel getById(Long id){
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p,ProjectModel.class);
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
