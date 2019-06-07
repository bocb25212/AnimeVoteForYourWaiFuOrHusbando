package com.Sean.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.Sean.pojo.Animecharacter;
import com.Sean.service.impl.AnimeCharacterServiceImpl;
@Controller
@RequestMapping("AnimeCharacterController")
public class AnimeCharacterController {
	@Autowired
	AnimeCharacterServiceImpl AnimeCharacterServiceImpl;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	   
	    public String add(@RequestPart("file") MultipartFile 
	    		 file,HttpServletRequest request){
		
		String name=request.getParameter("name");
        String filePath = "/Users/sean87/Desktop/images";
        String originalFilename = file.getOriginalFilename();
        String newFileName = UUID.randomUUID()+originalFilename;
        File targetFile = new File(filePath,newFileName); 
        try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		Animecharacter ac = new Animecharacter();
		ac.setImage(newFileName);
		ac.setName(name);
		ac.setVotecount(0);
		AnimeCharacterServiceImpl.addAnimeCharacter(ac);
		// return JsonMsg.success().addInfo("Success", "新增成功！！");
		return "redirect:/puellaMagi/index";
	    }
}
