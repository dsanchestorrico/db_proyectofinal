package com.moddb.pf_apistats.pf_apistats;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import com.moddb.pf_apistats.pf_apistats.conf.HelloWorldConfiguration;
import com.moddb.pf_apistats.pf_apistats.health.TemplateHealthCheck;
import com.moddb.pf_apistats.pf_apistats.model.Suscriber;
import com.moddb.pf_apistats.pf_apistats.resource.HelloWorldResource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

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
                    Environment environment) throws IOException, TimeoutException {

        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.healthChecks().register("example health check", new TemplateHealthCheck(template));
        environment.jersey().register(new HelloWorldResource(template, defaultName));
        
        Suscriber suscriber = new Suscriber();
        suscriber.suscribeAddKudoQty();
    }

}
