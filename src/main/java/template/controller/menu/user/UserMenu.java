package template.controller.menu.user;

import model.User;
import template.controller.menu.basic.BasicMenu;

public interface UserMenu extends BasicMenu {

    void searchArticleMenu();

    void searchArticle();

    void editProfileMenu();

    void editProfile(User user);
}
