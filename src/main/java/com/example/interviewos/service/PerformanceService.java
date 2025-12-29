package com.example.interviewos.service;

import com.example.interviewos.model.Attempt;
import org.springframework.stereotype.Service;
import com.example.interviewos.model.Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PerformanceService {

    private final Map<Integer, List<Attempt>> attemptMap = new HashMap<>(); //problemId -> list of attempts

    public void recordAttempt(Problem problem, boolean solved, int timeTaken){

        Attempt attempt = new Attempt(problem.getProblemId(), solved, timeTaken);

        attemptMap.computeIfAbsent(problem.getProblemId(), k-> new ArrayList<>()).add(attempt);

        updateProblemMetrics(problem, solved, timeTaken);
    }

    public void updateProblemMetrics(Problem problem, boolean solved, int timeTaken){
        if(!solved){
            problem.setFailureCount(problem.getFailureCount()+1);
        }
        //prefix-sum style
        int totalAttempts = attemptMap.get(problem.getProblemId()).size();
        int preAvg = problem.getAverageSolveTime();
        int newAvg = ((preAvg*(totalAttempts-1))+timeTaken)/totalAttempts;

        problem.setAverageSolveTime(newAvg);
    }

    public Map<Integer,List<Attempt>> getAttemptMap(){
        return attemptMap;
    }

}
