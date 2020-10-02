package data.article;

import model.Article;
import model.helper.ArticleInfo;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;
import java.util.List;

public class ArticleRepositoryImp extends BaseRepositoryImp<Article, Integer, ArticleInfo> implements ArticleRepository{
    public ArticleRepositoryImp(EntityManager manager) {
        super(manager);
    }

    @Override
    public Article findByTitle(String title) {
        return manager.createNamedQuery("Article.findByTitle", Article.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    @Override
    public List<Article> findByUser(int id) {
        return manager.createNamedQuery("Article.findByUser", Article.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public List<Article> findByState() {
        return manager.createNamedQuery("Article.published", Article.class)
                .setParameter("true", true)
                .getResultList();
    }

    @Override
    public List<Article> findByUserCategory(int id) {
        return manager.createNamedQuery("Article.findByCategory", Article.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public void delete(Article article) {
        manager.getTransaction().begin();
        manager.remove(article);
        manager.getTransaction().commit();
    }
}
