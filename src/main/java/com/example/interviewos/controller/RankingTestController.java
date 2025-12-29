package com.example.interviewos.controller;

import com.example.interviewos.model.Problem;
import com.example.interviewos.service.ProblemService;
import com.example.interviewos.service.RankingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.PriorityQueue;

@RestController
@RequestMapping("/rank")
public class RankingTestController {

    private final ProblemService problemService;
    private final RankingService rankingService;

    public RankingTestController(ProblemService problemService, RankingService rankingService){
        this.problemService = problemService;
        this.rankingService = rankingService;
    }

    @GetMapping("/top")
    public List<Problem> getTop(@RequestParam(defaultValue = "5") int k){

        PriorityQueue<Problem> heap = rankingService.buildRankingHeap(problemService.getAllProblems());
        heap.addAll((problemService.getAllProblems()));

        return rankingService.getTopK(heap,k);
    }
}
