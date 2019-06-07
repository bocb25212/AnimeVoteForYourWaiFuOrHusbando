package com.Sean.mapper;

import com.Sean.pojo.Topic;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectById(Integer id);

    List<Topic> listTopicsAndUsers(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);

    List<Topic> listTopicsAndUsersOfTab(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="id")Integer tabId);

    List<Topic>  listMostCommentsTopics();

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> getAllTopics();

    int clickAddOne(Integer id);

 
    int getTopicsNum();

	int getTopicsNumByTabs(@Param(value="id")Integer tabId);
}