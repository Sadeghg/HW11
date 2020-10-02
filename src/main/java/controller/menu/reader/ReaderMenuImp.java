package controller.menu.reader;

import controller.option.reader.ReaderOptionImp;
import model.User;
import template.controller.menu.user.UserMenuImp;
import util.Utils;

public class ReaderMenuImp extends UserMenuImp<ReaderOptionImp> implements ReaderMenu {

    public ReaderMenuImp(ReaderOptionImp readerOptionImp) {
        super(readerOptionImp);
    }


    @Override
    public void showUserMenu(){
        System.out.println("\u001B[33m[1] Show Articles");
        System.out.println("[2] Find User");
        System.out.println("[3] Search in Articles");
        System.out.println("[4] Show Users");
        System.out.println("[5] Edit Profile");
        System.out.println("[6] Log out");
        System.out.println("[7] Exit \u001B[0m");
    }

    @Override
    public void readerMenu(User user){
        showUserMenu();
        switch (Utils.checkIntInput(1, 8)){
            case 1: option.showPublishedArticles();
                break;
            case 2: option.findByUser();
                break;
            case 3: searchArticle();
                break;
            case 4: option.showUserInfo();
                break;
            case 5: editProfile(user);
                break;
            case 6: option.logout(user);
                break;
            case 7: option.closeApp();
                break;
        }
    }


}
