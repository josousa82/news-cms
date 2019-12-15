package org.cmsspringfive.newscms.domain.resources;

import org.cmsspringfive.newscms.domain.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(Arrays.asList(new Category(), new Category()));
    }

    @PostMapping
    public ResponseEntity<Category> newCategory(CategoryRequest category){
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable("id") String id){

    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCatedory(@PathVariable("id") String id, CategoryRequest category){
       return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
