package com.example.interviewos.controller;

import com.example.interviewos.model.Problem;
import com.example.interviewos.service.ProblemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/problems")
public class ProblemController {

    private final ProblemService problemService;

    public ProblemController(ProblemService problemService){
        this.problemService = problemService;
    }

    @GetMapping
    public Collection<Problem> getAllProblems(){
        return problemService.getAllProblems();
    }
}
