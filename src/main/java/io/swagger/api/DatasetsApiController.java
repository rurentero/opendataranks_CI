package io.swagger.api;

import io.swagger.model.Dataset;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.DatasetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpHeaders;
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

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Controller
public class DatasetsApiController implements DatasetsApi {

    private static final Logger log = LoggerFactory.getLogger(DatasetsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    DatasetRepository datasetRepository;

    @Autowired private EntityLinks links;

    @org.springframework.beans.factory.annotation.Autowired
    public DatasetsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    //TODO Probar si al aplicar methodOn (igual que en el resto) se recoge mejor la paginacion al pasar entre links

    public ResponseEntity<PagedResources<Dataset>> getAllDatasets(Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        Page<Dataset> datasets = datasetRepository.findAll(pageable);
        PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(DatasetsApiController.class).slash("/datasets").withSelfRel());
        return new ResponseEntity (pr, HttpStatus.OK);
    }


    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByLicense(@NotNull @ApiParam(value = "license type of the record to search", required = true) @Valid @RequestParam(value = "license", required = true) String license, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(license==null){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else{
            Page<Dataset> datasets = datasetRepository.findByLicense(license, pageable);
            PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByLicense(license, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
    }


    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(name==null){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else{
            Page<Dataset> datasets = datasetRepository.findByTitleContainingIgnoreCase(name, pageable);
            PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByName(name, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
    }


    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByOrganization(@NotNull @ApiParam(value = "name of the organization", required = true) @Valid @RequestParam(value = "name", required = true) String name,Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(name==null){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else {
            Page<Dataset> datasets = datasetRepository.findByOrganizationTitleContainingIgnoreCase(name, pageable);
            PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByOrganization(name, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
    }


    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(tags.isEmpty()){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else {
            Page<Dataset> datasets = datasetRepository.findDistinctByTagsNameIgnoreCaseIn(tags, pageable);
            PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByTags(tags, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
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

//    private String createLinkHeader(PagedResources <Dataset> pr) {
//        final StringBuilder linkHeader = new StringBuilder();
//        linkHeader.append(buildLinkHeader(pr.getLink("first").getHref(), "first"));
//        linkHeader.append(", ");
//        linkHeader.append(buildLinkHeader(pr.getLink("next").getHref(), "next"));
//        return linkHeader.toString();
//    }
//
//    public static String buildLinkHeader(final String uri, final String rel) {
//        return "<" + uri + ">; rel=\"" + rel + "\"";
//    }

}
