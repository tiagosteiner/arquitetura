package com.study.event.sourcing.domain.event;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class CreateProposalEvent {

    @TargetAggregateIdentifier
    private final String proposalId;

    public CreateProposalEvent(String proposalId) {
        this.proposalId = proposalId;
    }

    public String getProposalId() {
        return proposalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CreateProposalEvent that = (CreateProposalEvent) o;
        return Objects.equals(proposalId, that.proposalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proposalId);
    }

    @Override
    public String toString() {
        return "CreateProposalEvent{" + "proposalId='" + proposalId + '\'' + '}';
    }
}
