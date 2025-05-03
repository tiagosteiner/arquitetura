package com.study.event.sourcing.domain.aggregate;

import com.study.event.sourcing.command.ClientDataAddCommand;
import com.study.event.sourcing.command.CreateProposalCommand;
import com.study.event.sourcing.domain.event.ClientDataAddedEvent;
import com.study.event.sourcing.domain.event.CreateProposalEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate(snapshotTriggerDefinition = "proposalAggregateSnapshotTriggerDefinition")
public class ProposalAggregate {

    @AggregateIdentifier
    private String proposalId;

    private String state;

    private String name;

    private String age;

    protected ProposalAggregate(){
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

    @EventSourcingHandler
    public void on(CreateProposalEvent event) {
        this.proposalId = event.getProposalId();
        this.state = "created";
        this.name = "";
        this.age = "";
    }

    @CommandHandler
    public ProposalAggregate(CreateProposalCommand createProposalCommand){
        UUID id = UUID.randomUUID();
        AggregateLifecycle.apply(new CreateProposalEvent(id.toString()));
    }

    @EventSourcingHandler
    public void on(ClientDataAddedEvent event) {
        this.state = "changed";
        this.name = event.getName();
        this.age = event.getAge();
    }

    @CommandHandler
    public void handle(ClientDataAddCommand command) {
        String name = command.getName();
        String age = command.getAge();
        apply(new ClientDataAddedEvent(proposalId, name, age));
    }
}
