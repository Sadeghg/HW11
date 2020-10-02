package template.controller.option.basic;

import data.address.AddressRepositoryImp;
import data.role.RoleRepositoryImp;
import data.user.UserRepositoryImp;
import model.Address;
import model.Role;
import model.User;
import service.address.AddressServiceImp;
import service.role.RoleServiceImp;
import service.user.UserServiceImp;
import util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicOptionImp implements BasicOption{

    protected static UserServiceImp userService = new UserServiceImp(new UserRepositoryImp(Utils.managerA));
    protected static AddressServiceImp addressService = new AddressServiceImp(new AddressRepositoryImp(Utils.managerA));
    protected static RoleServiceImp roleService = new RoleServiceImp(new RoleRepositoryImp(Utils.managerA));

    @Override
    public Address addAddress(Address address) {
        System.out.println("city");
        String city = Utils.scanner.nextLine();

        System.out.println("street");
        String street = Utils.scanner.nextLine();

        System.out.println("zipCode");
        String zipCode = Utils.scanner.nextLine();

        address.setCity(city);
        address.setStreet(street);
        address.setZipCode(zipCode);
        return address;
    }

    @Override
    public void signUp() {
        System.out.println("username: ");
        String username = Utils.scanner.nextLine().trim();
        System.out.println("nationalCode: ");
        String nationalCode = Utils.scanner.nextLine().trim();
        System.out.println("birthday:");
        String birthday = Utils.scanner.nextLine().trim();
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
            Role role = chooseRole();
            Address address = new Address();
            User user = new User();
            user.setUserName(username);
            user.setPassword(nationalCode);
            user.setNationalCode(nationalCode);
            user.setBirthDay(date);
            user.setRole(role);
            user.setAddress(addAddress(address));
            userService.save(user);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role chooseRole() {
        Role role = new Role();
        System.out.println("choose role (1-writer / 2-reader)");
        int choice = Utils.checkIntInput(1, 2);
        if(choice == 1){
            role.setId(2);
            role.setTitle("writer");
        }else {
            role.setId(3);
            role.setTitle("reader");
        }
        return role;
    }

    @Override
    public void closeApp() {
        Utils.managerA.close();
        Utils.managerB.close();
        Utils.scanner.close();
        System.exit(0);
    }
}
