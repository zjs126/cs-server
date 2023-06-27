package com.spring.service;

import com.spring.pojo.*;

import java.util.List;

public interface CompetitionService {
    List<NiukeCompetition> searchNiukeCompetition();

    List<CCCC> searchCCCCCompetition();

    List<CCF> searchCCFCompetition();

    List<ChallengeCup> searchChallengeCupCompetition();

    List<CPP> searchCPPCompetition();

    List<Entrepreneurship> searchEntrepreneurshipCompetition();

    List<LanQiaoBei> searchLanQiaoBeiCompetition();

    List<LuoGu> searchLuoGuCompetition();

    List<Tournament> searchTournamentCompetition();

    List<LiKou> searchLiKouTournamentCompetition();
}
