package io.swagger.api;

import io.swagger.model.Reuse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ReusesApiController implements ReusesApi {

    private static final Logger log = LoggerFactory.getLogger(ReusesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReusesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Reuse>> getAllReuses(@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Reuse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Reuse>> getAllReusesByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Reuse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Reuse>> getAllReusesByOrganization(@NotNull @ApiParam(value = "name of the organization", required = true) @Valid @RequestParam(value = "name", required = true) String name,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Reuse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Reuse>> getAllReusesByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags,@Min(0)@ApiParam(value = "number of records to skip for pagination", allowableValues = "") @Valid @RequestParam(value = "skip", required = false) Integer skip,@Min(0) @Max(50) @ApiParam(value = "maximum number of records to return", allowableValues = "") @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<List<Reuse>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Reuse> getReuseById(@ApiParam(value = "pass the reuse id to return its properties",required=true) @PathVariable("reuseId") String reuseId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Reuse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
