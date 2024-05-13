package BaseClasses.Test;

import Interfaces.Q_E;

public class QCU extends Question implements Q_E {

    String[]possiblesAnswers ;
    int answer ;
    int correctAnswer ;

    public QCU(String[] possiblesAnswers, int answer, int correctAnswer) {
        this.possiblesAnswers = possiblesAnswers;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public String[] getPossiblesAnswers() {
        return possiblesAnswers;
    }

    public void setPossiblesAnswers(String[] possiblesAnswers) {
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
        String[] newPossibleAnswers = new String[this.possiblesAnswers.length + 1];
        for(int i = 0; i < this.possiblesAnswers.length; i++){
            newPossibleAnswers[i] = this.possiblesAnswers[i];
        }
        newPossibleAnswers[this.possiblesAnswers.length] = possibleAnswer;
        this.possiblesAnswers = newPossibleAnswers;
    }

    public void removePossibleAnswer(String possibleAnswer) {
        String[] newPossibleAnswers = new String[this.possiblesAnswers.length - 1];
        int j = 0;
        for(int i = 0; i < this.possiblesAnswers.length; i++){
            if(this.possiblesAnswers[i] != possibleAnswer){
                newPossibleAnswers[j] = this.possiblesAnswers[i];
                j++;
            }
        }
        this.possiblesAnswers = newPossibleAnswers;
    }






    @Override
    public void setQuestions() {

    }

    @Override
    public String getAnswers() {
        return new String[0];
    }

    @Override
    public void calculateScore() {

    }
}