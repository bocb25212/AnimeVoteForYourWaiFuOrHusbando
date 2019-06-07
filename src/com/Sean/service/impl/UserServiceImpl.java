package com.Sean.service.impl;

import com.Sean.mapper.UserMapper;
import com.Sean.pojo.User;
import com.Sean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper UserMapper;

 
    public boolean addUser(User user) {
        return UserMapper.addUser(user)>0;
    }

    public int login(String username,String password) {
    
        boolean existUsername=existUsername(username);
      
        if (existUsername){
            User resUser=UserMapper.selectByUsername(username);
            if (resUser.getPassword().equals(password)){
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public User getUserByUsername(String username){
        User resUser=UserMapper.selectByUsername(username);
        return resUser;
    }

    public boolean addCredit(Integer points,Integer id) {
        return UserMapper.addCredit(points,id)>0;
    }

    public boolean existUsername(String username) {
        return UserMapper.existUsername(username)==1;
    }

    public int getUserCount() {
        return UserMapper.getUserCount();
    }

    public User getUserById(Integer id) {
        return UserMapper.selectByPrimaryKey(id);
    }

    public boolean updateUser(User user) {
        return UserMapper.updateByPrimaryKeySelective(user)>0;
    }
}
