package com.example.CRUD.using.JDBCTemplet.controller;

import com.example.CRUD.using.JDBCTemplet.entity.User;
import com.example.CRUD.using.JDBCTemplet.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserControl {
    @Autowired
    private Userrepository userrepository;
    @PostMapping
    public int insert(@RequestBody User user){

    return  userrepository.insertUser(user);

    }
@GetMapping
    public List<User> getUsers(){
        return userrepository.getAllUsers();
    }

@DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id){
        userrepository.deleteUser(id);
        return "deleted";
}


    @PatchMapping ()
    public String updateUser(@RequestBody User user){
        userrepository.updateUser(user);
        return "Updated";
    }



}
