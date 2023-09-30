package com.ovs.serviceIF;

import com.ovs.model.Candidate;

import java.util.Map;

public interface VoteCountingSrv {
    Map<Candidate, Long> countVotesForElection(Long electionId);
}
