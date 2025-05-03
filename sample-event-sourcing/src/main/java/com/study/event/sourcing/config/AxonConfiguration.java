package com.study.event.sourcing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import org.axonframework.eventhandling.tokenstore.TokenStore;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.extensions.mongo.DefaultMongoTemplate;
import org.axonframework.extensions.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.extensions.mongo.eventsourcing.tokenstore.MongoTokenStore;
import org.axonframework.metrics.GlobalMetricRegistry;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;

@Configuration
public class AxonConfiguration {
    // The Event store `EmbeddedEventStore` delegates actual storage and retrieval of events to an
    // `EventStorageEngine`.
    @Bean
    public EmbeddedEventStore eventStore(
            EventStorageEngine storageEngine, GlobalMetricRegistry metricRegistry) {
        return EmbeddedEventStore.builder()
                .storageEngine(storageEngine)
                // .messageMonitor(configuration.messageMonitor(EventStore.class, "proposalStore"))
                .messageMonitor(metricRegistry.registerEventBus("proposalStore"))
                .build();
    }

    // The `MongoEventStorageEngine` stores each event in a separate MongoDB document
    @Bean
    public EventStorageEngine storageEngine(MongoClient client) {
        return MongoEventStorageEngine.builder()
                .mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build())
                .eventSerializer(JacksonSerializer.defaultSerializer())
                .build();
    }

    @Bean
    public TokenStore getTokenStore(MongoClient client, Serializer serializer) {
        return MongoTokenStore.builder()
                .mongoTemplate(DefaultMongoTemplate.builder().mongoDatabase(client).build())
                .serializer(serializer)
                .build();
    }
}
