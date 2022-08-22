package com.gerlowskija;

import org.apache.solr.api.Api;
import org.apache.solr.api.JerseyResource;
import org.apache.solr.handler.RequestHandlerBase;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.security.AuthorizationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SomeAdminRequestHandler extends RequestHandlerBase {
    public static String VERSION = "1.0";
    @Override
    public void handleRequestBody(SolrQueryRequest req, SolrQueryResponse rsp) throws Exception {

    }

    @Override
    public String getDescription() {
        return "Simple Request handler that allows registration of JAX-RS v2 APIs";
    }

    @Override
    public Name getPermissionName(AuthorizationContext authorizationContext) {
        return Name.ALL;
    }

    @Override
    public Boolean registerV2() {
        return Boolean.TRUE;
    }

    @Override
    public Collection<Api> getApis() {
        return Collections.emptyList();
    }

    public Collection<Class<? extends JerseyResource>> getJerseyResources() {
        final List<Class<? extends  JerseyResource>> jerseyApis = new ArrayList<>();
        jerseyApis.add(SomeAdminAPI.class);
        return jerseyApis;
    }
}
