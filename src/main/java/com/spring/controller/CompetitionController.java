package com.spring.controller;

import com.spring.pojo.*;
import com.spring.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/competition")
@CrossOrigin
public class CompetitionController {
    @Autowired
    CompetitionService competitionService;

    @GetMapping("/GetNiuke")
    public Result GetNiuke() {
        List<NiukeCompetition> pageCompetition = competitionService.searchNiukeCompetition();
        return Result.success(pageCompetition);
    }

    @GetMapping("/GetCCCC")
    public Result GetCCCC() {
        List<CCCC> CCCCCompetition = competitionService.searchCCCCCompetition();
        return Result.success(CCCCCompetition);
    }
    @GetMapping("/GetCCF")
    public Result GetCCF() {
        List<CCF> CCFCompetition = competitionService.searchCCFCompetition();
        return Result.success(CCFCompetition);
    }
    @GetMapping("/GetChallengeCup")
    public Result GetChallengeCup() {
        List<ChallengeCup> ChallengeCupCompetition = competitionService.searchChallengeCupCompetition();
        return Result.success(ChallengeCupCompetition);
    }
    @GetMapping("/GetCPP")
    public Result GetCPP() {
        List<CPP> CPPCompetition = competitionService.searchCPPCompetition();
        return Result.success(CPPCompetition);
    }
    @GetMapping("/GetEntrepreneurship")
    public Result GetEntrepreneurship() {
        List<Entrepreneurship> EntrepreneurshipCompetition = competitionService.searchEntrepreneurshipCompetition();
        return Result.success(EntrepreneurshipCompetition);
    }
    @GetMapping("/GetLanQiaoBei")
    public Result GetLanQiaoBei() {
        List<LanQiaoBei> LanQiaoBeiCompetition = competitionService.searchLanQiaoBeiCompetition();
        return Result.success(LanQiaoBeiCompetition);
    }
    @GetMapping("/GetLuoGu")
    public Result GetLuoGu() {
        List<LuoGu> LuoGuCompetition = competitionService.searchLuoGuCompetition();
        return Result.success(LuoGuCompetition);
    }
    @GetMapping("/GetTournament")
    public Result GetTournament() {
        List<Tournament> TournamentCompetition = competitionService.searchTournamentCompetition();
        return Result.success(TournamentCompetition);
    }
    @GetMapping("/GetLiKou")
    public Result GetLiKou() {
        List<LiKou> LiKouCompetition = competitionService.searchLiKouTournamentCompetition();
        return Result.success(LiKouCompetition);
    }
}
