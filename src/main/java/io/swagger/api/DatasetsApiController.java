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
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Autowired private RepositoryEntityLinks repositoryEntityLinksinks;

    @org.springframework.beans.factory.annotation.Autowired
    public DatasetsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<PagedResources<Dataset>> getAllDatasets(@RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        // Retrieve Datasets
        Page<Dataset> datasets;

        if(pageable.getSort()!=null) {
            log.info("Info de la REQUEST sobre sort: Existe el sort " + pageable.getSort().toString());
            datasets = datasetRepository.findAll(pageable);
        }else {
            log.info("Info de la REQUEST sobre sort: " + "Sort es NULO, procediendo a usar RankingParams");
            log.info("Key de ranking a usar: " + rankingId);
            log.info("PARAMETRO INVERTED: " + inverted);
            if(!inverted) {
                log.info("Parametro Inverted no especificado, usar DESC");
                datasets = datasetRepository.findByWeightAssocWeightIdOrderByWeightAssocValueDesc(rankingId, pageable);
            }else {
                log.info("Parámetro Inverted especificado, usar ASC: " + inverted);
                datasets = datasetRepository.findByWeightAssocWeightIdOrderByWeightAssocValueAsc(rankingId, pageable);
            }
        }

        PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasets(rankingId, inverted, pageable, assembler)).withSelfRel());
        pr.add(linkTo(DatasetsApiController.class).slash("/datasets").withRel("collection"));
        return new ResponseEntity (pr, HttpStatus.OK);
    }

    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByLicense(@NotNull @ApiParam(value = "license type of the record to search", required = true) @Valid @RequestParam(value = "license", required = true) String license, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");

        if (license==null)
            return new ResponseEntity (HttpStatus.BAD_REQUEST);

        // Retrieve Datasets
        Page<Dataset> datasets;

        if(pageable.getSort()!=null) {
            log.info("Info de la REQUEST sobre sort: Existe el sort " + pageable.getSort().toString());
            datasets = datasetRepository.findByLicenseContainingIgnoreCase(license,pageable);
        }else {
            log.info("Info de la REQUEST sobre sort: " + "Sort es NULO, procediendo a usar RankingParams");
            log.info("Key de ranking a usar: " + rankingId);
            if(!inverted) {
                log.info("Parametro Inverted no especificado, usar DESC");
                datasets = datasetRepository.findByLicenseContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(license, rankingId, pageable);
            }else {
                log.info("Parámetro Inverted especificado, usar ASC: " + inverted);
                datasets = datasetRepository.findByLicenseContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(license, rankingId, pageable);
            }
        }

        PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByLicense(license, rankingId, inverted, pageable, assembler)).withSelfRel());
        pr.add(linkTo(DatasetsApiController.class).slash("/datasets").withRel("collection"));
        return new ResponseEntity (pr, HttpStatus.OK);
    }

    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");

        if (name==null)
            return new ResponseEntity (HttpStatus.BAD_REQUEST);

        // Retrieve Datasets
        Page<Dataset> datasets;

        if(pageable.getSort()!=null) {
            log.info("Info de la REQUEST sobre sort: Existe el sort " + pageable.getSort().toString());
            datasets = datasetRepository.findByTitleContainingIgnoreCase(name, pageable);
        }else {
            log.info("Info de la REQUEST sobre sort: " + "Sort es NULO, procediendo a usar RankingParams");
            log.info("Key de ranking a usar: " + rankingId);
            if(!inverted) {
                log.info("Parametro Inverted no especificado, usar DESC");
                datasets = datasetRepository.findByTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(name, rankingId, pageable);
            }else {
                log.info("Parámetro Inverted especificado, usar ASC: " + inverted);
                datasets = datasetRepository.findByTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(name, rankingId, pageable);
            }
        }

        PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByName(name, rankingId, inverted, pageable, assembler)).withSelfRel());
        pr.add(linkTo(DatasetsApiController.class).slash("/datasets").withRel("collection"));
        return new ResponseEntity (pr, HttpStatus.OK);
    }

    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByOrganization(@NotNull @ApiParam(value = "name of the organization", required = true) @Valid @RequestParam(value = "name", required = true) String name, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(name==null)
            return new ResponseEntity (HttpStatus.BAD_REQUEST);

        // Retrieve Datasets
        Page<Dataset> datasets;

        if(pageable.getSort()!=null) {
            log.info("Info de la REQUEST sobre sort: Existe el sort " + pageable.getSort().toString());
            datasets = datasetRepository.findByOrganizationTitleContainingIgnoreCase(name, pageable);
        }else {
            log.info("Info de la REQUEST sobre sort: " + "Sort es NULO, procediendo a usar RankingParams");
            log.info("Key de ranking a usar: " + rankingId);
            if(!inverted) {
                log.info("Parametro Inverted no especificado, usar DESC");
                datasets = datasetRepository.findByOrganizationTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueDesc(name, rankingId, pageable);
            }else {
                log.info("Parámetro Inverted especificado, usar ASC: " + inverted);
                datasets = datasetRepository.findByOrganizationTitleContainingIgnoreCaseAndWeightAssocWeightIdOrderByWeightAssocValueAsc(name, rankingId, pageable);
            }
        }

        PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByOrganization(name, rankingId, inverted, pageable, assembler)).withSelfRel());
        pr.add(linkTo(DatasetsApiController.class).slash("/datasets").withRel("collection"));
        return new ResponseEntity (pr, HttpStatus.OK);
    }

    public ResponseEntity<PagedResources<Dataset>> getAllDatasetsByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted,  Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(tags.isEmpty())
            return new ResponseEntity (HttpStatus.BAD_REQUEST);

        // Retrieve Datasets
        Page<Dataset> datasets;

        if(pageable.getSort()!=null) {
            log.info("Info de la REQUEST sobre sort: Existe el sort " + pageable.getSort().toString());
            datasets = datasetRepository.findDistinctByTagsIdIgnoreCaseIn(tags, pageable);
        }else {
            log.info("Info de la REQUEST sobre sort: " + "Sort es NULO, procediendo a usar RankingParams");
            log.info("Key de ranking a usar: " + rankingId);
            if(!inverted) {
                log.info("Parametro Inverted no especificado, usar DESC");
                datasets = datasetRepository.findByTagsIdIgnoreCaseInAndWeightAssocWeightIdOrderByWeightAssocValueDesc(tags, rankingId, pageable);
            }else {
                log.info("Parámetro Inverted especificado, usar ASC: " + inverted);
                datasets = datasetRepository.findByTagsIdIgnoreCaseInAndWeightAssocWeightIdOrderByWeightAssocValueAsc(tags, rankingId, pageable);
            }
        }

        PagedResources<Dataset> pr = assembler.toResource(datasets,linkTo(methodOn(DatasetsApiController.class).getAllDatasetsByTags(tags, rankingId, inverted, pageable, assembler)).withSelfRel());
        pr.add(linkTo(DatasetsApiController.class).slash("/datasets").withRel("collection"));
        return new ResponseEntity (pr, HttpStatus.OK);
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
