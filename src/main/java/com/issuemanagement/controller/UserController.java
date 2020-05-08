package com.issuemanagement.controller;

import com.issuemanagement.model.UserModel;
import com.issuemanagement.service.UserService;
import com.issuemanagement.util.TPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/pagination")
    public ResponseEntity<TPage<UserModel>> getAllByPagination(Pageable pageable){
        return ResponseEntity.ok(userService.getAllPageable(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getById(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserModel> createProject(@Valid @RequestBody UserModel userModel){
        return  ResponseEntity.ok(userService.save(userModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateProject(@PathVariable(value = "id", required = true) Long id,@Valid @RequestBody UserModel userModel){
        return ResponseEntity.ok(userService.updateUser(userModel,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id",required = true) Long id){
        return ResponseEntity.ok(userService.delete(id));
    }
}
