package com.kgisl.VotingManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.VotingManagement.Model.Polling;
@Repository
public interface PollingRepository extends JpaRepository<Polling,String> {
    
}
