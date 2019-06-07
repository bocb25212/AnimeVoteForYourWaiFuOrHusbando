package com.Sean.controller;

import com.Sean.pojo.Reply;
import com.Sean.service.impl.ReplyServiceImpl;
import com.Sean.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.UnsupportedEncodingException;
import java.util.Date;


@Controller
@RequestMapping("ReplyController")
public class ReplyController {

    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;

    
    @RequestMapping(value = "/reply/add",method = RequestMethod.POST)
    public ModelAndView addReply(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException{
       
        Integer topicId=Integer.parseInt(request.getParameter("topicId"));
        Integer replyUserId=Integer.parseInt(request.getParameter("replyUserId"));
        String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
        Reply reply=new Reply();
        reply.setTopicId(topicId);
        reply.setReplyUserId(replyUserId);
        reply.setContent(content);
        reply.setCreateTime(new Date());
        reply.setUpdateTime(new Date());
       
        boolean ifSucc=replyService.addReply(reply);
   
        boolean ifSuccAddCredit=userService.addCredit(1,replyUserId);

       
        ModelAndView view=new ModelAndView("redirect:/Topic/topic/"+topicId);
        return view;
    }


}
