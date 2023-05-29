package com.kgisl.VotingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kgisl.VotingManagement.Model.Polling;
import com.kgisl.VotingManagement.Model.Voter;
import com.kgisl.VotingManagement.Model.VotingPolling;
import com.kgisl.VotingManagement.Service.PollingService;
import com.kgisl.VotingManagement.Service.VoterService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ResultController {

        private final VoterService voterService;
        private final PollingService pollingService;

        @Autowired
        public ResultController(VoterService voterService, PollingService pollingService) {
                this.voterService = voterService;
                this.pollingService = pollingService;
        }

        public List<Voter> nonPolling(List<Voter> votersList, List<VotingPolling> filteredMPVoterPollingList) {
                List<Voter> nonPollingVotersList = votersList.stream()
                                .filter(voter -> filteredMPVoterPollingList.stream()
                                                .noneMatch(polling -> polling.getVoter_id()
                                                                .equals(voter.getvoter_id())))
                                .sorted(Comparator.comparing(Voter::getvoter_id))
                                .collect(Collectors.toList());

                return nonPollingVotersList;
        }

        public Map<String, Long> getPartyCount(List<VotingPolling> voterPollingList) {
                Map<String, Long> partyCountList = voterPollingList.stream()
                                .collect(Collectors.groupingBy(VotingPolling::getParty_name, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                (e1, e2) -> e1, LinkedHashMap::new));

                return partyCountList;
        }

        public Map<String, Long> getGenderCount(List<VotingPolling> voterPollingList) {
                Map<String, Long> genderCountList = voterPollingList.stream()
                                .collect(Collectors.groupingBy(VotingPolling::getGender, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                (e1, e2) -> e1, LinkedHashMap::new));

                return genderCountList;
        }

        public Map<String, Map<String, Long>> getWardWiseCount(List<VotingPolling> voterPollingList) {
                Map<String, Map<String, Long>> groupedVotesbyward = voterPollingList.stream()
                                .collect(Collectors.groupingBy(VotingPolling::getWard,
                                                Collectors.groupingBy(VotingPolling::getParty_name,
                                                                Collectors.counting())))
                                .entrySet()
                                .stream()
                                .collect(Collectors.toMap(
                                                Map.Entry::getKey,
                                                e -> e.getValue().entrySet().stream()
                                                                .sorted(Map.Entry
                                                                                .<String, Long>comparingByValue()
                                                                                .reversed())
                                                                .collect(Collectors.toMap(
                                                                                Map.Entry::getKey,
                                                                                Map.Entry::getValue,
                                                                                (v1, v2) -> v1,
                                                                                LinkedHashMap::new)),
                                                (m1, m2) -> m1,
                                                LinkedHashMap::new));

                return groupedVotesbyward;
        }

        @GetMapping("/results")
        @ResponseBody
        public String getResult() {
                List<Voter> votersList = voterService.getAllVoters();
                List<Polling> pollingList = pollingService.getAllPollings();
                List<VotingPolling> voterPollingList = new ArrayList<>();

                pollingList.stream()
                                .flatMap(p -> votersList.stream()
                                                .filter(v -> p.getVoter_id().equals(v.getvoter_id()))
                                                .map(v -> new VotingPolling(p.getVoter_id(), v.getName(), v.getAge(),
                                                                v.getGender(), v.getWard(),
                                                                p.getParty_name(), p.getElection_name(),
                                                                p.getElection_date())))
                                .forEach(voterPollingList::add);

                // voterPollingList.stream().forEach(System.out::println);

                // MLA
                List<VotingPolling> filteredMLAVoterPollingList = pollingList.stream()
                                .flatMap(p -> votersList.stream()
                                                .filter(v -> p.getVoter_id().equals(v.getvoter_id()))
                                                .filter(v -> p.getElection_name().equals("MLA")) // filter by election
                                                                                                 // name
                                                .map(v -> new VotingPolling(
                                                                p.getVoter_id(),
                                                                v.getName(),
                                                                v.getAge(),
                                                                v.getGender(),
                                                                v.getWard(),
                                                                p.getParty_name(),
                                                                p.getElection_name(),
                                                                p.getElection_date())))
                                .collect(Collectors.toList());

                // filteredMLAVoterPollingList.stream().forEach(System.out::println);

                // MP
                List<VotingPolling> filteredMPVoterPollingList = pollingList.stream()
                                .flatMap(p -> votersList.stream()
                                                .filter(v -> p.getVoter_id().equals(v.getvoter_id()))
                                                .filter(v -> p.getElection_name().equals("MP")) // filter by election
                                                                                                // name
                                                .map(v -> new VotingPolling(
                                                                p.getVoter_id(),
                                                                v.getName(),
                                                                v.getAge(),
                                                                v.getGender(),
                                                                v.getWard(),
                                                                p.getParty_name(),
                                                                p.getElection_name(),
                                                                p.getElection_date())))
                                .collect(Collectors.toList());

                // filteredMPVoterPollingList.stream().forEach(System.out::println);

                // // non polling
                List<Voter> nonPollingVotersListForMLA = nonPolling(votersList, filteredMLAVoterPollingList);
                List<Voter> nonPollingVotersListForMP = nonPolling(votersList,filteredMPVoterPollingList);

                // System.out.println(nonPollingVotersListForMLA);
                // System.out.println(nonPollingVotersListForMP);

                // // group by party count
                Map<String, Long> partyCountListForMLA = getPartyCount(filteredMLAVoterPollingList);

                Map<String, Long> partyCountListForMP = getPartyCount(filteredMPVoterPollingList);

                // System.out.println(partyCountListForMLA);
                // System.out.println(partyCountListForMP);

                // gender count
                Map<String, Long> genderCountListMP = getGenderCount(filteredMPVoterPollingList);

                Map<String, Long> genderCountListMLa = getGenderCount(filteredMLAVoterPollingList);

                // System.out.println(genderCountListMP);
                // System.out.println(genderCountListMLa);

                // // ward wise party count
                Map<String, Map<String, Long>> groupedVotesbywardMLA = getWardWiseCount(filteredMLAVoterPollingList);

                Map<String, Map<String, Long>> groupedVotesbywardMP = getWardWiseCount(filteredMPVoterPollingList);

                // System.out.println(groupedVotesbywardMLA);
                // System.out.println(groupedVotesbywardMP);
                // Prepare the response map
                Map<String, Object> responseMap = new LinkedHashMap<>();
                responseMap.put("nonPollingVotersListForMLA", nonPollingVotersListForMLA);
                responseMap.put("nonPollingVotersListForMP", nonPollingVotersListForMP);
                responseMap.put("genderCountListMP", genderCountListMP);
                responseMap.put("genderCountListMLa", genderCountListMLa);
                responseMap.put("partyCountListForMLA", partyCountListForMLA);
                responseMap.put("partyCountListForMP", partyCountListForMP);
                responseMap.put("groupedVotesbywardMLA", groupedVotesbywardMLA);
                responseMap.put("groupedVotesbywardMP", groupedVotesbywardMP);
                System.out.println(responseMap);
                Gson gson = new Gson();
                String jsonResponse = gson.toJson(responseMap);
                System.out.println(jsonResponse);
                return jsonResponse;
        }
}
