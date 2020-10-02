package controller;

import controller.menu.admin.AdminMenuImp;
import controller.menu.guest.GuestMenuImp;
import controller.menu.reader.ReaderMenuImp;
import controller.menu.writer.WriterMenuImp;
import controller.option.admin.AdminOptionImp;
import controller.option.reader.ReaderOptionImp;
import controller.option.writer.WriterOptionImp;
import model.User;

public class MenuHandler {
    public static User user;
    public static Boolean isLogged = false;
    private ReaderMenuImp readerMenu = new ReaderMenuImp(new ReaderOptionImp());
    private WriterMenuImp writerMenu = new WriterMenuImp(new WriterOptionImp());
    private AdminMenuImp adminMenu = new AdminMenuImp(new AdminOptionImp());
    private GuestMenuImp guestMenu = new GuestMenuImp();

    public void start(){
        while (true){
            while (isLogged){
                if (user != null && user.getRole().getTitle().equalsIgnoreCase("reader")){
                    readerMenu.readerMenu(user);
                }else if (user != null && user.getRole().getTitle().equalsIgnoreCase("writer")){
                    writerMenu.writerMenu(user);
                }else if (user != null && user.getRole().getTitle().equalsIgnoreCase("admin")){
                    adminMenu.adminMenu(user);
                }
            }
            guestMenu.firstMenu();
        }
    }
}
