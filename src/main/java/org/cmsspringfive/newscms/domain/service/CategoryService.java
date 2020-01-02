package org.cmsspringfive.newscms.domain.service;

import com.google.common.base.Strings;
import com.sun.jdi.request.InvalidRequestStateException;
import org.cmsspringfive.newscms.domain.exceptions.CategoryNotFoundException;
import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.repository.CategoryRepository;
import org.cmsspringfive.newscms.domain.vo.CategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Transactional
    public Category create(CategoryRequest request){
        Category category =  new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }


    @Transactional
    public Category updateCategory(String id, CategoryRequest categoryRequest){

        final Optional<Category> categoryToUpdate = this.categoryRepository.findById(id);

        if(categoryToUpdate.isPresent() && !Strings.isNullOrEmpty(categoryRequest.getName())){

            Category categoryDB = categoryToUpdate.get();
            categoryDB.setName(categoryRequest.getName());

            return this.categoryRepository.save(categoryDB);

        }else{
            throw new CategoryNotFoundException("This category does not exist!");
        }

    }


   // @Transactional
    public void delete(String id){

        final Optional<Category> category = this.categoryRepository.findById(id);

       category.ifPresentOrElse((t) -> this.categoryRepository.deleteById(t.getId()),
               () ->  new CategoryNotFoundException("Category with id " + id + " does not exist"));

       // this.categoryRepository.deleteById(id);
    }

    public List<Category> findAll(){

        final List<Category> categoryList = categoryRepository.findAll();
        if(categoryList.isEmpty()){
            throw new CategoryNotFoundException("There are no categories yet!");
        }else {
            // return this.categoryRepository.findAll();
            return categoryList;
        }
    }

    public List<Category> findByName(String id){
        return this.categoryRepository.findByName(id);
    }


    public List<Category> findByNameStartingWith(String name){
        return this.categoryRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public Category findById(String id) throws CategoryNotFoundException {

        final Optional<Category> category = this.categoryRepository.findById(id);

        if(category.isPresent()){
            return category.get();
        }else{
            throw new CategoryNotFoundException("Category with id " + id + " not found.");
        }
    }

}
