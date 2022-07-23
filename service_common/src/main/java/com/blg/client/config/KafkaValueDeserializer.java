package com.blg.client.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;

public class KafkaValueDeserializer<T> implements Deserializer<T> {
    final Class<T> typeParameterClass;

    public KafkaValueDeserializer(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public T deserialize(InputStream inputStream) throws IOException {
        return null;
    }

    @Override
    public T deserializeFromByteArray(byte[] serialized) throws IOException {
        try {
            return objectMapper.readValue(new String(serialized, "UTF-8"), typeParameterClass);
        } catch (Exception e) {
            return null;
        }
    }
}
