<!DOCTYPE html>
<html>
<head>
    <title>Swagger UI</title>
    <link href='https://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'/>
    <link href='${resource(dir: 'css', file: 'typography.css')}' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${resource(dir: 'css', file: 'reset.css')}' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${resource(dir: 'css', file: 'screen.css')}' media='screen' rel='stylesheet' type='text/css'/>
    <link href='${resource(dir: 'css', file: 'reset.css')}' media='print' rel='stylesheet' type='text/css'/>
    <link href='${resource(dir: 'css', file: 'print.css')}' media='print' rel='stylesheet' type='text/css'/>
    <script src='${resource(dir: 'js/lib', file: 'object-assign-pollyfill.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'jquery-1.8.0.min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'jquery.slideto.min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'jquery.wiggle.min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'jquery.ba-bbq.min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'handlebars-4.0.5.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'lodash.min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'backbone-min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js', file: 'swagger-ui.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'highlight.9.1.0.pack.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'highlight.9.1.0.pack_extended.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'jsoneditor.min.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'marked.js')}' type='text/javascript'></script>
    <script src='${resource(dir: 'js/lib', file: 'swagger-oauth.js')}' type='text/javascript'></script>

    <script type="text/javascript">
        $(function () {
            var url = "${createLink(controller: 'apiDoc', action: 'swaggerJson', absolute: true)}";
            if (!url) {
                url = "http://petstore.swagger.io/v2/swagger.json";
            }

            hljs.configure({
                highlightSizeThreshold: 5000
            });

            // Pre load translate...
            if (window.SwaggerTranslator) {
                window.SwaggerTranslator.translate();
            }
            window.swaggerUi = new SwaggerUi({
                url: url,
                dom_id: "swagger-ui-container",
                supportedSubmitMethods: ['get', 'post', 'put', 'delete', 'patch'],
                onComplete: function (swaggerApi, swaggerUi) {
                    if (typeof initOAuth == "function") {
//                        initOAuth({
//                            clientId: "your-client-id",
//                            clientSecret: "your-client-secret-if-required",
//                            realm: "your-realms",
//                            appName: "your-app-name",
//                            scopeSeparator: " ",
//                            additionalQueryStringParams: {}
//                        });
                    }

                    if (window.SwaggerTranslator) {
                        window.SwaggerTranslator.translate();
                    }
                },
                onFailure: function (data) {
                    log("Unable to Load SwaggerUI");
                },
                docExpansion: "none",
                jsonEditor: false,
                defaultModelRendering: 'schema',
                showRequestHeaders: false
            });

            window.swaggerUi.load();

            function log() {
                if ('console' in window) {
                    console.log.apply(console, arguments);
                }
            }
        });
    </script>
</head>

<body class="swagger-section">
<div id='header'>
    <div class="swagger-ui-wrap">
        <a id="logo" href="http://swagger.io">swagger</a>

        <form id='api_selector'>
            <div class='input'><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl"
                                      type="text"/></div>

            <div class='input'><input placeholder="api_key" id="input_apiKey" name="apiKey" type="text"/></div>

            <div class='input'><a id="explore" href="#">Explore</a></div>
        </form>
    </div>
</div>

<div id="message-bar" class="swagger-ui-wrap">&nbsp;</div>

<div id="swagger-ui-container" class="swagger-ui-wrap"></div>
</body>
</html>