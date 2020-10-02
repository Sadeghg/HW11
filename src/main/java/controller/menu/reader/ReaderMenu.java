package controller.menu.reader;

import model.User;
import template.controller.menu.user.UserMenu;

public interface ReaderMenu extends UserMenu {

    void showUserMenu();

    void readerMenu(User user);
}
