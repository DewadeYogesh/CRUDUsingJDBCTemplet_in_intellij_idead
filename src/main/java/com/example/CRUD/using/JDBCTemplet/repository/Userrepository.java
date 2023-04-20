package com.example.CRUD.using.JDBCTemplet.repository;

import com.example.CRUD.using.JDBCTemplet.entity.User;
import java.util.List;

public interface Userrepository {

    int insertUser(User user);

    List<User> getAllUsers();

    void deleteUser(int id);
  void   updateUser(User user);
}
