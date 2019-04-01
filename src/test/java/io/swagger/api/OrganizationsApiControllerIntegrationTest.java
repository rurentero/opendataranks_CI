package io.swagger.api;

import io.swagger.model.Organization;
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
public class OrganizationsApiControllerIntegrationTest {

    @Autowired
    private OrganizationsApi api;

    //TODO Implementar tests
    @Test
    public void getAllOrganizationsTest() throws Exception {
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Organization>> responseEntity = api.getAllOrganizations(skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllOrganizationsByNameTest() throws Exception {
//        String name = "name_example";
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Organization>> responseEntity = api.getAllOrganizationsByName(name, skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllOrganizationsByTagsTest() throws Exception {
//        List<String> tags = Arrays.asList("tags_example");
//        Integer skip = 56;
//        Integer limit = 56;
//        ResponseEntity<List<Organization>> responseEntity = api.getAllOrganizationsByTags(tags, skip, limit);
//        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getOrganizationByIdTest() throws Exception {
        String organizationId = "organizationId_example";
        ResponseEntity<Organization> responseEntity = api.getOrganizationById(organizationId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
