package com.kgisl.VotingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kgisl.VotingManagement.Model.Polling;
import com.kgisl.VotingManagement.Service.PollingService;

import java.util.List;

@RestController
@RequestMapping("/pollings")
public class PollingController {
    private PollingService pollingService;

    @Autowired
    public PollingController(PollingService pollingService) {
        this.pollingService = pollingService;
    }

    @GetMapping
    public List<Polling> getAllPollings() {
        return pollingService.getAllPollings();
    }

    @PostMapping
    public void addPolling(@RequestBody Polling polling) {
        pollingService.addPolling(polling);
    }
}
