package main.java.com.news.controller;

import main.java.com.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public ResponseEntity<String> getNews() {
        String newsData = newsService.getNews();
        return ResponseEntity.ok(newsData);
    }
}
