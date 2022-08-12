package ssf.assessment.CryptoCompare.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import ssf.assessment.CryptoCompare.models.News;
import ssf.assessment.CryptoCompare.services.NewsService;

@RestController
@RequestMapping(path = "/news" , produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsRESTController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "{id}")
    public ResponseEntity<String> getNews(@PathVariable String id){

        Optional<News> opt = newsService.saveArticle(id);
        if(opt.isEmpty()){
            JsonObject error = Json.createObjectBuilder()
                                .add("error", "Cannot find news article %s".formatted(id)).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.toString());
        }

        News news = opt.get();
        return ResponseEntity.ok(news.toJson().toString());

    }
    
}
