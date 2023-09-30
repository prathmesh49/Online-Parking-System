package com.ovs.controller;

import com.ovs.model.Candidate;
import com.ovs.service.VoteCountIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteCountIMPL voteService;

    @GetMapping("/count/{electionId}")
    public ResponseEntity<?> countVotes(@PathVariable Integer electionId) {
        // Call the vote counting service to tally votes for the specified election
        // You can implement this logic in the VoteService
        Map<Candidate, Long> totalVotes = voteService.countVotesForElection(Long.valueOf(electionId));

        // Return the total vote count as a response
        return ResponseEntity.ok(totalVotes);
    }
}

