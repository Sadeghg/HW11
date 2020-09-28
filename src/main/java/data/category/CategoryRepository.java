package data.category;

import model.Category;
import template.data.BaseRepository;

public interface CategoryRepository extends BaseRepository<Category, Integer> {

    Category findByTitle(String title);

    void delete(Category category);
}
