package com.ovs.serviceIF;

public interface VoteSrv {
    void castVote(int electionId, int userId, int candidateId);
    boolean hasUserVotedInElection(int electionId, int userId);
}
