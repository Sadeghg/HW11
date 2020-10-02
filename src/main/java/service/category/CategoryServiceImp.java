package service.category;

import data.category.CategoryRepository;
import model.Category;
import model.helper.CategoryInfo;
import template.service.BaseServiceImp;

public class CategoryServiceImp extends BaseServiceImp<Category, Integer, CategoryRepository, CategoryInfo> implements CategoryService {
    public CategoryServiceImp(CategoryRepository repository) {
        super(repository);
    }

    public Category findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public void delete(Category category) {
        repository.delete(category);
    }
}
