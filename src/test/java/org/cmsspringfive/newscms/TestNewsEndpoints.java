package org.cmsspringfive.newscms;

import org.cmsspringfive.newscms.domain.models.News;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestNewsEndpoints {
    @Mock
    News news;

    @BeforeAll
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation(){
        assertNotNull(news);
    }
}
