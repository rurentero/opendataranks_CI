package io.swagger.api;

import io.swagger.model.Reuse;

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
public class ReusesApiControllerIntegrationTest {

    @Autowired
    private ReusesApi api;

    //TODO Implementar tests

    @Test
    public void getAllReusesTest() throws Exception {
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Reuse>> responseEntity = api.getAllReuses(skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllReusesByNameTest() throws Exception {
//        String name = "name_example";
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Reuse>> responseEntity = api.getAllReusesByName(name, skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllReusesByOrganizationTest() throws Exception {
//        String name = "name_example";
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Reuse>> responseEntity = api.getAllReusesByOrganization(name, skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllReusesByTagsTest() throws Exception {
//        List<String> tags = Arrays.asList("tags_example");
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Reuse>> responseEntity = api.getAllReusesByTags(tags, skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getReuseByIdTest() throws Exception {
        String reuseId = "reuseId_example";
        ResponseEntity<Reuse> responseEntity = api.getReuseById(reuseId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
