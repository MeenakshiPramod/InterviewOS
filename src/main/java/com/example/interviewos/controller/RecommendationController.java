package com.example.interviewos.controller;

import com.example.interviewos.model.Problem;
import com.example.interviewos.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public List<Problem> recommend(@RequestParam int failedProblemId,
                                   @RequestParam(defaultValue = "5") int k) {

        return recommendationService.recommendProblems(failedProblemId, k);
    }
}
