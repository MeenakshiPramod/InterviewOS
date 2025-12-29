package com.example.interviewos.dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TrieNode {

    Map<Character,TrieNode> children = new HashMap<>(); //next characters
    Set<Integer> problemIds = new HashSet<>(); //problems with same prefix
    boolean isEndOfWord = false; //full tag ends here
}
