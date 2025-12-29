package com.example.interviewos.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    //Graph implementation using adjacencyList

    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    //Add a node (problem)
    public void addNode(int problemId){
        adjList.putIfAbsent(problemId,new ArrayList<>());
    }

    //Add edge between two problems
    public void addEdge(int from,int to){
        adjList.get(from).add(to);
        adjList.get(to).add(from); //undirected graph
    }

    //Get neighbors of a problem
    public List<Integer> getNeighbors(int problemId){
        return adjList.getOrDefault(problemId,new ArrayList<>());
    }
}
