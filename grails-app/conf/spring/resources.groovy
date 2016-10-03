import io.swagger.jaxrs.config.BeanConfig

beans = {
    swaggerConfig(BeanConfig) {
        def serverUrl = grailsApplication.config.grails.serverURL.toString()
        def hostName = serverUrl.substring(serverUrl.indexOf("://") + 3)
        println(hostName)
        resourcePackage = 'com.nexthoughts'
        host = hostName
        basePath = "/api"
        version = 'v0' // Default "1".
        title = 'Create your REST document' // Default: App Name.
        description = 'API for Accessing secured resources'
        contact = 'vijay@nexthoughts.com'
        license = ''
        licenseUrl = ''
    }
}