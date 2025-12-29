package com.example.interviewos.controller;

import com.example.interviewos.service.TrieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/trie")
public class TrieTestController {

    private final TrieService trieService;
    public TrieTestController(TrieService trieService){
        this.trieService = trieService;
    }

    @GetMapping("/search")
    public Set<Integer> search(@RequestParam String prefix){
        return trieService.searchProblemByTagPrefix(prefix);
    }
}
