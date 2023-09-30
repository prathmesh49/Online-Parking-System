package com.ovs.serviceIF;

import com.ovs.model.Candidate;

import java.util.List;

public interface CandidateSrv {
    Candidate createCandidate(Candidate candidate);

    Candidate updateCandidate(int candidateId, Candidate candidate) ;

    void deleteCandidate(int candidateId) ;

    Candidate getCandidateById(int candidateId) ;

    List<Candidate> getAllCandidates() ;
}
