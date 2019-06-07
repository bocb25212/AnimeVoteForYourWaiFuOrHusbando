package com.Sean.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Sean.pojo.AnimeCharacterComparator;
import com.Sean.pojo.Animecharacter;
import com.Sean.pojo.AnimecharacterExample;
import com.Sean.mapper.AnimecharacterMapper;



@Controller
@RequestMapping("/puellaMagi")
public class PuellaMagiController {
	@Autowired
	AnimecharacterMapper AnimecharacterMapper;

	@RequestMapping("index")
	public ModelAndView loadForm(){
		ModelAndView mav = new ModelAndView();
		AnimecharacterExample c = new AnimecharacterExample();
		c.createCriteria();
		List<Animecharacter> animeCharacterList = AnimecharacterMapper.selectByExample(c);
	//	Collections.sort(animeCharacterList,new AnimeCharacterComparator());
		mav.addObject("animeCharacterList",animeCharacterList);
		
		
		Collections.sort(animeCharacterList,new AnimeCharacterComparator());
		List<Animecharacter> top3AnimeCharacter = new ArrayList<Animecharacter>();
		for(int i=0;i<3;i++){
			top3AnimeCharacter.add(animeCharacterList.get(i));
		}
		mav.addObject("top3AnimeCharacter",top3AnimeCharacter);
		return mav;
	}
	
	@RequestMapping("vote")
	public ModelAndView vote(HttpServletRequest request){
		String id =request.getParameter("id");
		Animecharacter ac=AnimecharacterMapper.selectByPrimaryKey(Integer.parseInt(id));
		ac.setVotecount(ac.getVotecount()+1);
		AnimecharacterMapper.updateByPrimaryKeySelective(ac);
		ModelAndView mav = new ModelAndView("/puellaMagi/index");
		return  mav;
	}
}
