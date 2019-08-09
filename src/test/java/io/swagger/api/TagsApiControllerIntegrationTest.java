package io.swagger.api;

import io.swagger.model.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TagsApiControllerIntegrationTest {

    @Autowired
    private TagsApi api;
    private Pageable pageable;
    private PagedResourcesAssembler assembler;

    @Test
    public void getAllTagsTest() throws Exception {
        ResponseEntity<PagedResources<Tag>> responseEntity = api.getAllTags(pageable, assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
