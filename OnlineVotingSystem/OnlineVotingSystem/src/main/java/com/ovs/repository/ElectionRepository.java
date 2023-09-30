package com.ovs.repository;

import com.ovs.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {
    List<Election> findByIsActiveTrue();
    Optional<Election> findByIdAndIsActiveTrue(int electionId);
}
