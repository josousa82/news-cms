package org.cmsspringfive.newscms.domain.models;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "news_id")
    String id;

    @Column(name = "news_title")
    String title;

    @Column(name = "news_content")
    String content;

    @ManyToOne
    User author;

    @OneToMany
    Set<User> mandatoryReviewers = new HashSet<>();

    @ElementCollection
    @AttributeOverrides(value = {
            @AttributeOverride(name = "userId", column = @Column(name = "user_id")),
            @AttributeOverride(name = "status", column = @Column(name = "review_status"))
    })
    private Set<Review> reviewers = new HashSet<>();

    @OneToMany
    Set<Category> categories = new HashSet<>();

    @ElementCollection
    Set<Tag> tags = new HashSet<>();


    public Review review(String userId, String status){
        final Review review = new Review(userId, status);
        this.reviewers.add(review);
        return review;
    }

    public Boolean revised(){
        return this.mandatoryReviewers.stream().allMatch(reviewer -> this.reviewers.stream()
                .anyMatch(review -> reviewer.userId.equals(review.userId) && "approved".equals(review.status)));
    }

}
