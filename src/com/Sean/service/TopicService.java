package com.Sean.service;

import com.Sean.pojo.Topic;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
public interface TopicService {

    List<Topic> getAllTopics();

    List<Topic> listTopicsAndUsers(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    
    void showTopicsByPage(HttpServletRequest request,Model model);
    
    List<Topic> listMostCommentsTopics();

    List<Topic> listTopicsAndUsersOfTab(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="id")Integer tabId);

    Topic selectById(Integer id);

    boolean addTopic(Topic topic);
    
    boolean clickAddOne(Integer id);

    int getTopicsNum();
    
    int getTopicsNumByTabs(@Param(value="id")Integer tabId);

	void showTopicsAndUsersOfTabByPage(HttpServletRequest request, Model model, Integer tabId);

}
