package main.java.com.news.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    @Value("${mediastack.api.key}")
    private String apiKey;

    @Value("${mediastack.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getNews() {
        // Customize parameters as needed (e.g., countries, categories, languages)
        String url = apiUrl + "?access_key=" + apiKey + "&countries=in&q=India&languages=en";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}