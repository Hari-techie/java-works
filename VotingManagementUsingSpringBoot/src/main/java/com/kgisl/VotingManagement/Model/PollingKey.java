package com.kgisl.VotingManagement.Model;

import java.io.Serializable;

public class PollingKey implements Serializable {
    private String voter_id;
    private String election_name;

    public String getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(String voter_id) {
        this.voter_id = voter_id;
    }

    public String getElection_name() {
        return election_name;
    }

    public void setElection_name(String election_name) {
        this.election_name = election_name;
    }

    @Override
    public String toString() {
        return "PollingKey [voter_id=" + voter_id + ", election_name=" + election_name + "]";
    }

    // Constructors, getters, setters, and equals/hashCode methods
}
