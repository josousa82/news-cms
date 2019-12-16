package org.cmsspringfive.newscms.domain.service;

import org.cmsspringfive.newscms.domain.models.News;
import org.cmsspringfive.newscms.domain.repository.NewsRepository;
import org.cmsspringfive.newscms.domain.vo.NewsRequest;
import org.springframework.stereotype.Service;

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

//        if(news.revised())
//            return this.newsRepository.save(news);
//        else{
//            return
//        }
        return this.newsRepository.save(news);
    }
}
