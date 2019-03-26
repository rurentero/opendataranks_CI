package io.swagger.api;

import io.swagger.model.Dataset;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.DatasetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Controller
public class DatasetsApiController implements DatasetsApi {

    private static final Logger log = LoggerFactory.getLogger(DatasetsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    DatasetRepository datasetRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public DatasetsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Dataset>> getAllDatasets(@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        List<Dataset> datasets = datasetRepository.findAll();
        return new ResponseEntity<List<Dataset>>(datasets, HttpStatus.OK);
    }

    public ResponseEntity<List<Dataset>> getAllDatasetsByLicense(@NotNull @ApiParam(value = "license tyoe of the record to search", required = true) @Valid @RequestParam(value = "license", required = true) String license,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        log.info("Parametro license: " + license);
        if(license==null){
            return new ResponseEntity<List<Dataset>>(HttpStatus.BAD_REQUEST);
        }else{
            List<Dataset> datasets = datasetRepository.findByLicense(license);
            return new ResponseEntity<List<Dataset>>(datasets, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Dataset>> getAllDatasetsByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        log.info("Parametro name: " + name);
        if(name==null){
            return new ResponseEntity<List<Dataset>>(HttpStatus.BAD_REQUEST);
        }else{
            List<Dataset> datasets = datasetRepository.findByTitleContainingIgnoreCase(name);
            return new ResponseEntity<List<Dataset>>(datasets, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Dataset>> getAllDatasetsByOrganization(@NotNull @ApiParam(value = "name of the organization", required = true) @Valid @RequestParam(value = "name", required = true) String name,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if(name==null){
            return new ResponseEntity<List<Dataset>>(HttpStatus.BAD_REQUEST);
        }else {
            List<Dataset> datasets = datasetRepository.findByOrganizationTitleContainingIgnoreCase(name);
            return new ResponseEntity<List<Dataset>>(datasets, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Dataset>> getAllDatasetsByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        //TODO Completar tras indicar las relaciones de entidades con Tag
        return new ResponseEntity<List<Dataset>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Dataset> getDatasetById(@ApiParam(value = "pass the dataset id to return its properties",required=true) @PathVariable("datasetId") String datasetId) {
        String accept = request.getHeader("Accept");
        if(datasetId==null)
            return new ResponseEntity<Dataset>(HttpStatus.BAD_REQUEST);
        Dataset dataset = datasetRepository.findOne(datasetId);
        if(dataset==null)
            return new ResponseEntity<Dataset>(dataset, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Dataset>(dataset, HttpStatus.OK);
    }

}
