package service.article;

import data.article.ArticleRepository;
import model.Article;
import model.helper.ArticleInfo;
import template.service.BaseServiceImp;

import java.util.List;

public class ArticleServiceImp extends BaseServiceImp<Article, Integer, ArticleRepository, ArticleInfo> implements ArticleService {
    public ArticleServiceImp(ArticleRepository repository) {
        super(repository);
    }

    @Override
    public Article findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Article> findByUser(int id) {
        return repository.findByUser(id);
    }

    @Override
    public List<Article> findByUserCategory(int id) {
        return repository.findByUserCategory(id);
    }

    @Override
    public List<Article> findByState() {
        return repository.findByState();
    }

    @Override
    public void delete(Article article) {
        repository.delete(article);
    }
}
