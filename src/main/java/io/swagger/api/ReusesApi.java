/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.5).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Reuse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-03-19T10:19:46.202Z[GMT]")
@Api(value = "reuses", description = "the reuses API")
public interface ReusesApi {

    @ApiOperation(value = "Get all reuses", nickname = "getAllReuses", notes = "Returns all reuses in database ", response = Reuse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Reuse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/reuses",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Reuse>> getAllReuses(@RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Find by name", nickname = "getAllReusesByName", notes = "Returns all reuses in database that matchs a name ", response = Reuse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Reuse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/reuses/findByName",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Reuse>> getAllReusesByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Find by organization", nickname = "getAllReusesByOrganization", notes = "Returns all reuses in database that matchs an organization ", response = Reuse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Reuse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/reuses/findByOrganization",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Reuse>> getAllReusesByOrganization(@NotNull @ApiParam(value = "name of the organization", required = true) @Valid @RequestParam(value = "name", required = true) String name, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Find by tags", nickname = "getAllReusesByTags", notes = "Returns all reuses in database that matchs a list of tags ", response = Reuse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Reuse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/reuses/findByTags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Reuse>> getAllReusesByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags, @RequestParam(defaultValue = "W1") String rankingId, @RequestParam(defaultValue = "false") Boolean inverted, Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Get reuse by id", nickname = "getReuseById", notes = "Returns an specific dataset ", response = Reuse.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Reuse.class),
        @ApiResponse(code = 400, message = "bad input parameter"),
        @ApiResponse(code = 404, message = "resource not found") })
    @RequestMapping(value = "/reuses/{reuseId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Reuse> getReuseById(@ApiParam(value = "pass the reuse id to return its properties",required=true) @PathVariable("reuseId") String reuseId);

}
