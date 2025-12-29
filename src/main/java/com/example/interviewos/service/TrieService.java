package com.example.interviewos.service;

import com.example.interviewos.model.Problem;
import com.example.interviewos.dsa.Trie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class TrieService {

    private final Trie trie = new Trie();

    public void buildTrie(Collection<Problem> problems){

        for(Problem problem:problems){
            for(String tag:problem.getTags()){
                trie.insert(tag,problem.getProblemId());
            }
        }

    }

    public Set<Integer> searchProblemByTagPrefix(String prefix){
        return trie.searchByPrefix(prefix);
    }
}
