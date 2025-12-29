package com.example.interviewos.service;

import com.example.interviewos.dsa.Graph;
import com.example.interviewos.model.Problem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphService {
    private Graph graph = new Graph();

    public void buildGraph(Collection<Problem> problems){

        //Add all nodes
        for(Problem p:problems){
            graph.addNode(p.getProblemId());
        }

        //Add edges
        List<Problem> problemList = new ArrayList<>(problems);

        for(int i=0;i<problemList.size();i++){
            for(int j=i+1;j<problemList.size();j++){

                Problem p1 = problemList.get(i);
                Problem p2 = problemList.get(j);

                if(isRelated(p1,p2)){
                    graph.addEdge(p1.getProblemId(),p2.getProblemId());
                }
            }
        }
    }

    private boolean isRelated(Problem p1,Problem p2){
        //Check for same tag
        for(String tag: p1.getTags()){
            if(p2.getTags().contains(tag)){
                return true;
            }
        }

        //Difficulty progression
        //ordinal() gives enum order
        //Difficulty difference <=1 means: EASY<->MEDIUM, MEDIUM<->HARD
        return Math.abs(
                p1.getDifficulty().ordinal()-p2.getDifficulty().ordinal()
        )<=1;
    }

    public Graph getGraph(){
        return graph;
    }

    //BFS - Core Recommendation Logic
    //It gets the closest nodes first

    public List<Integer> bfsRecommend(int startId, int limit){

        List<Integer> recommendations = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startId);
        visited.add(startId);

        while(!queue.isEmpty() && recommendations.size()<limit){

            int current = queue.poll();

            for(int neighbor : graph.getNeighbors(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                    recommendations.add(neighbor);
                }
            }
        }
        return recommendations;
    }
}
