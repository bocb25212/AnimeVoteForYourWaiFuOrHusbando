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

	//���|�ɨ���U�e��
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
	        	 return JsonMsg.fail().addInfo("registerFail", "�b���αK�X���šI�I�Э��s��J"); 
	        }
	        
	        for(User pojo:memberList) {
	        	if(pojo.getUsername().equals(user.getUsername())) {
	        		 duplicate = true;
	        		 return JsonMsg.fail().addInfo("registerFail", "�w���H�ϥΦ��b���I�I���U����");
	        	}
	        }
	        if(duplicate == false) {
	        	UserMapper.insert(user);
	        }
	   System.out.println("duplicate:"+duplicate);
	        return JsonMsg.success().addInfo("registerSuccess", "���U���\�I�I");
	    }
	
	
}
