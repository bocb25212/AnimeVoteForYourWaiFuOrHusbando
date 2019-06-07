package com.Sean.LoginController;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Sean.pojo.User;
import com.Sean.pojo.UserExample;
import com.Sean.mapper.UserMapper;
import com.Sean.utils.JsonMsg;
@Controller
@RequestMapping("LoginController")
public class LoginController {
	@Autowired
	UserMapper UserMapper;

	 @RequestMapping(value = "login", method = RequestMethod.GET)
	    public String login(){
	        return "login";
	    }
	 
	 @RequestMapping(value = "dologin", method = RequestMethod.POST)
	    @ResponseBody
	    public JsonMsg dologin(HttpServletRequest request){
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        JsonMsg jsonMsg = JsonMsg.fail().addInfo("login_error", "輸入的帳號與密碼不符，請重新輸入！");
	        UserExample c = new UserExample();
	        List<User> memberList = UserMapper.selectByExample(c);
	   
	        //登入成功
	        for(User pojo:memberList) {
	        	if(pojo.getUsername().equals(username)&&pojo.getPassword().equals(password)) {
	        		jsonMsg =JsonMsg.success().addInfo("loginSuccess", "登入成功！！"); 
	        		
	        		  request.getSession().setAttribute("userToken",pojo.getId());
	        	}
	        }
	      
	        
	        return jsonMsg;
	    }
	 
	 /**
	     * 跳轉到首頁
	     * @return
	     */
	    @RequestMapping(value = "home", method = RequestMethod.GET)
	    public String home(){
	        return "home";
	    }
	    /**
	     * 退出登錄：從首頁跳轉到登入頁面
	     * @return
	     */
	    @RequestMapping(value = "logout", method = RequestMethod.GET)
	    public String logout(HttpSession session){
	    	session.invalidate();
	        return "home";
	    }
}
