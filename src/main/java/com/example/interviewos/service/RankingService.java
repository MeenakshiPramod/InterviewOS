package com.example.interviewos.service;

import com.example.interviewos.model.Problem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class RankingService {

    public PriorityQueue<Problem> buildRankingHeap(Collection<Problem> problems){

        return new PriorityQueue<>((p1,p2) ->{

            //1.Higher failure count first
            if(p1.getFailureCount() != p2.getFailureCount() ){
                return p2.getFailureCount()- p1.getFailureCount();
            }

            //2.Lower difficulty first
            if(p1.getDifficulty() != p2.getDifficulty()){
                return p1.getDifficulty().ordinal() - p2.getDifficulty().ordinal();
            }

            //3.Lower average solve time first
            return p1.getAverageSolveTime() - p2.getAverageSolveTime();
        });
    }

    public List<Problem> getTopK(PriorityQueue<Problem> heap, int k){

        List<Problem> result = new ArrayList<>();

        while(!heap.isEmpty() && k-- >0){
            result.add(heap.poll());
        }
        return result;
    }
}
