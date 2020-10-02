package controller.option.writer;

import model.Article;
import model.Category;
import model.Tag;
import model.User;
import template.controller.option.user.UserOptionImp;
import util.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WriterOptionImp extends UserOptionImp implements WriterOption {

    @Override
    public void addArticle(User user){
        System.out.println("Article Title : ");
        String title = Utils.scanner.nextLine();
        System.out.println("Article brief : ");
        String brief = Utils.scanner.nextLine();
        System.out.println("Article Content : ");
        String content = Utils.scanner.nextLine();
        System.out.println("Article Date : ");
        String articleDate = Utils.scanner.nextLine().trim();

        Set<Tag> tags = new HashSet<>();
        Category category = addCategory();
        if (category != null){
            tags = addTags();
        }
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(articleDate);
            Article article = new Article();
            article.setTitle(title);
            article.setBrief(brief);
            article.setContent(content);
            article.setCreateDate(date);
            article.setState(false);
            article.setTags(tags);
            article.setUser(user);
            article.setCategory(category);
            articleService.save(article);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editContent(User user) {
        boolean found = false;
        List<Article> articles = showMyArticles(user);
        System.out.println("Article Id: ");
        int articleId = Integer.parseInt(Utils.scanner.nextLine().trim());
        System.out.println("Content: ");
        String content = Utils.scanner.nextLine();

        for (Article article: articles){
            if (article.getId().equals(articleId)){
                if (article.getUser().getId().equals(user.getId())){
                    article.setContent(content);
                    updateArticle(article);
                    found = true;
                    break;
                }else {
                    System.out.println("\u001B[31mYou're Not Authorized for this Article \u001B[0m");
                }
            }
        }
        if (!found){
            System.out.println("\u001B[31mThere's No Article With this Id \u001B[0m");
        }
    }

    @Override
    public void editBrief(User user) {
        boolean found = false;
        List<Article> articles = showMyArticles(user);
        System.out.println("Article Id: ");
        int articleId = Integer.parseInt(Utils.scanner.nextLine().trim());
        System.out.println("Brief: ");
        String brief = Utils.scanner.nextLine();

        for (Article article: articles){
            if (article.getId().equals(articleId)){
                if (article.getUser().getId().equals(user.getId())){
                    article.setBrief(brief);
                    updateArticle(article);
                    found = true;
                    break;
                }else {
                    System.out.println("\u001B[31mYou're Not Authorized for this Article \u001B[0m");
                }
            }
        }
        if (!found){
            System.out.println("\u001B[31mThere's No Article With this Id \u001B[0m");
        }
    }

    @Override
    public void editTitle(User user) {
        boolean found = false;
        List<Article> articles = showMyArticles(user);
        System.out.println("Article Id: ");
        int articleId = Integer.parseInt(Utils.scanner.nextLine().trim());
        System.out.println("Title: ");
        String title = Utils.scanner.nextLine();

        for (Article article: articles){
            if (article.getId().equals(articleId)){
                if (article.getUser().getId().equals(user.getId())){
                    article.setTitle(title);
                    updateArticle(article);
                    found = true;
                    break;
                }else {
                    System.out.println("\u001B[31mYou're Not Authorized for this Article \u001B[0m");
                }
            }
        }

        if (!found){
            System.out.println("\u001B[31mThere's No Article With this Id \u001B[0m");
        }
    }

    @Override
    public void deleteArticle(User user){
        boolean found = false;
        List<Article> articles = showMyArticles(user);
        System.out.println("Article Id: ");
        int articleId = Integer.parseInt(Utils.scanner.nextLine().trim());
        for (Article article: articles){
            if (article.getId().equals(articleId)){
                if (article.getUser().getId().equals(user.getId())){
                    articleService.delete(article);
                    found = true;
                    break;
                }else {
                    System.out.println("\u001B[31mYou're Not Authorized for this Article \u001B[0m");
                }
            }
        }
        if (!found){
            System.out.println("\u001B[31mThere's No Article With this Id \u001B[0m");
        }
    }

    @Override
    public List<Article> showMyArticles(User user){
        List<Article> articles = articleService.findByUser(user.getId());
        articles.forEach(x -> System.out.println("ID: " + x.getId() + "  ,Title: " + x.getTitle()
                + "  ,Brief: " + x.getBrief() ));
        return articles;
    }

    private static void updateArticle(Article article){
        Date date = new Date();
        article.setLastUpdateDate(date);
        articleService.update(article);
    }



    private Category findCategory(String title) {
        return categoryService.findByTitle(title);
    }

    private Tag findTag(String title) {
        return tagService.findByTitle(title);
    }


    private Category addCategory(){
        Category category = null;
        showCategory();
        System.out.println("Category: ");
        boolean categoryFound = false;
        do {
            String ctgTitle = Utils.scanner.nextLine().trim();
            category = findCategory(ctgTitle);
            if (ctgTitle.equalsIgnoreCase("X")){
                break;
            }
            if (category != null){
                categoryFound = true;
            }
        }while (!categoryFound);
        return category;
    }

    private  Set<Tag>  addTags(){
        Set<Tag> tags = new HashSet<>();
        String tagTitle;
        showTags();
        System.out.println("Tags: ");
        while (!(tagTitle = Utils.scanner.nextLine().trim()).equals("X")){
            Tag tag = findTag(tagTitle);
            if (tag != null){
                tags.add(tag);
            }else {
                System.out.println("\u001B[31mdose not exist \u001B[0m");
            }
        }
        return tags;
    }
}
