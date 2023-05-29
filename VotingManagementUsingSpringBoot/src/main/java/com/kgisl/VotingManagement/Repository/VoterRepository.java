package com.kgisl.VotingManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.VotingManagement.Model.Voter;

@Repository
public interface VoterRepository extends JpaRepository<Voter,String> {
    Voter findByEmailAndPassword(String email, String password);
}
