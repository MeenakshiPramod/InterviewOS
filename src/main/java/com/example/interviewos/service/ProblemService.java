//package com.example.interviewos.service;
//
//import com.example.interviewos.model.Difficulty;
//import com.example.interviewos.model.Problem;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//
//private final GraphService graphService;
//
//@Service
//public class ProblemService {
//    private Map<Integer,Problem> problemMap = new HashMap<>();
//
////    public ProblemService(){
////        loadSampleProblems();
////    }
//    public ProblemService(GraphService graphService) {
//        this.graphService = graphService;
//        loadSampleProblems();
//        graphService.buildGraph(problemMap.values());
//    }
//
//    private void loadSampleProblems(){
//        problemMap.put(1, new Problem(
//                1,
//                "Two Sum",
//                Difficulty.EASY,
//                Arrays.asList("Array","Two Pointers")
//        ));
//        problemMap.put(2, new Problem(
//                2,
//                "Longest Substring Without Repeating Characters",
//                Difficulty.MEDIUM,
//                Arrays.asList("Sliding Window", "Hashing")
//        ));
//
//        problemMap.put(3, new Problem(
//                3,
//                "Container With Most Water",
//                Difficulty.MEDIUM,
//                Arrays.asList("Two Pointers","Arrays")
//        ));
//
//    }
//
//    public Collection<Problem> getAllProblems(){
//        return problemMap.values();
//    }
//
//    public Problem getProblemById(int id){
//        return problemMap.get(id);
//    }
//
//
//}
package com.example.interviewos.service;

import com.example.interviewos.model.Difficulty;
import com.example.interviewos.model.Problem;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProblemService {

    private final Map<Integer, Problem> problemMap = new HashMap<>();
    private final GraphService graphService;
    private final TrieService trieService;
    private final RankingService rankingService;
    private final PerformanceService performanceService;



    public ProblemService(GraphService graphService,
                          TrieService trieService,
                          RankingService rankingService,
                          PerformanceService performanceService) {

        this.graphService = graphService;
        this.trieService = trieService;
        this.rankingService = rankingService;
        this.performanceService = performanceService;

        loadSampleProblems();
        graphService.buildGraph(problemMap.values());
        trieService.buildTrie(problemMap.values());
    }



    private void loadSampleProblems() {

        problemMap.put(1, new Problem(
                1,
                "Two Sum",
                Difficulty.EASY,
                Arrays.asList("Array", "Two Pointers")
        ));

        problemMap.put(2, new Problem(
                2,
                "Longest Substring Without Repeating Characters",
                Difficulty.MEDIUM,
                Arrays.asList("Sliding Window", "Hashing")
        ));

        problemMap.put(3, new Problem(
                3,
                "Container With Most Water",
                Difficulty.MEDIUM,
                Arrays.asList("Two Pointers","Arrays")
        ));

        problemMap.put(4, new Problem(
                4,
                "Valid Palindrome",
                Difficulty.EASY,
                Arrays.asList("Two Pointers", "String")
        ));

        problemMap.put(5, new Problem(
                5,
                "Remove Duplicates from Sorted Array",
                Difficulty.EASY,
                Arrays.asList("Two Pointers", "Array")
        ));

        problemMap.put(6, new Problem(
                6,
                "3Sum",
                Difficulty.MEDIUM,
                Arrays.asList("Two Pointers", "Sorting")
        ));

        problemMap.put(7, new Problem(
                7,
                "Maximum Sum Subarray of Size K",
                Difficulty.EASY,
                Arrays.asList("Sliding Window", "Array")
        ));

        problemMap.put(8, new Problem(
                8,
                "Longest Repeating Character Replacement",
                Difficulty.MEDIUM,
                Arrays.asList("Sliding Window", "String")
        ));

        problemMap.put(9, new Problem(
                9,
                "Minimum Window Substring",
                Difficulty.HARD,
                Arrays.asList("Sliding Window", "Hashing")
        ));

        problemMap.put(10, new Problem(
                10,
                "Valid Parentheses",
                Difficulty.EASY,
                Arrays.asList("Stack", "String")
        ));

        problemMap.put(11, new Problem(
                11,
                "Next Greater Element",
                Difficulty.MEDIUM,
                Arrays.asList("Stack", "Array")
        ));

        problemMap.put(12, new Problem(
                12,
                "Largest Rectangle in Histogram",
                Difficulty.HARD,
                Arrays.asList("Stack")
        ));

        problemMap.put(13, new Problem(
                13,
                "Binary Search",
                Difficulty.EASY,
                Arrays.asList("Binary Search")
        ));

        problemMap.put(14, new Problem(
                14,
                "Search in Rotated Sorted Array",
                Difficulty.MEDIUM,
                Arrays.asList("Binary Search")
        ));

        problemMap.put(15, new Problem(
                15,
                "Median of Two Sorted Arrays",
                Difficulty.HARD,
                Arrays.asList("Binary Search")
        ));

        problemMap.put(16, new Problem(
                16,
                "Binary Tree Inorder Traversal",
                Difficulty.EASY,
                Arrays.asList("Tree", "DFS")
        ));

        problemMap.put(17, new Problem(
                17,
                "Maximum Depth of Binary Tree",
                Difficulty.EASY,
                Arrays.asList("Tree", "DFS")
        ));

        problemMap.put(18, new Problem(
                18,
                "Lowest Common Ancestor of BST",
                Difficulty.MEDIUM,
                Arrays.asList("Tree", "BST")
        ));

        problemMap.put(19, new Problem(
                19,
                "Number of Islands",
                Difficulty.MEDIUM,
                Arrays.asList("Graph", "DFS")
        ));

        problemMap.put(20, new Problem(
                20,
                "Course Schedule",
                Difficulty.MEDIUM,
                Arrays.asList("Graph", "Topological Sort")
        ));

        problemMap.put(21, new Problem(
                21,
                "Shortest Path in Binary Matrix",
                Difficulty.MEDIUM,
                Arrays.asList("Graph", "BFS")
        ));

        problemMap.put(22, new Problem(
                22,
                "Climbing Stairs",
                Difficulty.EASY,
                Arrays.asList("DP")
        ));

        problemMap.put(23, new Problem(
                23,
                "Longest Increasing Subsequence",
                Difficulty.MEDIUM,
                Arrays.asList("DP")
        ));

        problemMap.put(24, new Problem(
                24,
                "Edit Distance",
                Difficulty.HARD,
                Arrays.asList("DP")
        ));


    }

    public Collection<Problem> getAllProblems() {
        return problemMap.values();
    }

    public Problem getProblemById(int id) {
        return problemMap.get(id);
    }

    public void recordAttempt(int problemId, boolean solved, int timeTaken){
        Problem problem = problemMap.get(problemId);
        if(problem==null) return;

        performanceService.recordAttempt(problem,solved,timeTaken);
    }
}
