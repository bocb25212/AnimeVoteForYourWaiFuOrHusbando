package com.Sean.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.Sean.pojo.Animecharacter;

import com.Sean.mapper.AnimecharacterMapper;
@Controller
@RequestMapping("AnimeCharacterController")
public class AnimeCharacterController {
	@Autowired
	AnimecharacterMapper AnimeCharacterMapper;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	   
	    public String add(HttpServletRequest request,MultipartFile file,Animecharacter animeCharacter,ModelMap map){
		
//		try {
//			
//			AnimeCharacterService.add(request, file, animeCharacter, map);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		// return JsonMsg.fail().addInfo("fail", "新增失敗！！");
//		}
		// return JsonMsg.success().addInfo("Success", "新增成功！！");
		return "redirect:/puellaMagi/index";
	    }
}
