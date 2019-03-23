package io.swagger.api;

import io.swagger.model.Dataset;

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
public class DatasetsApiControllerIntegrationTest {

    @Autowired
    private DatasetsApi api;

    @Test
    public void getAllDatasetsTest() throws Exception {
        Integer skip = 56;
        Integer limit = 56;
        ResponseEntity<List<Dataset>> responseEntity = api.getAllDatasets(skip, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByLicenseTest() throws Exception {
        String license = "license_example";
        Integer skip = 56;
        Integer limit = 56;
        ResponseEntity<List<Dataset>> responseEntity = api.getAllDatasetsByLicense(license, skip, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByNameTest() throws Exception {
        String name = "name_example";
        Integer skip = 56;
        Integer limit = 56;
        ResponseEntity<List<Dataset>> responseEntity = api.getAllDatasetsByName(name, skip, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByOrganizationTest() throws Exception {
        String name = "name_example";
        Integer skip = 56;
        Integer limit = 56;
        ResponseEntity<List<Dataset>> responseEntity = api.getAllDatasetsByOrganization(name, skip, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getAllDatasetsByTagsTest() throws Exception {
        List<String> tags = Arrays.asList("tags_example");
        Integer skip = 56;
        Integer limit = 56;
        ResponseEntity<List<Dataset>> responseEntity = api.getAllDatasetsByTags(tags, skip, limit);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

    @Test
    public void getDatasetByIdTest() throws Exception {
        String datasetId = "datasetId_example";
        ResponseEntity<Dataset> responseEntity = api.getDatasetById(datasetId);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
