package controller.option;

import controller.MenuHandler;
import data.article.ArticleRepositoryImp;
import data.category.CategoryRepositoryImp;
import data.tag.TagRepositoryImp;
import model.*;
import model.helper.UserInfo;
import service.article.ArticleServiceImp;
import service.category.CategoryServiceImp;
import service.tag.TagServiceImp;
import util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public abstract class US extends BS {

    // Second Database services
    protected static ArticleServiceImp articleService = new ArticleServiceImp(new ArticleRepositoryImp(Utils.managerB));
    protected static TagServiceImp tagService = new TagServiceImp(new TagRepositoryImp(Utils.managerB));
    protected static CategoryServiceImp categoryService = new CategoryServiceImp(new CategoryRepositoryImp(Utils.managerB));

    public static void showPublishedArticles() {
        List<Article> articles = articleService.findByState();
        articles.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Title: " + x.getTitle()
                + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName()));
    }


    public static void findByUser() {
        System.out.println("username: ");
        String username = Utils.scanner.nextLine().trim();
        User user = findUserByUsername(username);
        if (user != null){
            List<Article> articles = articleService.findByUser(user.getId());
            articles.forEach(x -> System.out.println("ID: " + x.getTitle() + "  ,Title: " + x.getTitle()
                    + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName()));
        }
    }


    public static void showUsers() {
        List<User> users = userService.findAll(User.class, "User.findAll");
        users.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Username: " + x.getUserName()));
    }

    public static void showUserInfo(){
        Function<User, UserInfo> function = (user) -> {
            UserInfo info = new UserInfo();
            info.setCity(user.getAddress().getCity());
            info.setTitle(user.getUserName() + "Title");
            info.setRole(user.getRole().getTitle());
            info.setUsername(user.getUserName());

            return info;
        };
        List<UserInfo> infos = userService.findAll(User.class, "User.findAll",function);
        infos.forEach(x -> System.out.println("Title: " + x.getTitle() + "  ,Role: " + x.getRole() + "  ,City: " + x.getCity()));
    }


    public static User findUserByUsername(String name) {
        User user = userService.findUserByUsername(name);
        if (user != null){
            System.out.println("ID: " + user.getId() + "  ,Username" + user.getUserName());
        }
        return user;
    }

    public static void filterDateArticle(){
        System.out.println("Enter Date");
        String input = Utils.scanner.nextLine().trim();
        Predicate<Article> predicate = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
            predicate = (article) -> article.getPublishedDate().after(date);
        }catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        showArticles(articleService.findAll(Article.class, "Article.published", predicate));
    }

    public static void filterTagArticle(){
        System.out.println("Enter Tag");
        String input = Utils.scanner.nextLine().trim();
        Predicate<Article> predicate = null;
        Tag tag = tagService.findByTitle(input);
        if (tag != null){
            predicate = (article) -> article.getTags().contains(tag);
            showArticles(articleService.findAll(Article.class, "Article.published", predicate));
        }else {
            System.out.println(" No Such Tag found");
        }
    }

    public static void filterCategoryArticle(){
        System.out.println("Enter Category");
        String input = Utils.scanner.nextLine().trim();
        Predicate<Article> predicate = null;
        predicate = (article) -> article.getCategory().getTitle().equalsIgnoreCase(input);
        showArticles(articleService.findAll(Article.class, "Article.published", predicate));
    }


    private static void showArticles(List<Article> articles){
        articles.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Title: " + x.getTitle()
                + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName() + "  ,Date: " + x.getPublishedDate()));
    }


    public static void changePassword(User user) {
        System.out.println("New password;");
        String password = Utils.scanner.nextLine().trim();
        user.setPassword(password);
        userService.update(user);
    }


    public static void changeUsername(User user) {
        System.out.println("New username;");
        String username = Utils.scanner.nextLine().trim();
        user.setPassword(username);
        userService.update(user);
    }

    public static void changeAddress(User user) {
        if (user.getAddress() != null) {
            user.setAddress(addAddress(user.getAddress()));
            userService.update(user);
        } else {
            System.out.println("There's no Address to change");
        }
    }

    public static void addAddress(User user) {
        if (user.getAddress() == null) {
            user.setAddress(addAddress(new Address()));
            userService.update(user);
        } else {
            System.out.println("You Already Have an address");
        }
    }

    public static void showTags() {
        List<Tag> tags = tagService.findAll(Tag.class, "Tag.findAll");
        tags.forEach(x -> System.out.println(" ID : " + x.getId() + "  ,Title: " + x.getTitle()));
    }

    public static void showCategory() {
        List<Category> categories = categoryService.findAll(Category.class, "Category.findAll");
        categories.forEach(x -> System.out.println(" ID : " + x.getId() + "  ,Title: " + x.getTitle()));
    }

    public static boolean logout(User user) {
        MenuHandler.isLogged = false;
        user = null;
        return false;
    }
}
