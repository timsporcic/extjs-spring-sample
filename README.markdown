# ExtJS - Spring Sample

This application demonstrates wiring [*ExtJS*](http://www.sencha.com/products/js/)
in to the [*Spring 3 Framework*](http://springsource.org) using Spring MVC with
JSON serialization and deserialization of objects.

The ContactController is a fully-RESTful Spring MVC controller which is wired in to a Ext.data.JsonStore
with writers configured to send updates to the store as JSON data.

See [my blog](http://www.sporcic.org/2010/11/more-extjs-and-spring/) for more details.