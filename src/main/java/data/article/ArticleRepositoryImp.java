package data.article;

import model.Article;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;
import java.util.List;

public class ArticleRepositoryImp extends BaseRepositoryImp<Article, Integer> implements ArticleRepository{
    public ArticleRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public Article findByTitle(String title) {
        return manager.createNamedQuery("Article.findByTitle", Article.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    public List<Article> findByUser(int id) {
        return manager.createNamedQuery("Article.findByUser", Article.class)
                .setParameter("id", id)
                .getResultList();
    }

    public void delete(Article article) {
        manager.getTransaction().begin();
        manager.remove(article);
        manager.getTransaction().commit();
    }
}
