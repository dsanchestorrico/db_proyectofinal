/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.pf_apiuser.pf_apiuser;

import com.moddb.pf_apiuser.pf_apiuser.conf.UsuarioConfiguration;
import com.moddb.pf_apiuser.pf_apiuser.model.MongoDBFactoryConnection;
import com.moddb.pf_apiuser.pf_apiuser.model.MongoDBManaged;
import com.moddb.pf_apiuser.pf_apiuser.model.UsuarioDAO;
import com.moddb.pf_apiuser.pf_apiuser.resource.UsuarioResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author daniel.sanchez
 */
public class UsuarioService extends Application<UsuarioConfiguration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    public static void main(final String[] args) throws Exception {
        LOGGER.info("Start application.");
        new UsuarioService().run(args);
    }

    @Override
    public void run(final UsuarioConfiguration t, final Environment e) throws Exception {
        final MongoDBFactoryConnection mongoDBManagerConn = new MongoDBFactoryConnection(t.getMongoDBConnection());

        final MongoDBManaged mongoDBManaged = new MongoDBManaged(mongoDBManagerConn.getClient());

        final UsuarioDAO usuarioDAO = new UsuarioDAO(mongoDBManagerConn.getClient()
                .getDatabase(t.getMongoDBConnection().getDatabase())
                .getCollection("usuarios"));

        e.lifecycle().manage(mongoDBManaged);
        e.jersey().register(new UsuarioResource(usuarioDAO));
    }
}
