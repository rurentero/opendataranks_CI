package io.swagger.api;

import io.swagger.model.Organization;
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
public class OrganizationsApiControllerIntegrationTest {

    @Autowired
    private OrganizationsApi api;
    private Pageable pageable;
    private PagedResourcesAssembler assembler;

    @Test
    public void getAllOrganizationsTest() throws Exception {
        ResponseEntity<PagedResources<Organization>> responseEntity = api.getAllOrganizations(pageable, assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllOrganizationsByNameTest() throws Exception {
        String name = "name_example";
        ResponseEntity<PagedResources<Organization>> responseEntity = api.getAllOrganizationsByName(name, pageable, assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllOrganizationsByTagsTest() throws Exception {
        List<String> tags = Arrays.asList("tags_example");
        ResponseEntity<PagedResources<Organization>> responseEntity = api.getAllOrganizationsByTags(tags, pageable, assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getOrganizationByIdTest() throws Exception {
        String organizationId = "organizationId_example";
        ResponseEntity<Organization> responseEntity = api.getOrganizationById(organizationId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
