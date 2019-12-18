package org.cmsspringfive.newscms.domain.resources;

import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.models.News;
import org.cmsspringfive.newscms.domain.models.Review;
import org.cmsspringfive.newscms.domain.vo.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news/")
public class NewsResource {


    @GetMapping(value = "/{id}")
    public ResponseEntity<News> findOne(@PathVariable(value = "id") String id){
        return ResponseEntity.ok(new News());
    }

    @GetMapping
    public ResponseEntity<List<News>> findAll(){
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    public ResponseEntity<News> newNews(NewsRequest news){
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeNews(@PathVariable("id") String id){ }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, NewsRequest news){
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/review/{userId}")
    public ResponseEntity<Review> review(@PathVariable("id") String id, @PathVariable("userId") String userId){
        return ResponseEntity.ok(new Review());
    }

    @GetMapping(value = "/revised")
    public ResponseEntity<List<News>> revisedNews(){
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }
}
