/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moddb.pf_apiuser.pf_apiuser.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 *
 * @author daniel.sanchez
 */
class PasswordSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(final String input, final JsonGenerator jsonGenerator,
            final SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(input.toCharArray(), 0, input.toCharArray().length);
    }

    @Override
    public Class<String> handledType() {
        return String.class;
    }
}
