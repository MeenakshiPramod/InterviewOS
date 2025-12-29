//package com.example.interviewos.service;
//
//import com.example.interviewos.model.Problem;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.PriorityQueue;
//
//public class RecommendationService {
//
//    private final GraphService graphService;
//    private final ProblemService problemService;
//    private final RankingService rankingService;
//
//    public RecommendationService(GraphService graphService,
//                                 ProblemService problemService,
//                                 RankingService rankingService){
//        this.graphService = graphService;
//        this.problemService = problemService;
//        this.rankingService = rankingService;
//    }
//
//    public List<Problem> recommendProblems(int failedProblemId, int k){
//
//        //1. Graph BFS
//        List<Integer> relatedIds = graphService.bfsRecommend(failedProblemId,10);
//
//        //2. Convert IDs -> Problems
//        List<Problem> relatedProblems = new ArrayList<>();
//        for(int id : relatedIds){
//            Problem p = problemService.getProblemById(id);
//            if(p!=null){
//                relatedProblems.add(p);
//            }
//        }
//
//        //3. Rank using Heap
//
//        PriorityQueue<Problem> heap = rankingService.buildRankingHeap(relatedProblems);
//        heap.addAll(relatedProblems);
//
//        //4. Return Top K
//        return rankingService.getTopK(heap,k);
//    }
//}

package com.example.interviewos.service;

import com.example.interviewos.model.Difficulty;
import com.example.interviewos.model.Problem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Service   // THIS IS CRITICAL
public class RecommendationService {

    private final GraphService graphService;
    private final ProblemService problemService;
    private final RankingService rankingService;

    public RecommendationService(GraphService graphService,
                                 ProblemService problemService,
                                 RankingService rankingService) {
        this.graphService = graphService;
        this.problemService = problemService;
        this.rankingService = rankingService;
    }

    public List<Problem> recommendProblems(int failedProblemId, int k) {

        Problem failedProblem = problemService.getProblemById(failedProblemId);
        if (failedProblem == null) return Collections.emptyList();

        Difficulty failedDifficulty = failedProblem.getDifficulty();

        // 1. BFS to get related problems
        List<Integer> relatedIds =
                graphService.bfsRecommend(failedProblemId, 15);

        List<Problem> filteredProblems = new ArrayList<>();

        // 2. Filter logic (CRITICAL)
        for (int id : relatedIds) {
            if (id == failedProblemId) continue; // don’t re-recommend same problem

            Problem p = problemService.getProblemById(id);
            if (p == null) continue;

            // Prefer same or LOWER difficulty after failure
            if (p.getDifficulty().ordinal() <= failedDifficulty.ordinal()) {
                filteredProblems.add(p);
            }
        }

        // 3. Rank using Heap
        PriorityQueue<Problem> heap =
                rankingService.buildRankingHeap(filteredProblems);

        heap.addAll(filteredProblems);

        // 4. Return Top-K
        return rankingService.getTopK(heap, k);
    }

}
