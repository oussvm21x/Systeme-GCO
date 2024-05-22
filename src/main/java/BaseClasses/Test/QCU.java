package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;
import java.util.List;

public class QCU extends Question implements Q_E , Serializable {

    List<String> possiblesAnswers ;
    int answer ;
    int correctAnswer ;

    public QCU(List<String> possiblesAnswers, int answer, int correctAnswer) {
        this.possiblesAnswers = possiblesAnswers;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public List<String> getPossiblesAnswers() {
        return possiblesAnswers;
    }

    public void setPossiblesAnswers(List<String> possiblesAnswers) {
        this.possiblesAnswers = possiblesAnswers;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void addPossibleAnswer(String possibleAnswer) {
        this.possiblesAnswers.add(possibleAnswer);
    }

    public void removePossibleAnswer(String possibleAnswer) {
        this.possiblesAnswers.remove(possibleAnswer);
    }

    public void setAnswers(int answer) {
        this.answer = answer;
    }
    public void setQuestions (String enonce, List<String> possiblesAnswers, int answer, int correctAnswer) {
        this.enonce = enonce;
        this.possiblesAnswers = possiblesAnswers;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String getAnswers() {
        return String.valueOf(answer);
    }

    @Override
    public void calculateScore() {
        if (this.answer == this.correctAnswer) {
            this.score = 100;
        } else {
            this.score = 0;
        }
    }
}