package com.spring.mapper;

import com.spring.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompetitionMapper {
    @Select("select * from niuke")
    List<NiukeCompetition> searchNiuKeCompetition();

    @Select("select * from cccc")
    List<CCCC> searchCCCCCompetition();

    @Select("select * from ccf")
    List<CCF> searchCCFCompetition();

    @Select("select * from challengecup")
    List<ChallengeCup> searchChallengeCupCompetition();

    @Select("select * from cpp")
    List<CPP> searchCPPCompetition();

    @Select("select * from lanqiaobei")
    List<LanQiaoBei> searchLanQiaoBeiCompetition();

    @Select("select * from luogu")
    List<LuoGu> searchLuoGuCompetition();

    @Select("select * from tournament")
    List<Tournament> searchTournamentCompetition();

    @Select("select * from entrepreneurship")
    List<Entrepreneurship> searchEntrepreneurshipCompetition();

    @Select("select * from likou")
    List<LiKou> searchLiKouCompetition();
}
