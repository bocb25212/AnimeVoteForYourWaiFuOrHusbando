package com.Sean.mapper;

import com.Sean.pojo.User;
import com.Sean.pojo.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

  
    int addUser(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);


    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

  
    int addCredit(@Param("points") Integer points,@Param("id")Integer id);

    
    int existUsername(String username);

   
    int getUserCount();


	List<User> selectByExample(UserExample c);


	void insert(User user);
}