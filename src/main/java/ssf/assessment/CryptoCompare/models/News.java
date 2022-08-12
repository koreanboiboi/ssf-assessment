package ssf.assessment.CryptoCompare.models;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class News {

    private String id;
    private Integer published_on;
    private String title;
    private String url;
    private String imageurl;
    private String body;
    private String tags;
    private String categories;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getTags() {
        return tags;
    }
    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getCategories() {
        return categories;
    }
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getPublished_on() {
        return published_on;
    }
    public void setPublished_on(Integer published_on) {
        this.published_on = published_on;
    }

    
    public static News create(String jsonStr){
        StringReader strReader = new StringReader(jsonStr);
        JsonReader reader = Json.createReader(strReader);
        return create(reader.readObject());
    }

    public static News create(JsonObject jo) {
        News news = new News();
        news.setId(jo.getString("id"));
        news.setPublished_on(jo.getInt("published_on"));
        news.setTitle(jo.getString("title"));
        news.setUrl(jo.getString("url"));
        news.setImageurl(jo.getString("imageurl"));
        news.setBody(jo.getString("body"));
        news.setTags(jo.getString("tags"));
        news.setCategories(jo.getString("categories"));
        
        return news;
    
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                    .add("id", id)
                    .add("title", title)
                    .add("url", url)
                    .add("imageurl", imageurl)
                    .add("body", body)
                    .add("tags", tags)
                    .add("categories", categories)
                    .build();

                    //.add("published_on", published_on)
    }
    
    private List<News> savedArticle = new LinkedList<>();

    public List<News> save(News news){

        List<News> savedNews = savedArticle.stream()
                               .toList();

        return savedNews;

    }

    
}
