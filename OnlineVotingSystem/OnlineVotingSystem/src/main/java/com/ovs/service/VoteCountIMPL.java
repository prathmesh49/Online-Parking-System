package com.ovs.service;

import com.ovs.model.Candidate;
import com.ovs.model.Vote;
import com.ovs.repository.CandidateRepository;
import com.ovs.repository.VoteRepository;
import com.ovs.serviceIF.VoteCountingSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class VoteCountIMPL implements VoteCountingSrv {
    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Map<Candidate, Long> countVotesForElection(Long electionId) {
        List<Vote> electionVotes = voteRepository.findByElectionId(electionId);

        // Group votes by candidate
        Map<Candidate, Long> voteCounts = new ConcurrentHashMap<>();
        List<Candidate> candidates = candidateRepository.findByElectionId(electionId);

        // Initialize vote counts for each candidate
        for (Candidate candidate : candidates) {
            voteCounts.put(candidate, 0L);
        }

        // Perform vote counting in parallel using Java streams
        electionVotes.parallelStream().forEach(vote -> {
            Candidate candidate = vote.getCandidate();
            voteCounts.merge(candidate, 1L, Long::sum);
        });

        return voteCounts;
    }
}
