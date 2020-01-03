package org.cmsspringfive.newscms.domain.repository;

import org.cmsspringfive.newscms.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAll();
    User findByUserId(String id);



}
