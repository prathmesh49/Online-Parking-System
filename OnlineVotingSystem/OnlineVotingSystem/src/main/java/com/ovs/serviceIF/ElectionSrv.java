package com.ovs.serviceIF;

import com.ovs.model.Election;

import java.util.List;

public interface ElectionSrv {
    Election createElection(Election election) ;

    Election updateElection(int electionId, Election election) ;

    void deleteElection(int electionId) ;

    Election getElectionById(int electionId);

    List<Election> getAllElections();

    List<Election> getActiveElections();

    Election getActiveElectionDetails(int electionId);
}
