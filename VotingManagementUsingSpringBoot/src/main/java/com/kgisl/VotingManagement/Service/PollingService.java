package com.kgisl.VotingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.VotingManagement.Model.Polling;
import com.kgisl.VotingManagement.Repository.PollingRepository;

import java.util.List;

@Service
public class PollingService {
    private PollingRepository pollingRepository;

    @Autowired
    public PollingService(PollingRepository pollingRepository) {
        this.pollingRepository = pollingRepository;
    }

    public List<Polling> getAllPollings() {
        return pollingRepository.findAll();
    }

    public void addPolling(Polling newPolling) {
        pollingRepository.save(newPolling);
    }
}
