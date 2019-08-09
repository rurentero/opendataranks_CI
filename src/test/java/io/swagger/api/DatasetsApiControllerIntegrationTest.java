package io.swagger.api;

import io.swagger.model.Dataset;

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
public class DatasetsApiControllerIntegrationTest {

    @Autowired
    private DatasetsApi api;
    private Pageable pageable;
    private PagedResourcesAssembler assembler;

    @Test
    public void getAllDatasetsTest() throws Exception {
        ResponseEntity<PagedResources<Dataset>> responseEntity = api.getAllDatasets("W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByLicenseTest() throws Exception {
        String license = "Open";
        ResponseEntity<PagedResources<Dataset>> responseEntity = api.getAllDatasetsByLicense(license,"W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByNameTest() throws Exception {
        String name = "ExampleDataset";
        ResponseEntity<PagedResources<Dataset>> responseEntity = api.getAllDatasetsByName(name,"W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByOrganizationTest() throws Exception {
        String name = "ExampleOrganization";
        ResponseEntity<PagedResources<Dataset>> responseEntity = api.getAllDatasetsByOrganization(name, "W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByTagsTest() throws Exception {
        List<String> tags = Arrays.asList("ExampleTag");
        ResponseEntity<PagedResources<Dataset>> responseEntity = api.getAllDatasetsByTags(tags, "W1",false, pageable,assembler);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getDatasetByIdTest() throws Exception {
        String datasetId = "datasetId_example";
        ResponseEntity<Dataset> responseEntity = api.getDatasetById(datasetId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
