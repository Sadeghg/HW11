package data.article;

import model.Article;
import model.helper.ArticleInfo;
import template.data.BaseRepository;

import java.util.List;

public interface ArticleRepository extends BaseRepository<Article, Integer, ArticleInfo> {

    Article findByTitle(String title);

    List<Article> findByUser(int id);

    List<Article> findByState();

    List<Article> findByUserCategory(int id);

    void delete(Article article);
}
