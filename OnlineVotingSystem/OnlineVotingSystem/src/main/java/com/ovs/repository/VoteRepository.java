package com.ovs.repository;

import com.ovs.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    boolean existsByElectionIdAndUserId(int electionId, int userId);

    List<Vote> findByElectionId(Long electionId);
}
