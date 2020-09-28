package controller;

public class ShowMenus {

    public static void firstMenu(){
        System.out.println("\u001B[33m[1] Sign up");
        System.out.println("[2] Log in");
        System.out.println("[3] Exit \u001B[0m");
    }

    public static void editMenu(){
        System.out.println("\u001B[33mTitle");
        System.out.println("Brief");
        System.out.println("Content");
        System.out.println("Exit \u001B[0m");
    }

    public static void editProfileMenu(){
        System.out.println("\u001B[33musername");
        System.out.println("password");
        System.out.println("Exit \u001B[0m");
    }


    public static void userMenu(){
        System.out.println("\u001B[33m[1] add Article");
        System.out.println("[2] remove Article");
        System.out.println("[3] edit Article");
        System.out.println("[4] show Published Articles");
        System.out.println("[5] show my Articles");
        System.out.println("[6] Edit Profile");
        System.out.println("[7] Log out");
        System.out.println("[8] Exit \u001B[0m");
    }

    public static void adminMenu(){
        System.out.println("\u001B[33m[1] edit Article");
        System.out.println("[2] add Admin");
        System.out.println("[3] show Published Articles");
        System.out.println("[3] show All Articles");
        System.out.println("[5] add Tag");
        System.out.println("[6] show Tags");
        System.out.println("[7] add Category");
        System.out.println("[8] show Category");
        System.out.println("[9] Log out");
        System.out.println("[10] Exit \u001B[0m");
    }
}
