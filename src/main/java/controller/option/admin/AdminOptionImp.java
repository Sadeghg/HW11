package controller.option.admin;


import model.*;
import template.controller.option.user.UserOptionImp;
import util.Utils;

import java.util.Date;
import java.util.List;

public class AdminOptionImp extends UserOptionImp implements AdminOption {


    @Override
    public void showUserArticles() {
        System.out.println("Username");
        String username = Utils.scanner.nextLine();
        User user = userService.findUserByUsername(username);
        if (user != null) {
            List<Article> articles = articleService.findByUser(user.getId());
            if (articles.size() == 0) {
                System.out.println("This user have no Article Yet");
            }
            articles.forEach(x -> System.out.println("ID: " + x.getTitle() + "  ,Title: " + x.getTitle()
                    + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName()));
        } else {
            System.out.println("No such User Exist");
        }
    }

    @Override
    public void showAllArticles() {
        List<Article> articles =articleService.findAll(Article.class, "Article.findAll");
        articles.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Title: " + x.getTitle()
                + "  ,Brief: " + x.getBrief() + "  ,Writer: " + x.getUser().getUserName()));
    }

    @Override
    public void addTag() {
        showTags();
        System.out.println("title : ");
        String title = Utils.scanner.nextLine();
        Tag tag = new Tag();
        tag.setTitle(title);
        tagService.save(tag);
    }

    @Override
    public void addCategory() {
        System.out.println("title : ");
        String title = Utils.scanner.nextLine();
        System.out.println("description : ");
        String desc = Utils.scanner.nextLine();
        Category category = new Category();
        category.setTitle(title);
        category.setDescription(desc);
        categoryService.save(category);
    }

    @Override
    public void editArticle() {
        showAllArticles();
        System.out.println("Article id:");
        int articleId = Integer.parseInt(Utils.scanner.nextLine().trim());
        Article article = articleService.findById(Article.class, articleId);
        if(article != null){
            System.out.println("States: ");
            boolean states = Boolean.parseBoolean(Utils.scanner.nextLine().trim());
            article.setState(states);
            if (states){
                Date date = new Date();
                article.setPublishedDate(date);
            }else {
                article.setPublishedDate(null);
            }
            articleService.update(article);
        }else {
            System.out.println("No such article Exists");
        }
    }

    @Override
    public void editUserRole() {
        Role role = new Role();
        showUsers();
        System.out.println("User Id");
        int uerId = Integer.parseInt(Utils.scanner.nextLine().trim());
        User user = userService.findById(User.class, uerId);
        if (user != null) {
            System.out.println("current role: " + user.getRole().getTitle());
            System.out.println("select a Role  (1- writer / 2- reader)");
            String input = Utils.scanner.nextLine().trim();
            if (input.equals("1")) {
                role.setId(2);
                role.setTitle("writer");
            } else if (input.equals("2")) {
                role.setId(3);
                role.setTitle("reader");
            }
            user.setRole(role);
            userService.update(user);
        }

    }

    @Override
    public void addUser() {
        signUp();
    }

}
