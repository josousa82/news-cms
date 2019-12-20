package org.cmsspringfive.newscms.domain.service;

import org.cmsspringfive.newscms.domain.exceptions.CategoryNotFoundException;
import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.repository.CategoryRepository;
import org.cmsspringfive.newscms.domain.vo.CategoryRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category update(Category category){
        return this.categoryRepository.save(category);
    }

    @Transactional
    public Category create(CategoryRequest request){
        Category category =  new Category();
        category.setName(request.getName());
        return this.categoryRepository.save(category);
    }

    @Transactional
    public void delete(String id){
        final Optional<Category> category = this.categoryRepository.findById(id);
        category.ifPresent(this.categoryRepository::delete);
    }

    public List<Category> findAll(){

        return this.categoryRepository.findAll();
    }

    public List<Category> findByName(String id){
        return this.categoryRepository.findByName(id);
    }

    public List<Category> findByNameStartingWith(String name){
        return this.categoryRepository.findByNameIgnoreCaseStartingWith(name);
    }

    public Category findOne(String id) {
        final Optional<Category> category = this.categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }else{
            throw new CategoryNotFoundException(id);
        }
    }

}
