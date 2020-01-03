package org.cmsspringfive.newscms.domain.voDtos;

import lombok.Data;
import org.cmsspringfive.newscms.domain.models.Category;
import org.cmsspringfive.newscms.domain.models.Tag;

import java.util.Set;

@Data
public class NewsRequest {

    String title;
    String content;

    Set<Category> categories;
    Set<Tag> tags;
}
