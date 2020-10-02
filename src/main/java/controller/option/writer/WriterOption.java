package controller.option.writer;

import model.Article;

import model.User;
import template.controller.option.user.UserOption;

import java.util.List;


public interface WriterOption extends UserOption {

    void addArticle(User user);

    void editContent(User user);

    void editBrief(User user);

    void editTitle(User user);

    void deleteArticle(User user);

    List<Article> showMyArticles(User user);
}
