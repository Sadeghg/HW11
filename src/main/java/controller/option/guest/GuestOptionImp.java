package controller.option.guest;

import controller.MenuHandler;
import controller.option.BS;
import model.User;
import template.controller.option.basic.BasicOptionImp;
import util.Utils;


public class GuestOptionImp extends BasicOptionImp implements GuestOption {

    @Override
    public User login(){
        System.out.println("username: ");
        String username = Utils.scanner.nextLine().trim();
        System.out.println("password: ");
        String password = Utils.scanner.nextLine().trim();
        User user = userService.login(username, password);
        if (user != null){
            MenuHandler.isLogged = true;
            MenuHandler.user = user;
        }
        return user;
    }
}
