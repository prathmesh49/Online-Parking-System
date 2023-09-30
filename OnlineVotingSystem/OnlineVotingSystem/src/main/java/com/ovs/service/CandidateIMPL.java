package com.ovs.service;

import com.ovs.model.Candidate;
import com.ovs.repository.CandidateRepository;
import com.ovs.serviceIF.CandidateSrv;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateIMPL implements CandidateSrv {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(int candidateId, Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(int candidateId) {
        candidateRepository.deleteById(candidateId);
    }

    @Override
    public Candidate getCandidateById(int candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}
