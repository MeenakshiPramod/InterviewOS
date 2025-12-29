package com.example.interviewos.model;


import java.util.List;

public class Problem {

    private int problemId;
    private String title;
    private Difficulty difficulty;
    private List<String> tags;
    private int averageSolveTime;
    private int failureCount;

    public Problem(int problemId,String title,Difficulty difficulty,List<String> tags){
        this.problemId = problemId;
        this.title = title;
        this.difficulty = difficulty;
        this.tags = tags;
        this.averageSolveTime = 0;
        this.failureCount = 0;
    }

    public int getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(int failureCount) {
        this.failureCount = failureCount;
    }

    public int getAverageSolveTime() {
        return averageSolveTime;
    }

    public void setAverageSolveTime(int averageSolveTime) {
        this.averageSolveTime = averageSolveTime;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }
}
