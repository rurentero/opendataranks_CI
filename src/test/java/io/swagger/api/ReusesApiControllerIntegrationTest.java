package io.swagger.api;

import io.swagger.model.Reuse;

import java.util.*;

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
public class ReusesApiControllerIntegrationTest {

    @Autowired
    private ReusesApi api;
    private Pageable pageable;
    private PagedResourcesAssembler assembler;

    @Test
    public void getAllReusesTest() throws Exception {
        ResponseEntity<PagedResources<Reuse>> responseEntity = api.getAllReuses("W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllReusesByNameTest() throws Exception {
        String name = "ExampleReuse";
        ResponseEntity<PagedResources<Reuse>> responseEntity = api.getAllReusesByName(name, "W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllReusesByOrganizationTest() throws Exception {
        String name = "ExampleOrganization";
        ResponseEntity<PagedResources<Reuse>> responseEntity = api.getAllReusesByOrganization(name, "W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllReusesByTagsTest() throws Exception {
        List<String> tags = Arrays.asList("ExampleTag");
        ResponseEntity<PagedResources<Reuse>> responseEntity = api.getAllReusesByTags(tags, "W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getReuseByIdTest() throws Exception {
        String reuseId = "reuseId_example";
        ResponseEntity<Reuse> responseEntity = api.getReuseById(reuseId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
