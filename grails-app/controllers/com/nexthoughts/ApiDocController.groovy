package com.nexthoughts

import org.codehaus.groovy.grails.web.mapping.LinkGenerator

class ApiDocController {
    LinkGenerator grailsLinkGenerator
    def apiService
    def index = {
        String basePath = grailsLinkGenerator.serverBaseURL
        render(view: '/index')
    }

    def swaggerJson = {
        render apiService.generateJSON()
    }
}