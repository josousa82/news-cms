package org.cmsspringfive.newscms.domain.resources;

import ch.qos.logback.classic.html.DefaultThrowableRenderer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.cmsspringfive.newscms.domain.exceptions.CategoryNotFoundException;
import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.repository.CategoryRepository;
import org.cmsspringfive.newscms.domain.service.CategoryService;
import org.cmsspringfive.newscms.domain.vo.CategoryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
@Api(tags = "Category", description = "Category API")

public class CategoryResource {

    private final CategoryService categoryService;
    private CategoryRepository categoryRepository;
    private String id;
    private CategoryRequest categoryRequest;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category created successfully"),
            @ApiResponse(code = 400, message = "Category not found")
    })
    public ResponseEntity<Category> createCategory(CategoryRequest category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update category", notes = "It permits to update a category")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Category update successfully"),
            @ApiResponse(code = 404, message = "Category not found"),
            @ApiResponse(code = 500, message = "Invalid request")
    })

    @ResponseBody
    public ResponseEntity<Category> updateCategory(@NotNull @PathVariable("id") String id, @NotNull CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryService.updateCategory(id, categoryRequest),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Find category", notes = "Find the category by ID")
    @ApiResponses(value = {
         @ApiResponse(code = 200, message = "Category found"),
         @ApiResponse(code = 404, message = "Category not found"),
    })
    public ResponseEntity<Category> findOne(@PathVariable("id") String id){

        final Category categoryDB = this.categoryService.findById(id);

        if(categoryDB != null){
            return new ResponseEntity<>(categoryService.findById(id), HttpStatus.FOUND);
        }else{
            throw new CategoryNotFoundException(id);
        }
    }

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category found"),
            @ApiResponse(code = 400, message = "Category not found")
    })

    public ResponseEntity<List<Category>> findAll(){
            return ResponseEntity.ok(categoryService.findAll());
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete category", notes = "It permits to remove a category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category removed successfully"),
            @ApiResponse(code = 400, message = "Category not found")
    })
    @ResponseBody
    public ResponseEntity deleteCategory(@PathVariable("id") String id){

      final Optional<Category> optionalCategory = Optional.ofNullable(this.categoryService.findById(id));
      categoryService.delete(id);
      if (optionalCategory.isPresent()){
          categoryService.delete(optionalCategory.get().getId());
          return new ResponseEntity(HttpStatus.OK);
      }else{

         throw new CategoryNotFoundException("Category does not exist");

         //return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



//        optionalCategory.ifPresentOrElse((t) -> {
//            categoryService.delete(t.getId());
//
//        }, () -> new CategoryNotFoundException("Category with id " + id + " does not exist"));
//        return new ResponseEntity(HttpStatus.OK);
    }


}
