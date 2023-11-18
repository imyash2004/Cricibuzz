package com.crick.apis.services;

import com.crick.apis.entities.Match;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface MatchService {
        List<Match> getAllMatches();
        List<Match> getLiveMatches();
        List<Map<String,String>>getPointTable();


}
