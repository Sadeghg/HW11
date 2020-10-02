package controller.menu.writer;

import model.User;
import template.controller.menu.user.UserMenu;


public interface WriterMenu extends UserMenu {

    void editMenu();

    void showWriterMenu();

    void writerMenu(User user);

    void editArticle(User user);
}
