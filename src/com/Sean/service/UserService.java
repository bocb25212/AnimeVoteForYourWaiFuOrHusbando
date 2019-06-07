package com.Sean.service;

import org.springframework.stereotype.Service;

import com.Sean.pojo.User;
public interface UserService {

    public boolean addUser(User user);

    public int login(String username,String password);

    public boolean addCredit(Integer points,Integer id);

    public boolean existUsername(String username);

    public User getUserByUsername(String username);

    public User getUserById(Integer id);
   
    public int getUserCount();

    public boolean updateUser(User user);
}
