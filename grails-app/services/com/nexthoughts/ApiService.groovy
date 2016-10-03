package com.nexthoughts

import io.swagger.jaxrs.config.BeanConfig
import io.swagger.util.Json;

class ApiService {

    BeanConfig swaggerConfig

    def generateJSON() {
        String[] schemes = ["http"] as String[]
        swaggerConfig.setSchemes(schemes)
        swaggerConfig.setScan(true)
        def swagger = swaggerConfig.getSwagger()
        Json.mapper().writeValueAsString(swagger);
    }
}
