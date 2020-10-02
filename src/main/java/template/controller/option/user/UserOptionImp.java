package template.controller.option.user;

import controller.MenuHandler;
import data.article.ArticleRepositoryImp;
import data.category.CategoryRepositoryImp;
import data.tag.TagRepositoryImp;
import model.*;
import model.helper.UserInfo;
import service.article.ArticleServiceImp;
import service.category.CategoryServiceImp;
import service.tag.TagServiceImp;
import template.controller.option.basic.BasicOptionImp;
import util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


public class UserOptionImp extends BasicOptionImp implements UserOption {

    // Second Database services
    protected static ArticleServiceImp articleService = new ArticleServiceImp(new ArticleRepositoryImp(Utils.managerB));
    protected static TagServiceImp tagService = new TagServiceImp(new TagRepositoryImp(Utils.managerB));
    protected static CategoryServiceImp categoryService = new CategoryServiceImp(new CategoryRepositoryImp(Utils.managerB));

    @Override
    public void showPublishedArticles() {
        List<Article> articles = articleService.findByState();
        articles.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Title: " + x.getTitle()
                + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName()));
    }

    @Override
    public void findByUser() {
        System.out.println("username: ");
        String username = Utils.scanner.nextLine().trim();
        User user = findUserByUsername(username);
        if (user != null){
            List<Article> articles = articleService.findByUser(user.getId());
            articles.forEach(x -> System.out.println("ID: " + x.getTitle() + "  ,Title: " + x.getTitle()
                    + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName()));
        }
    }

    @Override
    public void showUsers() {
        List<User> users = userService.findAll(User.class, "User.findAll");
        users.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Username: " + x.getUserName()));
    }

    @Override
    public void showUserInfo() {
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

    @Override
    public User findUserByUsername(String name) {
        User user = userService.findUserByUsername(name);
        if (user != null){
            System.out.println("ID: " + user.getId() + "  ,Username: " + user.getUserName());
        }
        return user;
    }

    @Override
    public void filterDateArticle() {
        System.out.println("Enter Date");
        String input = Utils.scanner.nextLine().trim();
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input);
            showArticles(articleService.findAll(Article.class, "Article.findAll", (Article a) -> a.getPublishedDate().after(date)));
        }catch (ParseException  | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void filterTagArticle() {
        showTags();
        System.out.println("Enter Tag");
        String input = Utils.scanner.nextLine().trim();
        Tag tag = tagService.findByTitle(input);
        if (tag != null){
            showArticles(articleService.findAll(Article.class, "Article.findAll", (Article a) -> a.getTags().contains(tag)));
        }else {
            System.out.println(" No Such Tag found");
        }
    }

    @Override
    public void filterCategoryArticle() {
        showCategory();
        System.out.println("Enter Category");
        String input = Utils.scanner.nextLine().trim();
        showArticles(articleService.findAll(Article.class, "Article.findAll", (Article a) -> a.getCategory().getTitle().equalsIgnoreCase(input)));
    }

    @Override
    public void showArticles(List<Article> articles) {
        if(articles != null){
            articles.stream().filter(Article::getState).forEach(x -> System.out.println("ID: " + x.getId() + "  ,Title: " + x.getTitle()
                    + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName() + "  ,Date: " + x.getPublishedDate()));
        }else {
            System.out.println("No Article With this Attribute");
        }

    }

    @Override
    public void changePassword(User user) {
        System.out.println("New password;");
        String password = Utils.scanner.nextLine().trim();
        user.setPassword(password);
        userService.update(user);
    }

    @Override
    public void changeUsername(User user) {
        System.out.println("New username;");
        String username = Utils.scanner.nextLine().trim();
        user.setPassword(username);
        userService.update(user);
    }

    @Override
    public void changeAddress(User user) {
        if (user.getAddress() != null) {
            user.setAddress(addAddress(user.getAddress()));
            userService.update(user);
        } else {
            System.out.println("There's no Address to change");
        }
    }

    @Override
    public void addAddress(User user) {
        if (user.getAddress() == null) {
            user.setAddress(addAddress(new Address()));
            userService.update(user);
        } else {
            System.out.println("You Already Have an address");
        }
    }

    @Override
    public void showTags() {
        List<Tag> tags = tagService.findAll(Tag.class, "Tag.findAll");
        tags.forEach(x -> System.out.println(" ID : " + x.getId() + "  ,Title: " + x.getTitle()));
    }

    @Override
    public void showCategory() {
        List<Category> categories = categoryService.findAll(Category.class, "Category.findAll");
        categories.forEach(x -> System.out.println(" ID : " + x.getId() + "  ,Title: " + x.getTitle()));
    }

    @Override
    public boolean logout(User user) {
        MenuHandler.isLogged = false;
        user = null;
        return false;
    }
}
