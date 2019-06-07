package com.Sean.service;

import java.util.List;

import com.Sean.pojo.Article;

public interface ArticleService {
	 List<Article> getAllArticles();

	 Article getArticleById(Integer articleId);
}
