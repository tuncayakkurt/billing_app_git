package com.blg.client.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;

public class KafkaValueSerializer<T> implements Serializer<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(T object, OutputStream outputStream) throws IOException {

    }

    @Override
    public byte[] serializeToByteArray(T object) throws IOException {
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
