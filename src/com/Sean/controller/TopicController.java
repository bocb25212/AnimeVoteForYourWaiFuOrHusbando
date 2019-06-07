package com.Sean.controller;

import com.Sean.pojo.Reply;
import com.Sean.pojo.Tab;
import com.Sean.pojo.Topic;
import com.Sean.pojo.User;
import com.Sean.service.impl.ReplyServiceImpl;
import com.Sean.service.impl.TabServiceImpl;
import com.Sean.service.impl.TopicServiceImpl;
import com.Sean.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Controller
@RequestMapping("Topic")
public class TopicController {

    @Autowired
    public TopicServiceImpl topicService;
    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public TabServiceImpl tabService;

 
    private final Log log = LogFactory.getLog(getClass());

 
    @RequestMapping("index")
    public ModelAndView index(HttpSession session,HttpServletRequest request, Model model){
        ModelAndView indexPage=new ModelAndView();
        
        //封裝request //page和topics 需注意
        topicService.showTopicsByPage(request, model);
      
       
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();
     
        Integer uid=(Integer) session.getAttribute("userToken");
        User user=userService.getUserById(uid);
       
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();

     
        indexPage.addObject("hotestTopics",hotestTopics);
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("user",user);
        indexPage.addObject("tabList",tabService.getAllTabs());
        return  indexPage;
    }

   
    @RequestMapping("/topic/{id}")
    public ModelAndView toTopic(@PathVariable("id")Integer id,HttpSession session){
      
        boolean ifSucc=topicService.clickAddOne(id);
      
        Topic topic=topicService.selectById(id);
      
        List<Reply> replies=replyService.getRepliesOfTopic(id);
     
        int repliesNum=replyService.repliesNum(id);
       
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();
       
        Integer uid=(Integer) session.getAttribute("userToken");
        User user=userService.getUserById(uid);
       
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();

      
        ModelAndView topicPage=new ModelAndView("Topic/detail");
        topicPage.addObject("topic",topic);
        topicPage.addObject("replies",replies);
        topicPage.addObject("repliesNum",repliesNum);
        topicPage.addObject("topicsNum",topicsNum);
        topicPage.addObject("usersNum",usersNum);
        topicPage.addObject("user",user);
        topicPage.addObject("hotestTopics",hotestTopics);
        return topicPage;
    }

   
    @RequestMapping("/tab/{tabNameEn}")
    public ModelAndView toTabPage(@PathVariable("tabNameEn")String tabNameEn,HttpSession session,
    		HttpServletRequest request, Model model){
        Tab tab=tabService.getByTabNameEn(tabNameEn);
        Integer tabId=tab.getId();
       
        ModelAndView indexPage=new ModelAndView("Topic/index");
      //封裝request //page和topicsAndUsersOfTab 需注意
        topicService.showTopicsAndUsersOfTabByPage(request, model, tabId);
      
       
        
        
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

       
        Integer uid=(Integer) session.getAttribute("userToken");
        User user=userService.getUserById(uid);
       
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //點選分類的分頁連結丟到頁面用c:if判斷
        indexPage.addObject("tabPageURL","tabPageURL");
        
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("tabList",tabService.getAllTabs());
        indexPage.addObject("user",user);
        indexPage.addObject("hotestTopics",hotestTopics);
        indexPage.addObject("tabNameEn",tabNameEn);
        return  indexPage;
    }

   
    @RequestMapping(value = "/topic/add", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView addTopic(HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException{
        ModelAndView indexPage;
       
        if(session.getAttribute("userToken")==null){
            indexPage=new ModelAndView("redirect:/signin");
            return  indexPage;
        }
        
        Integer userId=(Integer) session.getAttribute("userToken");
        String title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");  
        String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");  
        Byte tabId=Byte.parseByte(request.getParameter("tab"));
        
        Topic topic=new Topic();
        topic.setUserId(userId);
        topic.setTitle(title);
        topic.setContent(content);
        topic.setTabId(tabId);
        topic.setClick(0);
        topic.setCreateTime(new Date());
        topic.setUpdateTime(new Date());
     
        boolean ifSucc=topicService.addTopic(topic);
        boolean ifSuccAddCredit=userService.addCredit(1,userId);
        if (ifSucc){
            if (log.isInfoEnabled()){
                log.info("測試測試");
            }
        }
        indexPage=new ModelAndView("redirect:/Topic/index");

        return  indexPage;
    }

}
