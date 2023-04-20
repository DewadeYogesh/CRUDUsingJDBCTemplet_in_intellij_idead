package com.example.CRUD.using.JDBCTemplet.dao;

import com.example.CRUD.using.JDBCTemplet.entity.User;
import com.example.CRUD.using.JDBCTemplet.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserrepoImpl  implements Userrepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


   @Override
    public int insertUser(User user) {
        String s = "insert into user values(?,?,?)";
        int i = jdbcTemplate.update((s), user.getIduser(), user.getUserfname(), user.getUserlname());

        return i;
    }

 @Override
    public List<User> getAllUsers() {
        String query="select * from user";
      return   jdbcTemplate.query(query,(user, rowNum) ->{

           User  user1= new User(
                user.getInt("iduser"),
                user.getString("userfname"),
                user.getString("userlname")

        );

       return user1;
        });

    }

    @Override
    public void deleteUser(int id) {
        String s="delete from user where iduser=?";
        jdbcTemplate.update(s,id);
    }

    @Override
    public void updateUser(User user) {
        String s="update user set userfname=?,userlname=? where iduser=?";
        jdbcTemplate.update(s,user.getUserfname(),user.getUserlname(),user.getIduser());



    }


}


