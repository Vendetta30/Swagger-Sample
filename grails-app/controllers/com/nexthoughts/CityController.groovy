package com.nexthoughts

import grails.rest.RestfulController
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
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

@Path("/city")
@Api(value = "/city", description = "Access City Records")
@Produces(["application/json", "application/xml"])
class CityController {
    static responseFormats = ['json', 'xml']

    @GET
    @Path("/")
    @ApiOperation(value = "Get all your city details", httpMethod = "GET")
    def index() {
        respond City.list(params)
    }

    /*@POST
    @Consumes([MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML])
    @ApiOperation(value = "Save a city")
    @ApiResponses(value = [@ApiResponse(code = 405, message = "Invalid Input")])
    def save(@ApiParam(value = "City Name", required = true) City city) {
        def cityInstance = city
        if (!cityInstance.save(flush: true)) {
            render(view: "create", model: [cityInstance: cityInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'city.label', default: 'City'), cityInstance.id])
        redirect(action: "show", id: cityInstance.id)
    }*/

    /*@POST
    @Path("/save")
    @Consumes([MediaType.APPLICATION_FORM_URLENCODED])
    @ApiOperation(value = "Save a city", consumes = MediaType.APPLICATION_FORM_URLENCODED)
    @ApiResponses(value = [@ApiResponse(code = 405, message = "Invalid Input")])
    def save(
            @ApiParam(value = "City Name", required = true) @FormParam("cityName") String cityName,
            @ApiParam(value = "Postal Code", required = true) @FormParam("postalCode") String postalCode,
            @ApiParam(value = "Country Code", required = true) @FormParam("countryCode") String countryCode
    ) {
        def params = [cityName: cityName, postalCode: postalCode, countryCode: countryCode]
        def cityInstance = new City(params)
        if (!cityInstance.save(flush: true)) {
            render(view: "create", model: [cityInstance: cityInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'city.label', default: 'City'), cityInstance.id])
        redirect(action: "show", id: cityInstance.id)
    }*/

    @GET
    @Path("/show/{id}")
    @ApiOperation(value = "Select a City", httpMethod = "GET")
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
    @ApiOperation(value = "Delete a city", httpMethod = "DELETE")
    @ApiResponses(value = [@ApiResponse(code = 404, message = "Invalid Id Supplied"),
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

    /*@PUT
    @Path("/update/{id}")
    @ApiOperation(value = "Update a city", httpMethod = "PUT")
    def update(@ApiParam(value = "ID of city that needs to be update", required = true) @PathParam("id") Long id) {
        def cityInstance = City.get(id)
        if (!cityInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'city.label', default: 'City'), id])
            redirect(action: "index")
            return
        }

        cityInstance.properties = params
        if (!cityInstance.save(flush: true)) {
            render(view: "edit", model: [cityInstance: cityInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'city.label', default: 'City'), cityInstance.id])
        respond cityInstance
    }

    */
}
