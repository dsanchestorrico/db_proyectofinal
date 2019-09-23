/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.pf_apiuser.pf_apiuser.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author daniel.sanchez
 */
public class Usuario implements Serializable {

    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private String nickname;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Double cantidadKudos;

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the cantidadKudos
     */
    public Double getCantidadKudos() {
        return cantidadKudos;
    }

    /**
     * @param cantidadKudos the cantidadKudos to set
     */
    public void setCantidadKudos(Double cantidadKudos) {
        this.cantidadKudos = cantidadKudos;
    }

}
