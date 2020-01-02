package org.cmsspringfive.newscms.domain.repository;

import org.cmsspringfive.newscms.domain.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface CategoryRepository  extends JpaRepository<Category, String> {

    List<Category> findByName(String name);

    List<Category> findByNameIgnoreCaseStartingWith(String name);

    List<Category> findAll();

    void deleteById(String id);

    @Modifying
    @Query(value = "update Category c set c.name = ?2 where c.id = ?1")
    Optional<Category> setCategoryInfoById(String id, String name);


}

