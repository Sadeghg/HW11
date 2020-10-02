package service.article;

import model.Article;
import model.User;
import model.helper.ArticleInfo;
import template.service.BaseService;

import java.util.List;

public interface ArticleService extends BaseService<Article, Integer, ArticleInfo> {

    Article findByTitle(String title);

    List<Article> findByUser(int id);

    List<Article> findByUserCategory(int id);

    List<Article> findByState();

    void delete(Article article);

}
