package controller.option.admin;

import template.controller.option.user.UserOption;


public interface AdminOption extends UserOption {

    void showUserArticles();

    void showAllArticles();

    void addTag();

    void addCategory();

    void editArticle();

    void editUserRole();

    void addUser();
}
