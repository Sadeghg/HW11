package controller.menu.writer;

import controller.option.writer.WriterOptionImp;
import model.User;
import template.controller.menu.user.UserMenuImp;
import util.Utils;

public class WriterMenuImp extends UserMenuImp<WriterOptionImp> implements WriterMenu{

    public WriterMenuImp(WriterOptionImp writerOptionImp) {
        super(writerOptionImp);
    }

    @Override
    public void editMenu(){
        System.out.println("\u001B[33mTitle");
        System.out.println("Brief");
        System.out.println("Content");
        System.out.println("Delete Article");
        System.out.println("Exit \u001B[0m");
    }

    @Override
    public void showWriterMenu(){
        System.out.println("\u001B[33m[1] Show Articles");
        System.out.println("[2] Find User");
        System.out.println("[3] Show My Articles");
        System.out.println("[4] Add Article");
        System.out.println("[5] Edit Article");
        System.out.println("[6] Show Users");
        System.out.println("[7] Edit Profile");
        System.out.println("[8] Log out");
        System.out.println("[9] Exit \u001B[0m");
    }


    @Override
    public void writerMenu(User user){
        showWriterMenu();
        switch (Utils.checkIntInput(1, 9)){
            case 1: option.showPublishedArticles();
                break;
            case 2: option.findByUser();
                break;
            case 3: option.showMyArticles(user);
                break;
            case 4: option.addArticle(user);
                break;
            case 5: editArticle(user);
                break;
            case 6: option.showUserInfo();
                break;
            case 7: editProfile(user);
                break;
            case 8: option.logout(user);
                break;
            case 9: option.closeApp();
                break;
        }
    }

    @Override
    public void editArticle(User user){
        editMenu();
        switch (Utils.checkIntInput(1, 10)){
            case 1: option.editTitle(user);
                break;
            case 2: option.editBrief(user);
                break;
            case 3: option.editContent(user);
                break;
            case 4: option.deleteArticle(user);
                break;
            default: // Nothing
                break;
        }
    }

}
