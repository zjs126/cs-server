package com.spring.service.impl;

import com.spring.mapper.CompetitionMapper;
import com.spring.pojo.*;
import com.spring.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionServicelmpl implements CompetitionService {
    @Autowired
    CompetitionMapper competitionMapper;

    @Override
    public List<NiukeCompetition> searchNiukeCompetition() {
        return competitionMapper.searchNiuKeCompetition();
    }

    @Override
    public List<CCCC> searchCCCCCompetition() {
        return competitionMapper.searchCCCCCompetition();
    }

    @Override
    public List<CCF> searchCCFCompetition() {
        return competitionMapper.searchCCFCompetition();
    }

    @Override
    public List<ChallengeCup> searchChallengeCupCompetition() {
        return competitionMapper.searchChallengeCupCompetition();
    }

    @Override
    public List<CPP> searchCPPCompetition() {
        return competitionMapper.searchCPPCompetition();
    }

    @Override
    public List<Entrepreneurship> searchEntrepreneurshipCompetition() {
        return competitionMapper.searchEntrepreneurshipCompetition();
    }

    @Override
    public List<LanQiaoBei> searchLanQiaoBeiCompetition() {
        return competitionMapper.searchLanQiaoBeiCompetition();
    }

    @Override
    public List<LuoGu> searchLuoGuCompetition() {
        return competitionMapper.searchLuoGuCompetition();
    }

    @Override
    public List<Tournament> searchTournamentCompetition() {
        return competitionMapper.searchTournamentCompetition();
    }

    @Override
    public List<LiKou> searchLiKouTournamentCompetition() {
        return competitionMapper.searchLiKouCompetition();
    }
}
