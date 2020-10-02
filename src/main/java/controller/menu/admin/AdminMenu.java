package controller.menu.admin;

import model.User;
import template.controller.menu.user.UserMenu;

public interface AdminMenu extends UserMenu {

    void showAdminMenu();

    void adminMenu(User user);

}
