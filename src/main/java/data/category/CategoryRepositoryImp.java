package data.category;

import model.Category;
import model.helper.CategoryInfo;
import template.data.BaseRepositoryImp;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CategoryRepositoryImp extends BaseRepositoryImp<Category, Integer, CategoryInfo> implements CategoryRepository {
    public CategoryRepositoryImp(EntityManager manager) {
        super(manager);
    }

    public Category findByTitle(String title) {
        Category category = null;
        try {
            category = manager.createNamedQuery("Category.findByTitle", Category.class)
                    .setParameter("title", title)
                    .getSingleResult();
        }catch (NoResultException e){
            System.out.println("\u001B[31mNo suc Category \u001B[0m");
        }

        return category;
    }

    public void delete(Category category) {
        manager.getTransaction().begin();
        manager.remove(category);
        manager.getTransaction().commit();
    }
}
