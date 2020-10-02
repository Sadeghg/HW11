package service.category;

import model.Category;
import model.helper.CategoryInfo;
import template.service.BaseService;

public interface CategoryService extends BaseService<Category, Integer, CategoryInfo> {

    Category findByTitle(String title);

    void delete(Category category);
}
