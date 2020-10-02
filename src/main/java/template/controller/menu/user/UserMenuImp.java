package template.controller.menu.user;

import model.User;
import template.controller.menu.basic.BasicMenuImp;
import template.controller.option.user.UserOptionImp;
import util.Utils;

public class UserMenuImp<Option extends UserOptionImp> extends BasicMenuImp<UserOptionImp> implements UserMenu {

    protected Option option;

    public UserMenuImp(Option option) {
        this.option = option;
    }

    @Override
    public void searchArticleMenu() {
        System.out.println("\u001B[33mSearch By:");
        System.out.println("Date");
        System.out.println("Category");
        System.out.println("Tag\u001B[0m");
    }

    @Override
    public void searchArticle() {
        this.searchArticleMenu();
        switch (Utils.checkIntInput(1, 10)){
            case 1: option.filterDateArticle();
                break;
            case 2: option.filterCategoryArticle();
                break;
            case 3: option.filterTagArticle();
                break;
        }
    }

    @Override
    public void editProfileMenu() {
        System.out.println("\u001B[33mChange Address");
        System.out.println("Change Username");
        System.out.println("Change Password\u001B[0m");
    }

    @Override
    public void editProfile(User user) {
        this.editProfileMenu();
        switch (Utils.checkIntInput(1, 10)){
            case 1: option.changeAddress(user);
                break;
            case 2: option.changeUsername(user);
                break;
            case 3: option.changePassword(user);
                break;
        }
    }
}
