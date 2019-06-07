package com.Sean.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Sean.pojo.Article;
import com.Sean.pojo.User;
import com.Sean.service.impl.ArticleServiceImpl;
import com.Sean.service.impl.UserServiceImpl;

@Controller
@RequestMapping("")
public class HomeController {
	 @Autowired
	  public ArticleServiceImpl ArticleServiceImpl;
	 @Autowired
	    public UserServiceImpl userService;
	
	@RequestMapping("home")
	public ModelAndView loadFrom(){
		List<Article> articleList = ArticleServiceImpl.getAllArticles();
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("articleList",articleList);
		return mav;
	}
	@RequestMapping("/User/home/{userId}")
    public ModelAndView getUser(@PathVariable("userId")Integer userId){
        User user=userService.getUserById(userId);
        ModelAndView mv=new ModelAndView("User/user_info");
            mv.addObject("userInfo",user);
            return mv;
    }
	@RequestMapping("Article/detail/{articleId}")
	public ModelAndView articleDetail(@PathVariable("articleId")Integer articleId){
		Article article = ArticleServiceImpl.getArticleById(articleId);
		ModelAndView mav = new ModelAndView("article/detail");
		mav.addObject("article",article);
		System.out.println("fsfsdfds");
		return mav;
	}

}
