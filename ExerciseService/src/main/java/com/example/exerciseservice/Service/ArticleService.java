package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {

    private ArrayList<Article> articles = new ArrayList<>();

    // 1. Get all NewsArticles
    public ArrayList<Article> getAllArticles() {
        return articles;
    }

    // 2. Add a NewsArticle
    public boolean addArticle(Article article) {
        for (Article a : articles) {
            if (a.getId() == article.getId()) {
                return false;
            }
        }
        articles.add(article);
        return true;
    }

    // 3. Update a NewsArticle
    public boolean updateArticle(int id, Article article) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.set(i, article);
                return true;
            }
        }
        return false;
    }

    // 4. Delete a NewsArticle
    public boolean deleteArticle(int id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.remove(i);
                return true;
            }
        }
        return false;
    }

    // 5. Publish NewsArticles
    public boolean publishArticle(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                article.setPublish(true);
                return true;
            }
        }
        return false;
    }

    // 6. Get all Published NewsArticles
    public ArrayList<Article> getPublishedArticles() {
        ArrayList<Article> publishedArticles = new ArrayList<>();
        for (Article article : articles) {
            if (article.isPublish()) {
                publishedArticles.add(article);
            }
        }
        return publishedArticles;
    }

    // 7. Get NewsArticles by Category
    public ArrayList<Article> getArticlesByCategory(String category) {
        ArrayList<Article> result = new ArrayList<>();
        for (Article article : articles) {
            if (article.getCategory().equalsIgnoreCase(category)) {
                result.add(article);
            }
        }
        return result;
    }
}
