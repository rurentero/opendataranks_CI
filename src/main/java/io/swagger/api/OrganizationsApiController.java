package io.swagger.api;

import io.swagger.model.Organization;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.OrganizationRepository;
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
public class OrganizationsApiController implements OrganizationsApi {

    private static final Logger log = LoggerFactory.getLogger(OrganizationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    OrganizationRepository organizationRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public OrganizationsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Organization>> getAllOrganizations(@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        List<Organization> organizations = organizationRepository.findAll();
        return new ResponseEntity<List<Organization>>(organizations, HttpStatus.OK);
    }

    public ResponseEntity<List<Organization>> getAllOrganizationsByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        log.info("Parametro name: " + name);
        if(name==null){
            return new ResponseEntity<List<Organization>>(HttpStatus.BAD_REQUEST);
        }else{
            List<Organization> organizations = organizationRepository.findByTitleContainingIgnoreCase(name);
            return new ResponseEntity<List<Organization>>(organizations, HttpStatus.OK);
        }
    }

    public ResponseEntity<List<Organization>> getAllOrganizationsByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        //It won't be implemented.
        return new ResponseEntity<List<Organization>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Organization> getOrganizationById(@ApiParam(value = "pass the organization id to return its properties",required=true) @PathVariable("organizationId") String organizationId) {
        String accept = request.getHeader("Accept");
        if(organizationId==null)
            return new ResponseEntity<Organization>(HttpStatus.BAD_REQUEST);
        Organization organization = organizationRepository.findOne(organizationId);
        if(organization==null)
            return new ResponseEntity<Organization>(organization, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Organization>(organization, HttpStatus.OK);
    }

}
