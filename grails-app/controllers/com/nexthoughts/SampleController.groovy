package com.nexthoughts

import io.swagger.annotations.ApiOperation
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces

@Path("/sample")
@Produces(["application/json", "application/xml"])
class SampleController {

    static responseFormats = ['json', 'xml']

    @GET
    @Path("/securedWithClientOAuth")
    @ApiOperation(value = "Secured Access Using client tokens", httpMethod = "GET")
    def securedWithClientOAuth() {
        def map = ['sucsess': 'AuthenticationSucces', 'message': 'Client is authenticated successfully']
        respond map
    }

    @GET
    @Path("/securedWithUserOAuth")
    @ApiOperation(value = "Secured access using user token", httpMethod = "GET")
    def securedWithUserOAuth() {
        def map = ['sucsess': 'AuthenticationSucces', 'message': 'User is authenticated successfully']
        respond map
    }
}