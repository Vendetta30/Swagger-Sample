class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'apiDoc', action: 'index')
        "/api/sample/securedWithClientOAuth"(controller: 'sample', action: 'securedWithClientOAuth')
        "/api/sample/securedWithUserOAuth"(controller: 'sample', action: 'securedWithUserOAuth')
        "500"(view: '/error')
    }
}
