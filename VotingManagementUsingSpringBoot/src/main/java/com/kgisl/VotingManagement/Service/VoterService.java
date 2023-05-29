package com.kgisl.VotingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.VotingManagement.Model.Voter;
import com.kgisl.VotingManagement.Repository.VoterRepository;

import java.util.List;

@Service
public class VoterService {
    private VoterRepository voterRepository;

    @Autowired
    public VoterService(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    public void addVoter(Voter voter) {
        voterRepository.save(voter);
    }

    public Voter getVoterById(String voterId) {
        return voterRepository.findById(voterId).orElse(null);
    }
    public Voter getVoterByEmailAndPassword(String email, String password) {
        return voterRepository.findByEmailAndPassword(email, password);
    }
    public boolean authenticate(String email, String password) {
        Voter voter = getVoterByEmailAndPassword(email, password);
        return voter != null;
    }
}
