package com.ovs.controller;

import com.ovs.model.Candidate;
import com.ovs.model.Election;
import com.ovs.model.VoteRequest;
import com.ovs.service.CandidateIMPL;
import com.ovs.service.ElectionIMPL;
import com.ovs.service.VoteIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ballot")
public class BallotController {
    @Autowired
    private ElectionIMPL electionService;

    @Autowired
    private CandidateIMPL candidateService;

    @Autowired
    private VoteIMPL voteService;

    @PostMapping("/elections")
    public ResponseEntity<?> createElection(@RequestBody Election election) {
        Election createdElection = electionService.createElection(election);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdElection);
    }

    @PutMapping("/elections/{id}")
    public ResponseEntity<?> updateElection(@PathVariable("id") int electionId, @RequestBody Election election) {
        Election updatedElection = electionService.updateElection(electionId, election);
        return ResponseEntity.ok(updatedElection);
    }

    @DeleteMapping("/elections/{id}")
    public ResponseEntity<?> deleteElection(@PathVariable("id") int electionId) {
        electionService.deleteElection(electionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/elections/{id}")
    public ResponseEntity<?> getElectionById(@PathVariable("id") int electionId) {
        Election election = electionService.getElectionById(electionId);
        return ResponseEntity.ok(election);
    }

    @GetMapping("/elections")
    public ResponseEntity<?> getAllElections() {
        List<Election> elections = electionService.getAllElections();
        return ResponseEntity.ok(elections);
    }

    @PostMapping("/candidates")
    public ResponseEntity<?> createCandidate(@RequestBody Candidate candidate) {
        Candidate createdCandidate = candidateService.createCandidate(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCandidate);
    }

    @PutMapping("/candidates/{id}")
    public ResponseEntity<?> updateCandidate(@PathVariable("id") int candidateId, @RequestBody Candidate candidate) {
        Candidate updatedCandidate = candidateService.updateCandidate(candidateId, candidate);
        return ResponseEntity.ok(updatedCandidate);
    }

    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable("id") int candidateId) {
        candidateService.deleteCandidate(candidateId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/candidates/{id}")
    public ResponseEntity<?> getCandidateById(@PathVariable("id") int candidateId) {
        Candidate candidate = candidateService.getCandidateById(candidateId);
        return ResponseEntity.ok(candidate);
    }

    @GetMapping("/candidates")
    public ResponseEntity<?> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }

    // Example: Cast a Vote in an Active Election
    @PostMapping("/vote/{electionId}")
    public ResponseEntity<?> castVote(
            @PathVariable("electionId") int electionId,
            @RequestBody VoteRequest voteRequest) {

        try {
            // Check if the user is authenticated (you can use Spring Security for this)
            // You can also check if the user is authorized to vote in this specific election
            // Ensure that voteRequest contains valid user and candidate IDs

            // Implement vote casting logic, including validation
            voteService.castVote(electionId, voteRequest.getUserId(), voteRequest.getCandidateId());

            return ResponseEntity.ok("Vote cast successfully");
//        } catch (BadCredentialsException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized access.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions that may occur during vote casting
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to cast the vote.");
        }
    }

    // Example: Get All Active Elections
    @GetMapping("/active-elections")
    public ResponseEntity<?> getActiveElections() {
        List<Election> activeElections = electionService.getActiveElections();
        return ResponseEntity.ok(activeElections);
    }

    // Example: Get Details of an Active Election
    @GetMapping("/active-elections/{id}")
    public ResponseEntity<?> getActiveElectionDetails(@PathVariable("id") int electionId) {
        Election election = electionService.getActiveElectionDetails(electionId);
        return ResponseEntity.ok(election);
    }


}

