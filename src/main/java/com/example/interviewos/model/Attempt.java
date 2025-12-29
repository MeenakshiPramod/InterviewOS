package com.example.interviewos.model;

public class Attempt {
    private int problemId;
    private boolean solved;
    private int timeTaken;

    public Attempt(int problemId,boolean solved,int timeTaken){
        this.problemId=problemId;
        this.solved=solved;
        this.timeTaken=timeTaken;
    }
}
