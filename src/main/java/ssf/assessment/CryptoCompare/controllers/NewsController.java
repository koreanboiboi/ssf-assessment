package ssf.assessment.CryptoCompare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ssf.assessment.CryptoCompare.models.News;
import ssf.assessment.CryptoCompare.services.NewsService;

@Controller
@RequestMapping(path = {"/","/news","/articles"} , produces = "text/html")
public class NewsController {

    @Autowired
    private NewsService newsSvc;

    @GetMapping(path = {"/","/news",""})
    public String getArticle(Model model){


        List<News> news = newsSvc.getArticle();

        model.addAttribute("news",news); 

        return "news";

    }

    @PostMapping(path = "/articles")
    public String saveArticles(@RequestBody MultiValueMap<String,String> form,
                               Model model){


        String id = form.getFirst("id");
        String title = form.getFirst("title");
        String url = form.getFirst("url");
        String imageurl = form.getFirst("imageurl");
        String tags = form.getFirst("tags");
        String categories = form.getFirst("categories");
        String body = form.getFirst("body");
    

        model.addAttribute("id",id);
        model.addAttribute("title",title);
        model.addAttribute("url",url);
        model.addAttribute("imageurl",imageurl);
        model.addAttribute("tags",tags);
        model.addAttribute("categories",categories);
        model.addAttribute("id",id);
        model.addAttribute("body",body);


        // model.addAttribute("id",news.getId());
        // model.addAttribute("title",news.getTitle());
        // model.addAttribute("body",news.getBody());
        // model.addAttribute("url",news.getUrl());
        // model.addAttribute("imageurl",news.getImageurl());
        // model.addAttribute("tags",news.getTags());
        // model.addAttribute("categories",news.getCategories());
        // model.addAttribute("published_on",news.getPublished_on());

        return "articles";

    }
    
}
