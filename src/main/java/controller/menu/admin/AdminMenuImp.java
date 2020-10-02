package controller.menu.admin;

import controller.option.admin.AdminOptionImp;
import model.User;
import template.controller.menu.user.UserMenuImp;
import util.Utils;

public class AdminMenuImp extends UserMenuImp<AdminOptionImp> implements AdminMenu {


    public AdminMenuImp(AdminOptionImp adminOptionImp) {
        super(adminOptionImp);
    }

    @Override
    public void showAdminMenu() {
        System.out.println("\u001B[33m[1] Show Articles");
        System.out.println("[2] Find User");
        System.out.println("[3] Show Users");
        System.out.println("[4] Edit Profile");
        System.out.println("[5] edit Article");
        System.out.println("[6] Add User");
        System.out.println("[7] Edit User");
        System.out.println("[8] show All Articles");
        System.out.println("[9] add Tag");
        System.out.println("[10] show Tags");
        System.out.println("[11] add Category");
        System.out.println("[12] show Category");
        System.out.println("[13] Log out");
        System.out.println("[14] Exit \u001B[0m");
    }

    @Override
    public void adminMenu(User user) {
        showAdminMenu();
        switch (Utils.checkIntInput(1, 13)) {
            case 1:
                option.showPublishedArticles();
                break;
            case 2:
                option.findByUser();
                break;
            case 3:
                option.showUserInfo();
                break;
            case 4:
                editProfile(user);
                break;
            case 5:
                option.editArticle();
                break;
            case 6:
                option.addUser();
                break;
            case 7:
                option.editUserRole();
                break;
            case 8:
                searchArticle();
                break;
            case 9:
                option.addTag();
                break;
            case 10:
                option.showTags();
                break;
            case 11:
                option.addCategory();
                break;
            case 12:
                option.showCategory();
                break;
            case 13:
                option.logout(user);
                break;
            case 14:
                option.closeApp();
                break;
        }
    }

//    private static void showAdminMenu(){
//        System.out.println("\u001B[33m[1] Show Articles");
//        System.out.println("[2] Find User");
//        System.out.println("[3] Show Users");
//        System.out.println("[4] Edit Profile");
//        System.out.println("[5] edit Article");
//        System.out.println("[6] Add User");
//        System.out.println("[7] Edit User");
//        System.out.println("[8] show All Articles");
//        System.out.println("[9] add Tag");
//        System.out.println("[10] show Tags");
//        System.out.println("[11] add Category");
//        System.out.println("[12] show Category");
//        System.out.println("[13] Log out");
//        System.out.println("[14] Exit \u001B[0m");
//    }
//
//    public static void adminMenu(User user){
//        showAdminMenu();
//        switch (Utils.checkIntInput(1, 13)){
//            case 1: AdminOption.showPublishedArticles();
//                break;
//            case 2: AdminOption.findByUser();
//                break;
//            case 3: AdminOption.showUserInfo();
//                break;
//            case 4: editProfile(user);
//                break;
//            case 5: AdminOption.editArticle();
//                break;
//            case 6: AdminOption.addUser();
//                break;
//            case 7: AdminOption.editUserRole();
//                break;
//            case 8: searchArticle();
//                break;
//            case 9: AdminOption.addTag();
//                break;
//            case 10: AdminOption.showTags();
//                break;
//            case 11: AdminOption.addCategory();
//                break;
//            case 12: AdminOption.showCategory();
//                break;
//            case 13: AdminOption.logout(user);
//                break;
//            case 14: AdminOption.closeApp();
//                break;
//        }
//    }
//
//    private static void editProfileMenu(){
//        System.out.println("\u001B[33mChange Address");
//        System.out.println("Change Username");
//        System.out.println("Change Password\u001B[0m");
//    }
//
//    private static void editProfile(User user){
//        editProfileMenu();
//        switch (Utils.checkIntInput(1, 10)){
//            case 1: AdminOption.changeAddress(user);
//                break;
//            case 2: AdminOption.changeUsername(user);
//                break;
//            case 3: AdminOption.changePassword(user);
//                break;
//        }
//    }
//
//    private static void searchArticleMenu(){
//        System.out.println("\u001B[33mSearch By:");
//        System.out.println("Category");
//        System.out.println("Tag");
//        System.out.println("Date\u001B[0m");
//    }
//
//    private static void searchArticle(){
//        searchArticleMenu();
//        switch (Utils.checkIntInput(1, 4)){
//            case 1: AdminOption.filterDateArticle();
//                break;
//            case 2: AdminOption.filterCategoryArticle();
//                break;
//            case 3: AdminOption.filterTagArticle();
//                break;
//        }
//    }

}
