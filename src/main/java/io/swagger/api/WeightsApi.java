package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.Weight;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "weights", description = "the weights API")
public interface WeightsApi {

    @ApiOperation(value = "Get all weights", nickname = "getAllWeights", notes = "Returns all weights in database ", response = Weight.class, responseContainer = "List", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "search results matching criteria", response = Weight.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/weights",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<PagedResources<Weight>> getAllWeights(Pageable pageable, PagedResourcesAssembler assembler);

}
