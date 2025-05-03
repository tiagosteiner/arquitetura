package com.study.event.sourcing.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;

@Configuration
public class SerializerConfiguration {

    // By default, we want the XStreamSerializer
    // @Bean
    // public Serializer defaultSerializer() {
    //     // Set the secure types on the xStream instance
    //     XStream xStream = new XStream();
    //     return XStreamSerializer.builder().xStream(xStream).build();
    // }

    // But for all our messages we'd prefer the JacksonSerializer due to JSON's smaller format
    @Bean
    @Qualifier("messageSerializer")
    public Serializer messageSerializer() {
        return JacksonSerializer.defaultSerializer();
    }
}
