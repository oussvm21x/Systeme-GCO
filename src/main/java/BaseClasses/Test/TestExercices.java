package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TestExercices extends Test implements Q_E , Serializable {
    private List<Exercice> exercices  ;
    private Map<Exercice , Float> scores ;

    public TestExercices(String testName,  List<Exercice> exercices, Map<Exercice, Float> scores) {
        super(testName);
        this.exercices = exercices;
        this.scores = scores;
    }

    //setters
    public void setExercices(List<Exercice> exercices) {
        this.exercices = exercices;
    }
    public void setScores(Map<Exercice, Float> scores) {
        this.scores = scores;
    }
    //getters
    public List<Exercice> getExercices() {
        return exercices;
    }
    public Map<Exercice, Float> getScores() {
        return scores;
    }
    //add value to an exercices in the scores map
    public void addScore(Exercice e , Float score){
        scores.put(e , score);
    }

}
