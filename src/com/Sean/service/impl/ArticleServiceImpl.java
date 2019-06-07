package com.Sean.service.impl;

import com.Sean.mapper.ArticleMapper;
import com.Sean.pojo.Page;
import com.Sean.pojo.Article;
import com.Sean.pojo.ArticleExample;
import com.Sean.service.ArticleService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    public ArticleMapper ArticleMapper;

	@Override
	public List<Article> getAllArticles() {
		ArticleExample  c = new ArticleExample();
		return 	ArticleMapper.selectByExample(c);
	}
	
	@Override
	public Article getArticleById(Integer articleId) {
		return 	ArticleMapper.selectByPrimaryKey(articleId);
	}
}
