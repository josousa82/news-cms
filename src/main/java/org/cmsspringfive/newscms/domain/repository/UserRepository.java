package org.cmsspringfive.newscms.domain.repository;

import org.cmsspringfive.newscms.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {



}
