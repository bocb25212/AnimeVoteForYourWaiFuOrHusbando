package com.Sean.controller;

import com.Sean.pojo.Tab;
import com.Sean.service.impl.ReplyServiceImpl;
import com.Sean.service.impl.TabServiceImpl;
import com.Sean.service.impl.TopicServiceImpl;
import com.Sean.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/forum")
public class MainController {

    @Autowired
    public TopicServiceImpl topicService;
    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public TabServiceImpl tabService;

 
	@RequestMapping("signin")
    public ModelAndView signin(){
        ModelAndView signinPage=new ModelAndView();

      
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signinPage.addObject("topicsNum",topicsNum);
        signinPage.addObject("usersNum",usersNum);
        return  signinPage;
    }

  
    @RequestMapping("/signup")
    public ModelAndView signup(){
        ModelAndView signupPage=new ModelAndView("signup");

      
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signupPage.addObject("topicsNum",topicsNum);
        signupPage.addObject("usersNum",usersNum);
        return  signupPage;
    }

  
    @RequestMapping(value = {"/new"})
    public ModelAndView newTopic(){
        ModelAndView newTopicPage=new ModelAndView();
        List<Tab> tabs=tabService.getAllTabs();

        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        newTopicPage.addObject("tabs",tabs);
        newTopicPage.addObject("topicsNum",topicsNum);
        newTopicPage.addObject("usersNum",usersNum);
        return  newTopicPage;
    }

  
    @RequestMapping("*")
    public String notFind(){
        return "404";
    }
}
