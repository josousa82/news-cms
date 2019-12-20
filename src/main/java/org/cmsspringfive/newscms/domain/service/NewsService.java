package org.cmsspringfive.newscms.domain.service;

import org.cmsspringfive.newscms.domain.exceptions.NewsNotFoundException;
import org.cmsspringfive.newscms.domain.models.News;
import org.cmsspringfive.newscms.domain.repository.NewsRepository;
import org.cmsspringfive.newscms.domain.vo.NewsRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Transactional
    public News update(String id, NewsRequest newsRequest){
        final Optional<News> news = this.newsRepository.findById(id);
        if (news.isPresent()){
            final News newsDB = news.get();
            newsDB.setTitle(newsRequest.getTitle());
            newsDB.setContent(newsRequest.getContent());
            newsDB.setCategories(newsRequest.getCategories());
            newsDB.setTags(newsRequest.getTags());
            return this.newsRepository.save(newsDB);
        }else {
            throw new NewsNotFoundException("News with id " + id + " not found.");
        }
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
        return null; //this.newsRepository.findOne(id);
    }

}
