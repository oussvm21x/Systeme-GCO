package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;

public class TestQuestions extends Test implements Q_E, Serializable {
    HashSet<Question> questions ;
    Map<Question , Float> scores ;

    //constructor
    public TestQuestions(String testName, HashSet<Question> questions, Map<Question, Float> scores) {
        super(testName);
        this.questions = questions;
        this.scores = scores;
    }

    //setters
    public void setQuestions(HashSet<Question> questions) {
        this.questions = questions;
    }
    public void setScores(Map<Question, Float> scores) {
        this.scores = scores;
    }
    //getters
    public HashSet<Question> getQuestions() {
        return questions;
    }
    public Map<Question, Float> getScores() {
        return scores;
    }
    public void addScore(Question e , Float score){
        scores.put(e , score);
    }



}
