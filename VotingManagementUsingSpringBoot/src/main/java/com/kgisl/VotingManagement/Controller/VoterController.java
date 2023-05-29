package com.kgisl.VotingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kgisl.VotingManagement.Model.Voter;
import com.kgisl.VotingManagement.Service.VoterService;

import java.util.List;

@RestController
@RequestMapping("/voters")
public class VoterController {
    private VoterService voterService;

    @Autowired
    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @GetMapping
    public List<Voter> getAllVoters() {
        return voterService.getAllVoters();
    }

    @PostMapping
    public void addVoter(@RequestBody Voter voter) {
        voterService.addVoter(voter);
    }

    @GetMapping("/{voterId}")
    public Voter getVoterById(@PathVariable String voterId) {
        return voterService.getVoterById(voterId);
    }
    @GetMapping("/{email}/{password}")
    public Voter getVoterByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        return voterService.getVoterByEmailAndPassword(email, password);
    }
}
