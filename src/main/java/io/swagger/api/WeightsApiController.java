package io.swagger.api;

import io.swagger.model.Weight;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.repository.WeightRepository;
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
import javax.servlet.http.HttpServletRequest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Controller
public class WeightsApiController implements WeightsApi {

    private static final Logger log = LoggerFactory.getLogger(WeightsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    WeightRepository weightRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public WeightsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    /**
     * Retrieves all weights
     * @param pageable Pageable object
     * @param assembler Assembler
     * @return
     */
    public ResponseEntity<PagedResources<Weight>> getAllWeights(Pageable pageable, PagedResourcesAssembler assembler) {
        String accept = request.getHeader("Accept");
        Page<Weight> weights = weightRepository.findAll(pageable);
        PagedResources<Weight> pr = assembler.toResource(weights,linkTo(methodOn(WeightsApiController.class).getAllWeights(pageable, assembler)).withSelfRel());
        return new ResponseEntity (pr, HttpStatus.OK);
    }

}
