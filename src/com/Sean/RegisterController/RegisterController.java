package com.Sean.RegisterController;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Sean.mapper.UserMapper;
import com.Sean.pojo.*;
import com.Sean.utils.JsonMsg;
@Controller
@RequestMapping("RegisterController")
public class RegisterController {
	@Autowired
	UserMapper UserMapper;

	//路徑導到註冊畫面
	@RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(){
        return "register";
    }
	
	
	 @RequestMapping(value = "doRegister", method = {RequestMethod.POST,RequestMethod.GET })
	 @ResponseBody
	    public JsonMsg doRegister(HttpServletRequest request){
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        User user = new User();
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setCredit(0);
	        user.setType(new Byte((byte) 0));
	        boolean duplicate = false;
	        UserExample  c = new UserExample();
	        c.createCriteria();
	        List<User> memberList = UserMapper.selectByExample(c);

	        if("".equals(username.trim())||"".equals(password.trim())) {
	        	 return JsonMsg.fail().addInfo("registerFail", "帳號或密碼為空！！請重新輸入"); 
	        }
	        
	        for(User pojo:memberList) {
	        	if(pojo.getUsername().equals(user.getUsername())) {
	        		 duplicate = true;
	        		 return JsonMsg.fail().addInfo("registerFail", "已有人使用此帳號！！註冊失敗");
	        	}
	        }
	        if(duplicate == false) {
	        	UserMapper.insert(user);
	        }
	   System.out.println("duplicate:"+duplicate);
	        return JsonMsg.success().addInfo("registerSuccess", "註冊成功！！");
	    }
	
	
}
