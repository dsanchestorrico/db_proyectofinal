package com.moddb.pf_apiuser.pf_apiuser;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.moddb.pf_apiuser.pf_apiuser.conf.HelloWorldConfiguration;
import com.moddb.pf_apiuser.pf_apiuser.health.TemplateHealthCheck;
import com.moddb.pf_apiuser.pf_apiuser.resource.HelloWorldResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pnajda
 */
public class HelloWorldService extends Application<HelloWorldConfiguration> {

    public static void main(String args[]) throws Exception {
        new HelloWorldService().run(args);
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {

        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.healthChecks().register("example health check", new TemplateHealthCheck(template));
        environment.jersey().register(new HelloWorldResource(template, defaultName));
    }

}
