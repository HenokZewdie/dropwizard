package com.howtodoinjava.rest.service;

import com.howtodoinjava.rest.config.SampleConfig;
import com.howtodoinjava.rest.resource.HelloWordResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class SampleService extends Service<SampleConfig>{
    public static void main(String[] args) throws Exception {
        new SampleService().run(args);
    }

    @Override
    public void initialize(Bootstrap<SampleConfig> bootstrap) {

    }

    @Override
    public void run(SampleConfig sampleConfig, Environment environment) throws Exception {
        environment.addResource(new HelloWordResource());
    }
}
