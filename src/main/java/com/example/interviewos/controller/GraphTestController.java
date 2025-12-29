package com.example.interviewos.controller;


import com.example.interviewos.service.GraphService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/graph")
public class GraphTestController {

    private final GraphService graphService;
    public GraphTestController(GraphService graphService) {
        this.graphService = graphService;
    }

    @GetMapping("/recommend/{id}")
    public List<Integer> recommend(@PathVariable int id) {
        return graphService.bfsRecommend(id, 5);
    }
}
