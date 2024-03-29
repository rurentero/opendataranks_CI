/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.5).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Organization;
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
@Api(value = "organizations", description = "the organizations API")
public interface OrganizationsApi {

    @ApiOperation(value = "Get all organizations", nickname = "getAllOrganizations", notes = "Returns all organizations in database ", response = Organization.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Organization.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/organizations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Organization>> getAllOrganizations(Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Find by name", nickname = "getAllOrganizationsByName", notes = "Returns all organizations in database that matchs a name ", response = Reuse.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Reuse.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/organizations/findByName",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Organization>> getAllOrganizationsByName(@NotNull @ApiParam(value = "name of the record to search", required = true) @Valid @RequestParam(value = "name", required = true) String name,Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Find by tags", nickname = "getAllOrganizationsByTags", notes = "Returns all organizations in database that matchs a list of tags ", response = Organization.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Organization.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/organizations/findByTags",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<PagedResources<Organization>> getAllOrganizationsByTags(@NotNull @ApiParam(value = "tags used in the search", required = true) @Valid @RequestParam(value = "tags", required = true) List<String> tags, Pageable pageable, PagedResourcesAssembler assembler);


    @ApiOperation(value = "Get organization by id", nickname = "getOrganizationById", notes = "Returns an specific organization ", response = Organization.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Organization.class),
        @ApiResponse(code = 400, message = "bad input parameter"),
        @ApiResponse(code = 404, message = "resource not found") })
    @RequestMapping(value = "/organizations/{organizationId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Organization> getOrganizationById(@ApiParam(value = "pass the organization id to return its properties",required=true) @PathVariable("organizationId") String organizationId);

}
