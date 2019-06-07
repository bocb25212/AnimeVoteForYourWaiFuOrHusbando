package com.Sean.controller;

import com.Sean.pojo.LoginLog;
import com.Sean.pojo.Topic;
import com.Sean.pojo.User;
import com.Sean.service.impl.LoginLogServiceImpl;
import com.Sean.service.impl.TopicServiceImpl;
import com.Sean.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
public class UserController {

    @Autowired
    public UserServiceImpl userService;

    @Autowired
    public LoginLogServiceImpl loginLogService;

    @Autowired
    public TopicServiceImpl topicService;


    @RequestMapping("/user/add/do")
    public String addUser(HttpServletRequest request){
        User user=new User();
        String phoneNum=request.getParameter("tel");
        String areaCode=request.getParameter("areaCode");
        String phone=areaCode+phoneNum;
        Byte type=new Byte("0");
        String password= request.getParameter("password");
       
        Random rand=new Random();
     //  int randomNum=rand.nextInt(10)+1;
        String avatarUrl="314ab6b6-0e10-41b7-855f-8fd4581c7fffNeutralsprite.png";
        user.setUsername(request.getParameter("username"));
        user.setPassword(password);
        user.setEmail(request.getParameter("email"));
        user.setPhoneNum(phone);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setCredit(0);
        user.setType(type);
        user.setAvatar(avatarUrl);

        boolean ifSucc=userService.addUser(user);
 
        return "redirect:/home";
    }


    @RequestMapping("/api/loginCheck")
    @ResponseBody
    public Object signin(HttpServletRequest request,HttpSession session){
        String password=request.getParameter("password");
        String username=request.getParameter("username");
        int loginVerify=userService.login(username,password);

        HashMap<String, String> res = new HashMap<String, String>();

        if(loginVerify == 2){
            User user =userService.getUserByUsername(username);
            Integer userId=user.getId();
       
            boolean ifSuccAddCredit=userService.addCredit(1,userId);
          
            session.setAttribute("userToken",userId);
            session.setAttribute("username",username);
        
            String ip=getRemortIP(request);
       //     UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
         //   String userbrowser = userAgent.getBrowser().toString();
         
            LoginLog log=new LoginLog();
         //   log.setDevice(userbrowser);
            log.setIp(ip);
            log.setUserId(userId);
            log.setLoginTime(new Date());
            boolean ifSuccAddLog=loginLogService.addLog(log);

            res.put("stateCode", "2");
        }
       
        else if (loginVerify == 1){
            res.put("stateCode", "1");
        }
      
        else {
            res.put("stateCode", "0");
        }
        return res;
    }

    @RequestMapping("/signout")
    public String signout(HttpSession session){
        session.removeAttribute("userToken");
        session.removeAttribute("username");
        return "redirect:/home";
    }

  
    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

   
    @RequestMapping("/User/{username}")
    public ModelAndView personalCenter(@PathVariable("username")String username,HttpSession session){
        boolean ifExistUser=userService.existUsername(username);
     
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        Integer uid=(Integer) session.getAttribute("userToken");
        User user=userService.getUserById(uid);
      
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();

        ModelAndView mv=new ModelAndView("User/user_info");
        mv.addObject("hotestTopics",hotestTopics);
        if (ifExistUser){
            User resultUser=userService.getUserByUsername(username);
            mv.addObject("userInfo",resultUser);
            mv.addObject("topicsNum",topicsNum);
            mv.addObject("usersNum",usersNum);
            mv.addObject("user",user);
            return mv;
        }else {
            String errorInfo=new String("¿ù»~");
            mv.addObject("errorInfo",errorInfo);
            return mv;
        }
    }

    @RequestMapping("/settings")
    public ModelAndView settings(HttpServletRequest request, HttpSession session){

        Integer uid=(Integer) session.getAttribute("userToken");
        User user=userService.getUserById(uid);

      
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();

        ModelAndView mv=new ModelAndView("User/settings");
        mv.addObject("user",user);
        mv.addObject("hotestTopics",hotestTopics);
        return mv;
    }

    @RequestMapping(value = "/settings/avatar",method = RequestMethod.GET)
    public ModelAndView updateAvatar(HttpServletRequest request, HttpSession session){

        Integer uid=(Integer) session.getAttribute("userToken");
        User user=userService.getUserById(uid);

       
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();

        ModelAndView mv=new ModelAndView("User/update_avatar");
        mv.addObject("user",user);
        mv.addObject("hotestTopics",hotestTopics);
        return mv;
    }
    @RequestMapping(value = "/settings/avatar/update",method = RequestMethod.POST)
    public ModelAndView updateAvatarDo(@RequestPart("avatar")MultipartFile avatarFile, HttpServletRequest request, HttpSession session){
        Integer uid=(Integer) session.getAttribute("userToken");

        String filePath = "/Users/sean87/Desktop/images";
        String originalFilename = avatarFile.getOriginalFilename();
      //  String newFileName = UUID.randomUUID()+originalFilename;
    //    File targetFile = new File(filePath,newFileName); 
        User newUser=new User();
        newUser.setAvatar(originalFilename);
        newUser.setId(uid);
      
        try {
        	//avatarFile.transferTo(targetFile);
        	  userService.updateUser(newUser);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	User user=userService.getUserById(uid);

    
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();

        ModelAndView mv=new ModelAndView("User/settings");
        mv.addObject("user",user);

        mv.addObject("hotestTopics",hotestTopics);
        return mv;
    }

}
