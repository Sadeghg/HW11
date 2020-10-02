package controller.menu.guest;

import controller.option.guest.GuestOptionImp;
import model.User;
import template.controller.menu.basic.BasicMenuImp;
import util.Utils;

public class GuestMenuImp extends BasicMenuImp<GuestOptionImp> implements GuestMenu {

    public GuestMenuImp() {
        super.option = new GuestOptionImp();
    }

    public void showFirstMenu(){
        System.out.println("\u001B[33m[1] Sign up");
        System.out.println("[2] Log in");
        System.out.println("[3] Exit \u001B[0m");
    }

    public void firstMenu(){
        showFirstMenu();
        switch (Utils.checkIntInput(1, 3)){
            case 1: option.signUp();
                break;
            case 2: option.login();
                break;
            case 3: option.closeApp();
                break;
        }
    }
}
