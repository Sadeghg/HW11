package data.category;

import model.Category;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;

public class CategoryRepositoryImp extends BaseRepositoryImp<Category, Integer> implements CategoryRepository {
    public CategoryRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public Category findByTitle(String title) {
        return manager.createNamedQuery("Category.findByTitle", Category.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    public void delete(Category category) {
        manager.getTransaction().begin();
        manager.remove(category);
        manager.getTransaction().commit();
    }
}
