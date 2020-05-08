package com.issuemanagement.service;


import com.issuemanagement.entity.User;
import com.issuemanagement.model.UserModel;
import com.issuemanagement.repository.UserRepository;
import com.issuemanagement.util.TPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserModel save(UserModel userModel){
        return null;
    }

    public UserModel getById(Long id){
        return modelMapper.map(userRepository.getById(id),UserModel.class);
    }

    public Boolean delete(Long id){
        if (userRepository.getById(id) != null) {
            userRepository.deleteById(id);
            log.info("Delete User:" + userRepository.getById(id));
            return true;
        }else
            return false;
    }

    public User getByUsername(String username){
        return null;
    }

    public UserModel updateUser(UserModel userModel, Long id) {

        return  null;
    }

    public TPage<UserModel> getAllPageable(Pageable pageable) {
        Page<User> data = userRepository.findAll(pageable);
        TPage<UserModel> userModelTPage = new TPage<>();
        userModelTPage.setStat(data, Arrays.asList(modelMapper.map(data.getContent(),UserModel.class)));
        return userModelTPage;
    }

    public List<UserModel> getAll() {
        List<User> data = userRepository.findAll();
        return  Arrays.asList(modelMapper.map(data,UserModel.class));

    }
}
