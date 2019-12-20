package org.cmsspringfive.newscms.domain.repository;

import org.cmsspringfive.newscms.domain.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository  extends JpaRepository<News, String> {

}
