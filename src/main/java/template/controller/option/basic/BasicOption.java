package template.controller.option.basic;

import model.Address;
import model.Role;

public interface BasicOption {

    Address addAddress(Address address);

    void signUp();

    Role chooseRole();

    void closeApp();
}
