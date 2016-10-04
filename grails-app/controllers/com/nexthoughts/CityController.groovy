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
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.bind.annotation.RestController

import javax.ws.rs.Consumes
import javax.ws.rs.DELETE
import javax.ws.rs.FormParam
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

//            @ApiImplicitParam(name = 'q', value = 'Query', paramType = 'query', dataType = 'string')

@Path("/city")
@Api(value = "city", description = "Access City Records")
@Produces(["application/json", "application/xml"])
class CityController extends RestfulController {
    static responseFormats = ['json', 'xml']

    CityController() {
        super(City)
    }

    @GET
    @Path("/")
    @ApiOperation(value = "Get all your city details", httpMethod = "GET", response = City)
    def index() {
        respond City.list(params)
    }

    @GET
    @Path("/show/{id}")
    @ApiOperation(value = "Select a City", httpMethod = "GET", response = City)
    def show(@ApiParam(value = "ID of city that needs to be select", required = true) @PathParam("id") Long id) {
        def cityInstance = City.findById(id)
        if (!cityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), id])
            redirect(action: "index")
            return
        }
        respond cityInstance
    }

    @DELETE
    @Path("/delete/{id}")
    @ApiOperation(value = "Delete a city", httpMethod = "DELETE", response = City)
    @ApiResponses(value = [@ApiResponse(code = 422, message = "Invalid Id Supplied"),
            @ApiResponse(code = 404, message = "City Not Found")])
    def delete(
            @ApiParam(value = "City Id to delete", required = true) @PathParam("id") Long id
    ) {
        def cityInstance = City.get(id)
        if (!cityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), id])
            respond([message: "Not Found"])
            return
        }

        try {
            cityInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'city.label', default: 'City'), id])
            respond([message: "City ${id} has been succesfully deleted"])
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'city.label', default: 'City'), id])
            respond([message: "Internal Server Error"])
        }
    }

    @POST
    @Path("/save")
    @ApiOperation(value = "Create a New City", response = City)
    @ApiResponses(value = [@ApiResponse(code = 422, message = "Invalid Details")])
    @ApiImplicitParams([@ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'com.nexthoughts.City')])
    @Override
    def save() {
        super.save()
    }

    @PATCH
    @Path("/update/{id}")
    @ApiOperation(value = "Update a city", response = City)
    @ApiResponses([
            @ApiResponse(code = 400, message = "Bad Id Provided"),
            @ApiResponse(code = 404, message = 'Could not find City with that Id'),
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'com.nexthoughts.City')
    ])
    def Object update(
            @ApiParam(value = "City Id to Update", required = true) @PathParam("id") Long id
    ) {
        super.update()
    }

    @GET
    @Path("/list")
    @ApiOperation(value = 'List demos', response = City, responseContainer = 'list')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'offset', value = 'Records to skip', defaultValue = '0', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'max', value = 'Max records to return', defaultValue = '10', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'sort', value = 'Field to sort by', defaultValue = 'id', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'order', value = 'Order to sort by', defaultValue = 'asc', paramType = 'query', dataType = 'string'),
    ])
    def list() {
        super.index()
    }
}