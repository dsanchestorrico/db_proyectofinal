/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.pf_apiuser.pf_apiuser.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author daniel.sanchez
 */
public class UsuarioDAO {

    final MongoCollection<Document> usuariosCollection;

    public UsuarioDAO(final MongoCollection<Document> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public List<Usuario> getAll() throws IOException, TimeoutException {
        final MongoCursor<Document> usuarios = usuariosCollection.find().iterator();
        final List<Usuario> usuarioFind = new ArrayList<>();
        try {
            while (usuarios.hasNext()) {
                final Document usuario = usuarios.next();
                usuarioFind.add(UsuarioMapper.map(usuario));
            }
        } finally {
            usuarios.close();
        }

        return usuarioFind;
    }

    public Usuario get(final ObjectId id) throws IOException, TimeoutException {
        final MongoCursor<Document> usuarios = usuariosCollection.find(new Document("_id", id)).iterator();
        final List<Usuario> usuarioFind = new ArrayList<>();
        try {
            while (usuarios.hasNext()) {
                final Document usuario = usuarios.next();
                usuarioFind.add(UsuarioMapper.map(usuario));
            }
        } finally {
            usuarios.close();
        }
        
        return usuarioFind.get(0);
    }

    public void save(final Usuario usuario) {
        Calendar calendar = Calendar.getInstance();
        final Document saveUsuario = new Document("nickname", usuario.getNickname())
                .append("nombre", usuario.getNombre())
                .append("apellido_paterno", usuario.getApellidoPaterno())
                .append("apellido_materno", usuario.getApellidoMaterno())
                .append("cantidad_kudos", usuario.getCantidadKudos());
        usuariosCollection.insertOne(saveUsuario);
    }

    public void delete(final ObjectId id) {
        usuariosCollection.deleteOne(new Document("_id", id));
    }

}
