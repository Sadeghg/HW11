package data.article;

import model.Article;
import template.data.BaseRepository;

import java.util.List;

public interface ArticleRepository extends BaseRepository<Article, Integer> {

    Article findByTitle(String title);

    List<Article> findByUser(int id);

    void delete(Article article);
}
