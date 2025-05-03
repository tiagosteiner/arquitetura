package com.study.event.sourcing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnapshotConfiguration {
    @Bean
    public SnapshotTriggerDefinition orderAggregateSnapshotTriggerDefinition(
            Snapshotter snapshotter,
            @Value("${axon.aggregate.order.snapshot-threshold:250}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }
}
