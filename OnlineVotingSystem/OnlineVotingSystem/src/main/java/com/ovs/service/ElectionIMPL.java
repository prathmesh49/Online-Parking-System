package com.ovs.service;

import com.ovs.model.Election;
import com.ovs.repository.ElectionRepository;
import com.ovs.serviceIF.ElectionSrv;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionIMPL implements ElectionSrv {
    @Autowired
    private ElectionRepository electionRepository;

    @Override
    public Election createElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public Election updateElection(int electionId, Election election) {
        return electionRepository.save(election);
    }

    @Override
    public void deleteElection(int electionId) {
        electionRepository.deleteById(electionId);
    }

    @Override
    public Election getElectionById(int electionId) {
        return electionRepository.findById(electionId)
                .orElseThrow(() -> new EntityNotFoundException("Election not found"));
    }

    @Override
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @Override
    public List<Election> getActiveElections() {
        return electionRepository.findByIsActiveTrue();
    }

    @Override
    public Election getActiveElectionDetails() {
        return null;
    }
}
