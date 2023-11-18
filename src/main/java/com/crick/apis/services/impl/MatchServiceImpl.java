package com.crick.apis.services.impl;

import com.crick.apis.entities.Match;
import com.crick.apis.repositories.MatchRepo;
import com.crick.apis.services.MatchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepo matchRepo;
    @Override
    public List<Match> getAllMatches() {
        return this.matchRepo.findAll();
    }

    @Override
    public List<Match> getLiveMatches() {
        List<Match>matches=new ArrayList<>();
        try{
            String url="https://www.cricbuzz.com/cricket-match/live-scores";
            Document document= Jsoup.connect(url).get();
            Elements e=document.select("div.cb-mtch-lst.cb-tms-itm");
            for (Element ex:e){
                HashMap<String ,String>info=new LinkedHashMap<>();
                String teamsHeading=ex.select("h3.cb-lv-scr-mtch-hdr").select("a").text();
                String matchnovenue=ex.select("span").text();
                Elements battingTeamInfo=ex.select("div.cb-hmscg-bat-txt");
                String battingTeam=battingTeamInfo.select("div.cb-hmscg-tm-nm").text();
                String score=battingTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
                Elements bowlTeamInfo=ex.select("div.cb-hmscg-bwl-txt");
                String bowlingTeam=bowlTeamInfo.select("div.cb-hmscg-tm-nm").text();
                String bscore=bowlTeamInfo.select("div.cb-hmscg-tm-nm+div").text();
                String textLive=ex.select("div.cb-text-live").text();

                String textComplete=ex.select("div.cb-text-complete").text();
                String matchLink=ex.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href").toString();


                Match m1=new Match();


                m1.setTeamHeading(teamsHeading);
                m1.setMatchNumberVenue(matchnovenue);
                m1.setMatchLink(matchLink);
                m1.setBattingTeam(battingTeam);
                m1.setBattingTeamScore(score);
                m1.setBowlTeamScore(bscore);
                m1.setBowlTeam(bowlingTeam);
                m1.setLiveText(textLive);
                m1.setTextComplete(textComplete);
                m1.setMatchStatus();
                matches.add(m1);
                UpdateMatch(m1);



            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return matches;
    }

    private void UpdateMatch(Match m1) {
        Match match=this.matchRepo.findByTeamHeading(m1.getTeamHeading()).orElse(null);
        if(match==null){
            matchRepo.save(m1);
        }
        else{
            m1.setMatchId(match.getMatchId());
            matchRepo.save(m1);
        }

    }

    @Override
    public List<Map<String, String>> getPointTable() {
        return null;
    }
}
