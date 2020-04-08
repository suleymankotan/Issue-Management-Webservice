package issuemanagement.service;


import issuemanagement.entity.User;
import issuemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }

    public User getById(Long id){
        return userRepository.getOne(id);
    }

    public Page<User> getAllPageable(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public Boolean delete(User user){
        return null;
    }

    public User getByUsername(String username){
        return null;
    }

}
