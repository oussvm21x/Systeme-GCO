package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Enums.EAdultQ;
import Enums.EKidQ;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnamneseKid extends Anamnese {

    Map<EKidQ, List<Question>> Questions ;
    Map<Map<EKidQ, Question> , String> Answers ;
    public AnamneseKid() {
        super();
    }

    public void setQuestions(Map<EKidQ, List<Question>> questions) {
        this.Questions = questions;
    }

    public void addQuestion(EKidQ key, Question question) {
        if (!this.Questions.containsKey(key)) {
            this.Questions.put(key, new ArrayList<>());
        }
        this.Questions.get(key).add(question);
    }
    public Map<EKidQ, List<Question>> getQuestions() {
        return this.Questions;
    }
    //Getter for a type of question
    public List<Question> getQuestions(EKidQ key) {
        return this.Questions.get(key);
    }
    public Map<Map<EKidQ, Question> , String> getAnswers() {
        return this.Answers;
    }
    public void addAnswer(Map<EKidQ, Question> key, String answer) {
        this.Answers.put(key, answer);
    }

    public void calculateScore() {

    }
    public Enum<EAdultQ>[] getQtypes(){
        return EAdultQ.values();
    }
}