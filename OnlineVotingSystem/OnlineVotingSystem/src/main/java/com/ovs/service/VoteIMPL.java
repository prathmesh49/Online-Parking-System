package com.ovs.service;

import com.ovs.model.Candidate;
import com.ovs.model.Election;
import com.ovs.model.Vote;
import com.ovs.repository.VoteRepository;
import com.ovs.serviceIF.CandidateSrv;
import com.ovs.serviceIF.ElectionSrv;
import com.ovs.serviceIF.VoteSrv;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VoteIMPL implements VoteSrv {
    @Autowired
    private ElectionSrv electionService;

    @Autowired
    private UserIMPL userService;

    @Autowired
    private CandidateSrv candidateService;

    @Autowired
    private VoteRepository voteRepository;

    @Override
    @Transactional
    public void castVote(int electionId, int userId, int candidateId) {
        try {
            // Check if the user has already voted in the same election
            if (hasUserVotedInElection(electionId, userId)) {
                throw new IllegalStateException("User has already voted in this election.");
            }

            // Ensure the election and candidate exist
            Election election = electionService.getElectionById(electionId);
            Candidate candidate = candidateService.getCandidateById(candidateId);

            // Create a new vote and set its properties
            Vote vote = new Vote();
            vote.setElection(election);
            vote.setUser(userService.getUserById(userId));
            vote.setCandidate(candidate);

            // Save the vote information to the database
            voteRepository.save(vote);

            // Log the vote-casting event
            log.info("User with ID {} cast a vote for candidate with ID {} in election with ID {}.", userId, candidateId, electionId);
        } catch (EntityNotFoundException ex) {
            // Handle the case where the election or candidate doesn't exist
            throw new IllegalArgumentException("Invalid election or candidate.");
        } catch (Exception ex) {
            // Handle other exceptions that may occur during vote casting
            throw new RuntimeException("Failed to cast the vote.", ex);
        }
    }

    @Override
    public boolean hasUserVotedInElection(int electionId, int userId) {
        return voteRepository.existsByElectionIdAndUserId(electionId, userId);
    }

}
