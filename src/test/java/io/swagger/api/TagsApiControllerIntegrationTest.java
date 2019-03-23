package io.swagger.api;

import io.swagger.model.Tag;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagsApiControllerIntegrationTest {

    @Autowired
    private TagsApi api;

    @Test
    public void getAllTagsTest() throws Exception {
        Integer skip = 56;
        Integer limit = 56;
        ResponseEntity<List<Tag>> responseEntity = api.getAllTags(skip, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
