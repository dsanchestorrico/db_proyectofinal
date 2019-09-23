/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.pf_apiuser.pf_apiuser.model;

import org.bson.Document;

/**
 *
 * @author daniel.sanchez
 */
class UsuarioMapper {
    public static Usuario map(final Document usuarioDocument) {
        final Usuario usuario = new Usuario();
        usuario.setId(usuarioDocument.getObjectId("_id"));
        usuario.setNickname(usuarioDocument.getString("nickname"));
        usuario.setNombre(usuarioDocument.getString("nombre"));
        usuario.setApellidoPaterno(usuarioDocument.getString("apellido_paterno"));
        usuario.setApellidoMaterno(usuarioDocument.getString("apellido_materno"));
        usuario.setCantidadKudos(usuarioDocument.getDouble("cantidad_kudos"));
        return usuario;
    }
}
