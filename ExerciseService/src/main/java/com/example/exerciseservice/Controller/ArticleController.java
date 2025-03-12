package com.example.exerciseservice.Controller;

import com.example.exerciseservice.Model.Article;
import com.example.exerciseservice.Service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 1. Get all NewsArticles
    @GetMapping("/get")
    public ResponseEntity getAllArticles() {
        ArrayList<Article> articles = articleService.getAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

    // 2. Add a NewsArticle
    @PostMapping("/add")
    public ResponseEntity addArticle(@RequestBody Article article) {
        boolean isAdded = articleService.addArticle(article);
        if (!isAdded) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Article with this ID already exists.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Article added successfully.");
    }

    // 3. Update a NewsArticle
    @PutMapping("/update/{id}")
    public ResponseEntity updateArticle(@PathVariable int id, @RequestBody Article article) {
        boolean isUpdated = articleService.updateArticle(id, article);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Article updated successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found.");
    }

    // 4. Delete a NewsArticle
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteArticle(@PathVariable int id) {
        boolean isDeleted = articleService.deleteArticle(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Article deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found.");
    }

    // 5. Publish NewsArticles
    @PutMapping("/publish/{id}")
    public ResponseEntity publishArticle(@PathVariable int id) {
        boolean isPublished = articleService.publishArticle(id);
        if (isPublished) {
            return ResponseEntity.status(HttpStatus.OK).body("Article published successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found.");
    }

    // 6. Get all Published NewsArticles
    @GetMapping("/published")
    public ResponseEntity getPublishedArticles() {
        ArrayList<Article> publishedArticles = articleService.getPublishedArticles();
        if (publishedArticles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No published articles found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(publishedArticles);
    }

    // 7. Get NewsArticles by Category
    @GetMapping("/category/{category}")
    public ResponseEntity getArticlesByCategory(@PathVariable String category) {
        ArrayList<Article> articles = articleService.getArticlesByCategory(category);
        if (articles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No articles found in this category.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }
}
