package com.example.interviewos.controller;

import com.example.interviewos.service.ProblemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attempt")
public class AttemptController {

    private final ProblemService problemService;

    public AttemptController(ProblemService problemService){
        this.problemService = problemService;
    }

    @PostMapping
    public String recordAttempt(@RequestParam int problemId,
                                @RequestParam boolean solved,
                                @RequestParam int timeTaken){
        problemService.recordAttempt(problemId,solved,timeTaken);
        return "Attempt recorded";
    }
}
