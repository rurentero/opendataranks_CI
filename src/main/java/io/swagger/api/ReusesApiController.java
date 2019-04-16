package io.swagger.api;

import io.swagger.helpers.RankingParams;
import io.swagger.model.Reuse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repository.ReuseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
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
public class ReusesApiController implements ReusesApi {

    private static final Logger log = LoggerFactory.getLogger(ReusesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ReuseRepository reuseRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public ReusesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // TODO Probar si se puede recuperar de la request un RankingParams
    public ResponseEntity<PagedResources<Reuse>> getAllReuses(@RequestParam(defaultValue = "W1") String rankingId, @RequestParam(required = false) Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        // TODO Código original del método, dejarlo activo tras las pruebas de ponderaciones.
//        Page<Reuse> reuses = reuseRepository.findAll(pageable);
//        PagedResources<Reuse> pr = assembler.toResource(reuses,linkTo(ReusesApiController.class).slash("/reuses").withSelfRel());
//        return new ResponseEntity (pr, HttpStatus.OK);
        // TODO Cambios necesarios para que el sistema de puntuaciones funcione correctamente:
        // TODO La idea es usar siempre una ponderacion. Si el usuario la indica, usarla, si no, usar la ponderacion por defecto (Id= W1 siempre).
        // Sort es opcional, si se indica, las ponderaciones no se aplicarán.
        // Incluir en los parametros: WeightId o el nombre para seleccionar la ponderacion      (Se requiere siempre)
        //                            WeightOrder DESC/ASC                                      (Opcional, si no hay, usar la por defecto ASC) (Si se indica y es incorrecta, informar)

        // Check bad requests
//        if(rankingParams.getRankingId()==null)
//            return new ResponseEntity ("Bad params: A default ranking must be set. rankingId is required", HttpStatus.BAD_REQUEST);


        // Retrieve Reuses
        Page<Reuse> reuses;

        if(pageable.getSort()!=null) {
            log.info("Info de la REQUEST sobre sort: Existe el sort " + pageable.getSort().toString());
            reuses = reuseRepository.findAll(pageable);
        }else {
            log.info("Info de la REQUEST sobre sort: " + "Sort es NULO, procediendo a usar RankingParams");
            log.info("Key de ranking a usar: " + rankingId);
            if(inverted==null) {
                log.info("Parametro Inverted no especificado, usar DESC");
                reuses = reuseRepository.findByWeightAssocWeightIdOrderByWeightAssocValueDesc(rankingId, pageable);
            }else {
                log.info("Parámetro Inverted especificado, usar ASC: " + inverted);
                reuses = reuseRepository.findByWeightAssocWeightIdOrderByWeightAssocValueAsc(rankingId, pageable);
            }
        }

        PagedResources<Reuse> pr = assembler.toResource(reuses,linkTo(methodOn(ReusesApiController.class).getAllReuses(rankingId, inverted, pageable, assembler)).withSelfRel());
        pr.add(linkTo(ReusesApiController.class).slash("/reuses").withRel("collection"));
        return new ResponseEntity (pr, HttpStatus.OK);
    }

    public ResponseEntity<PagedResources<Reuse>> getAllReusesByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        log.info("Parametro name: " + name);
        if(name==null){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else{
            Page<Reuse> reuses = reuseRepository.findByTitleContainingIgnoreCase(name, pageable);
            PagedResources<Reuse> pr = assembler.toResource(reuses,linkTo(methodOn(ReusesApiController.class).getAllReusesByName(name, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
    }

    public ResponseEntity<PagedResources<Reuse>> getAllReusesByOrganization(@NotNull @ApiParam(value = "name of the organization", required = true) @Valid @RequestParam(value = "name", required = true) String name, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(name==null){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else {
            Page<Reuse> reuses = reuseRepository.findByOrganizationTitleContainingIgnoreCase(name, pageable);
            PagedResources<Reuse> pr = assembler.toResource(reuses,linkTo(methodOn(ReusesApiController.class).getAllReusesByOrganization(name, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
    }


    public ResponseEntity<PagedResources<Reuse>> getAllReusesByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags, Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        if(tags.isEmpty()){
            return new ResponseEntity (HttpStatus.BAD_REQUEST);
        }else {
            Page<Reuse> reuses = reuseRepository.findDistinctByTagsNameIgnoreCaseIn(tags, pageable);
            PagedResources<Reuse> pr = assembler.toResource(reuses,linkTo(methodOn(ReusesApiController.class).getAllReusesByTags(tags, pageable, assembler)).withSelfRel());
            return new ResponseEntity (pr, HttpStatus.OK);
        }
    }

    public ResponseEntity<Reuse> getReuseById(@ApiParam(value = "pass the reuse id to return its properties",required=true) @PathVariable("reuseId") String reuseId) {
        String accept = request.getHeader("Accept");
        if(reuseId==null)
            return new ResponseEntity<Reuse>(HttpStatus.BAD_REQUEST);
        Reuse reuse = reuseRepository.findOne(reuseId);
        if(reuse==null)
            return new ResponseEntity<Reuse>(reuse, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Reuse>(reuse, HttpStatus.OK);
    }

}
