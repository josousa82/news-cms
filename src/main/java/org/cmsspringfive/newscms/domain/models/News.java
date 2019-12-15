package org.cmsspringfive.newscms.domain.models;

import lombok.Data;

import java.util.Set;

@Data
public class News {

    String id;
    String title;
    String content;

    User author;

    Set<User> mandatoryReviewers;
    Set<Review> reviewers;
    Set<Category> categories;
    Set<Tag> tags;


}
