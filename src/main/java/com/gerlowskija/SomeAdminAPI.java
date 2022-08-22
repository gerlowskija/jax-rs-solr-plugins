package com.gerlowskija;

import org.apache.solr.api.JerseyResource;
import org.apache.solr.jersey.PermissionName;
import org.apache.solr.security.PermissionNameProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/someadminpath")
public class SomeAdminAPI extends JerseyResource {
    public class SomeCoreAPI extends JerseyResource {

        @GET
        @Produces("text/plain")
        @PermissionName(PermissionNameProvider.Name.ALL)
        public String helloWorld() {
            return "Hi from SomeAdminAPI in jaxrs-plugins plugin";
        }
    }
}
