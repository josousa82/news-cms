package org.cmsspringfive.newscms.domain.service;

import com.google.common.collect.Lists;
import org.cmsspringfive.newscms.domain.exceptions.NewsNotFoundException;
import org.cmsspringfive.newscms.domain.models.News;
import org.cmsspringfive.newscms.domain.repository.NewsRepository;
import org.cmsspringfive.newscms.domain.voDtos.NewsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public News create(NewsRequest newsRequest){

        final News news = new News();

        news.setTitle(newsRequest.getTitle());
        news.setContent(newsRequest.getContent());
        news.setCategories(newsRequest.getCategories());
        news.setTags(newsRequest.getTags());
        return this.newsRepository.save(news);
    }

    @Transactional
    public void removeNews(String id){

        final Optional<News> news = this.newsRepository.findById(id);

        if (news.isPresent()){
             this.newsRepository.delete(news.get());
        }else {
            throw new NewsNotFoundException("News with id " + id + " not found.");
        }
    }

    public List<News> findAll(){
        return Lists.newArrayList(newsRepository.findAll());
    }

    public ResponseEntity<List<News>> revisedNews(){

        return null;
    }
    public News findOne(String id){
        return null; //this.newsRepository.findOne(id);
    }

}
