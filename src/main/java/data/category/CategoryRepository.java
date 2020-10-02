package data.category;

import model.Category;
import model.helper.CategoryInfo;
import template.data.BaseRepository;

public interface CategoryRepository extends BaseRepository<Category, Integer, CategoryInfo> {

    Category findByTitle(String title);

    void delete(Category category);
}
