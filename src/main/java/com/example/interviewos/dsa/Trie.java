package com.example.interviewos.dsa;

import java.util.HashSet;
import java.util.Set;

public class Trie {

    private TrieNode root = new TrieNode();

    //Insert a tag with problemId
    public void insert(String word, int problemId){
        TrieNode current = root;

        for(char ch:word.toLowerCase().toCharArray()){
            current = current.children.computeIfAbsent(ch,c -> new TrieNode());
            current.problemIds.add(problemId);
        }
    }

    //Search by prefix
    public Set<Integer> searchByPrefix(String prefix){
        TrieNode current = root;

        for(char ch:prefix.toLowerCase().toCharArray()){
            if(!current.children.containsKey(ch)){
                return new HashSet<>();
            }
            current = current.children.get(ch);

        }
        return current.problemIds;
    }

}
