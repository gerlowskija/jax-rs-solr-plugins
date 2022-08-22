package com.gerlowskija;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.solr.api.Api;
import org.apache.solr.api.JerseyResource;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.handler.RequestHandlerBase;
import org.apache.solr.handler.StandardRequestHandler;
import org.apache.solr.handler.component.SearchHandler;
import org.apache.solr.request.LocalSolrQueryRequest;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.request.SolrRequestInfo;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.security.AuthorizationContext;

public class SomeCoreRequestHandler extends RequestHandlerBase {


  @Override
  public void init(NamedList args) {
    super.init(args);
    System.out.println("Putting patterns into the list from the init()");
  }

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
    jerseyApis.add(SomeCoreAPI.class);
    return jerseyApis;
  }

}
