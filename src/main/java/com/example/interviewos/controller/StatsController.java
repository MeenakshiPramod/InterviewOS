package com.example.interviewos.controller;

import com.example.interviewos.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final PerformanceService performanceService;

    public StatsController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping
    public Map<Integer, Integer> getStats() {

        Map<Integer, Integer> stats = new HashMap<>();

        performanceService.getAttemptMap()
                .forEach((problemId, attempts) ->
                        stats.put(problemId, attempts.size())
                );

        return stats;
    }
}
