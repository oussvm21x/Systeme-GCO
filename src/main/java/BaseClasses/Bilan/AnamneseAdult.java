package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Enums.EAdultQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnamneseAdult extends Anamnese {

    Map<EAdultQ, List<Question>> Questions ;
    Map<Map<EAdultQ, Question> , String> Answers ;
    public AnamneseAdult() {
        super();
    }

    public void setQuestions(Map<EAdultQ, List<Question>> questions) {
        this.Questions = questions;
    }

    public void addQuestion(EAdultQ key, Question question) {
        if (!this.Questions.containsKey(key)) {
            this.Questions.put(key, new ArrayList<>());
        }
        this.Questions.get(key).add(question);
    }
    //getter for question
    public Map<EAdultQ, List<Question>> getQuestions() {
        return this.Questions;
    }
    //Getter for a type of question
    public List<Question> getQuestions(EAdultQ key) {
        return this.Questions.get(key);
    }

    public Map<Map<EAdultQ, Question> , String> getAnswers() {
        return this.Answers;
    }
    public void addAnswer(Map<EAdultQ, Question> key, String answer) {
        this.Answers.put(key, answer);
    }

    public void calculateScore() {

    }
    public Enum<EAdultQ>[] getQtypes(){
        return EAdultQ.values();
    }
}