package template.controller.option.user;
import model.*;
import template.controller.option.basic.BasicOption;

import java.util.List;


public interface UserOption extends BasicOption {

    void showPublishedArticles();

    void findByUser() ;

    void showUsers();

    void showUserInfo();

    User findUserByUsername(String name);

    void filterDateArticle();

    void filterTagArticle();

    void filterCategoryArticle();

    void showArticles(List<Article> articles);

    void changePassword(User user);

    void changeUsername(User user);

    void changeAddress(User user);

    void addAddress(User user);

    void showTags();

    void showCategory();

    boolean logout(User user);
}
