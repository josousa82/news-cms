package org.cmsspringfive.newscms.domain.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.service.CategoryService;
import org.cmsspringfive.newscms.domain.vo.CategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@Api(tags = "Category", description = "Category API")

public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find category", notes = "Find the category by ID")
    @ApiResponses(value = {
         @ApiResponse(code = 200, message = "Category found"),
         @ApiResponse(code = 400, message = "Category not found")
    })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(new Category());
    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 400, message = "Category not found")
    })
    public ResponseEntity<List<Category>> findAll(){

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category());

        return ResponseEntity.ok(categoryList);
    }

    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category created successfully"),
            @ApiResponse(code = 400, message = "Category not found")
    })
    public ResponseEntity<Category> newCategory(CategoryRequest category){
        return new ResponseEntity<>(new Category(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete category", notes = "It permits to remove a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category removed successfully"),
            @ApiResponse(code = 400, message = "Category not found")
    })
    public void deleteCategory(@PathVariable("id") String id){

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category update successfully"),
            @ApiResponse(code = 400, message = "Category not found"),
            @ApiResponse(code = 404, message = "Invalid request")
    })
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id, CategoryRequest category){
       return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }
}
