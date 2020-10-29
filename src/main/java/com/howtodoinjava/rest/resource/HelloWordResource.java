package com.howtodoinjava.rest.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.rest.dao.Geolocation;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.internal.ClientResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/test/{name}")
public class HelloWordResource {

    Client client = ClientBuilder.newBuilder().build();
    public HelloWordResource() {

    }

/*    @GET
    public String getName(@PathParam("name") String name) throws IOException {
        updateGeoLocation("24.48.0.1");
    return "Hello " + name;
    }*/

    @GET
    public Geolocation updateGeoLocation(String id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://ip-api.com/json/24.48.0.1");
        Geolocation geolocation = new Geolocation();

        try{
            Response response = target.request().get();
            String test = ((ClientResponse) response).readEntity(String.class);
            geolocation = objectMapper.readValue(test, Geolocation.class);
        }catch (Exception e){
            System.out.println("######" + e.getMessage());
        }

        return geolocation;
    }
}
