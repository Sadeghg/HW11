package controller.option.guest;

import model.User;
import template.controller.option.basic.BasicOption;

public interface GuestOption extends BasicOption {

    User login();
}
