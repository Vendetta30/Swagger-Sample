package com.nexthoughts

import grails.rest.RestfulController
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.jaxrs.PATCH
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces

@Path("/state")
@Api(value = "state", description = "Access State Records")
@Produces(["application/json", "application/xml"])
class StateController extends RestfulController {
    StateController() {
        super(State)
    }

    @GET
    @Path("/")
    @ApiOperation(value = 'List demos', response = State, responseContainer = 'list')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'offset', value = 'Records to skip', defaultValue = '0', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'max', value = 'Max records to return', defaultValue = '10', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'sort', value = 'Field to sort by', defaultValue = 'id', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'order', value = 'Order to sort by', defaultValue = 'asc', paramType = 'query', dataType = 'string'),
    ])
    @Override
    def index() {
        super.index()
    }

    @GET
    @Path("/show")
    @ApiOperation(value = 'List demos', response = State, responseContainer = 'list')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'show record by id', required = true, paramType = 'query', dataType = 'int')
    ])
    @Override
    def show() {
        super.show()
    }

    @DELETE
    @Path("/delete")
    @ApiOperation(value = 'List demos', response = State, responseContainer = 'list')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'show record by id', required = true, paramType = 'query', dataType = 'int')
    ])
    @Override
    def delete() {
        super.delete()
    }

    @POST
    @Path("/save")
    @ApiOperation(value = "Create a New State", response = State)
    @ApiResponses(value = [@ApiResponse(code = 422, message = "Invalid Details")])
    @ApiImplicitParams([@ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'com.nexthoughts.State')])
    @Override
    def save() {
        super.save()
    }

    @PATCH
    @Path("/update/{id}")
    @ApiOperation(value = "Update a state", response = State)
    @ApiResponses([
            @ApiResponse(code = 400, message = "Bad Id Provided"),
            @ApiResponse(code = 404, message = 'Could not find State with that Id'),
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'com.nexthoughts.State')
    ])
    def Object update(
            @ApiParam(value = "State Id to Update", required = true) @PathParam("id") Long id
    ) {
        super.update()
    }
}
