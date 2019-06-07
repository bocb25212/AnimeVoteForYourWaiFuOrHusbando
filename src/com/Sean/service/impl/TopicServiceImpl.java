package com.Sean.service.impl;

import com.Sean.mapper.TopicMapper;
import com.Sean.pojo.Page;
import com.Sean.pojo.Topic;
import com.Sean.service.TopicService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    public TopicMapper TopicMapper;


    public List<Topic> getAllTopics() {
        return TopicMapper.getAllTopics();
    }

    public Topic selectById(Integer id) {
        Topic topic=TopicMapper.selectById(id);
        return topic;
    }

    public List<Topic> listMostCommentsTopics() {
        return TopicMapper.listMostCommentsTopics();
    }

    public boolean addTopic(Topic topic) {
        return TopicMapper.insert(topic)>0;
    }

    public boolean clickAddOne(Integer id) {
        return TopicMapper.clickAddOne(id)>0;
    }

    public int getTopicsNum() {
        return TopicMapper.getTopicsNum();
    }

    public List<Topic> listTopicsAndUsers(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize) {
        return TopicMapper.listTopicsAndUsers(startPos,pageSize);
    }

    public List<Topic> listTopicsAndUsersOfTab(@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize,@Param(value="id")Integer tabId) {
        return TopicMapper.listTopicsAndUsersOfTab(startPos,pageSize,tabId);
    }

	@Override
	public void showTopicsAndUsersOfTabByPage(HttpServletRequest request, Model model,Integer tabId) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		List<Topic> topics = new ArrayList<Topic>();
		int totalCount = (int) TopicMapper.getTopicsNumByTabs(tabId);
	 
		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
			topics = TopicMapper.listTopicsAndUsersOfTab(page.getStartPos(), page.getPageSize(),tabId);
		} else {
			page = new Page(totalCount, 1);
			topics = TopicMapper.listTopicsAndUsersOfTab(page.getStartPos(), page.getPageSize(),tabId);
		}
	 
		model.addAttribute("topics", topics);
		model.addAttribute("page", page);
	}
	
	@Override
	public void showTopicsByPage(HttpServletRequest request, Model model) {
		String pageNow = request.getParameter("pageNow");
		Page page = null;
		List<Topic> topics = new ArrayList<Topic>();
		int totalCount = (int) TopicMapper.getTopicsNum();
	 
		if (pageNow != null) {
			page = new Page(totalCount, Integer.parseInt(pageNow));
			topics = TopicMapper.listTopicsAndUsers(page.getStartPos(), page.getPageSize());
		} else {
			page = new Page(totalCount, 1);
			topics = TopicMapper.listTopicsAndUsers(page.getStartPos(), page.getPageSize());
		}
	 
		model.addAttribute("topics", topics);
		model.addAttribute("page", page);
	}

	@Override
	public int getTopicsNumByTabs(Integer tabId) {
		 return TopicMapper.getTopicsNumByTabs(tabId);
	}
}
