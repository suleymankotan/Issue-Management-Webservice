package issuemanagement.service;

import issuemanagement.entity.Project;
import issuemanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }

    public Project getById(Long id){
        return projectRepository.getOne(id);
    }

    public Page<Project> getAllPageable(Pageable pageable){
        return projectRepository.findAll(pageable);
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
