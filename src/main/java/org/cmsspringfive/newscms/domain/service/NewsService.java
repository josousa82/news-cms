package org.cmsspringfive.newscms.domain.service;

import org.cmsspringfive.newscms.domain.models.News;
import org.cmsspringfive.newscms.domain.repository.NewsRepository;
import org.cmsspringfive.newscms.domain.vo.NewsRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News update(String id, NewsRequest newsRequest){
        final News news = this.newsRepository.findOne(id);
        news.setTitle(newsRequest.getTitle());
        news.setContent(newsRequest.getContent());
        return this.newsRepository.save(news);
    }

    public News create(NewsRequest newsRequest){
        final News news = new News();

        // should be get last id from
        news.setId(UUID.randomUUID().toString());
        news.setTitle(newsRequest.getTitle());
        news.setContent(newsRequest.getContent());
        news.setCategories(newsRequest.getCategories());
        return this.newsRepository.save(news);
    }

    public News findOne(String id){
        return this.newsRepository.findOne(id);
    }

}
