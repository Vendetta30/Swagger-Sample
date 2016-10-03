// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require lib/object-assign-pollyfill
//= require lib/jquery-1.8.0.min.js
//= require lib/jquery.slideto.min.js
//= require lib/jquery.wiggle.min.js
//= require lib/jquery.ba-bbq.min.js
//= require lib/handlebars-4.0.5.js
//= require lib/lodash.min.js
//= require lib/backbone-min.js
//= require swagger-ui.js
//= require lib/highlight.9.1.0.pack.js
//= require lib/highlight.9.1.0.pack_extended.js
//= require lib/jsoneditor.min.js
//= require lib/marked.js
//= require lib/swagger-oauth.js
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}