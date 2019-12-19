package org.cmsspringfive.newscms.domain.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.models.News;
import org.cmsspringfive.newscms.domain.models.Review;
import org.cmsspringfive.newscms.domain.service.NewsService;
import org.cmsspringfive.newscms.domain.vo.NewsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/news/")
@Api(tags = "News", description = "News API")
public class NewsResource {

    private final NewsService newsService;

    public NewsResource(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find News", notes = "Find the News by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 400, message = "News not found")})
    public ResponseEntity<News> findOne(@PathVariable(value = "id") String id){

        return ResponseEntity.ok(new News());
    }

    @GetMapping
    @ApiOperation(value = "List News", notes = "List all News")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News found"),
            @ApiResponse(code = 400, message = "News not found")
    })
    public ResponseEntity<List<News>> findAll(){
        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }

    @PostMapping
    @ApiOperation(value = "Create News", notes = "It permits to create a new News")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News created successfully"),
            @ApiResponse(code = 400, message = "News not found")
    })
    public ResponseEntity<News> newNews(NewsRequest news){
        return new ResponseEntity<>(new News(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete News", notes = "It permits to remove a News")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News removed successfully"),
            @ApiResponse(code = 400, message = "News not found")
    })
    public void removeNews(@PathVariable("id") String id){

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Create News", notes = "It permits to create a new News")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News update successfully"),
            @ApiResponse(code = 400, message = "News not found"),
            @ApiResponse(code = 404, message = "Invalid request")
    })
    public ResponseEntity<News> updateNews(@PathVariable("id") String id, NewsRequest news){
        return new ResponseEntity<>(new News(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/review/{userId}")
    @ApiOperation(value = "Review request for a News", notes = "It permits to request a review for a News by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News review request submit successfully"),
            @ApiResponse(code = 400, message = "News not found"),
            @ApiResponse(code = 404, message = "Invalid request")
    })
    public ResponseEntity<Review> review(@PathVariable("id") String id, @PathVariable("userId") String userId){
        return ResponseEntity.ok(new Review());
    }

    @GetMapping(value = "/revised")
    @ApiOperation(value = "List Revised News", notes = "It permits to request all revised News")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "News review request submit successfully"),
            @ApiResponse(code = 400, message = "News not found"),
            @ApiResponse(code = 404, message = "Invalid request")
    })
    public ResponseEntity<List<News>> revisedNews(){

        return ResponseEntity.ok(Arrays.asList(new News(), new News()));
    }
}
