package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Interfaces.Q_E;

public abstract class Anamnese extends Etape implements Q_E {
    private Question[] Questions ;
    private String[] Answers ;

    //constructor
    public Anamnese(Question[] questions, String[] answers){
        this.Questions = questions;
        this.Answers = answers;
    }

    //getters
    public Question[] getQuestions(){
        return this.Questions;
    }
    public String getAnswers(){
        return this.Answers;
    }
    //setters
    public void setQuestions(Question[] questions){
        this.Questions = questions;
    }
    public void setAnswers(String[] answers){
        this.Answers = answers;
    }

    //methods
    public void addQuestion(Question question){
        Question[] newQuestions = new Question[this.Questions.length + 1];
        for(int i = 0; i < this.Questions.length; i++){
            newQuestions[i] = this.Questions[i];
        }
        newQuestions[this.Questions.length] = question;
        this.Questions = newQuestions;
    }
    public void addAnswer(String answer){
        String[] newAnswers = new String[this.Answers.length + 1];
        for(int i = 0; i < this.Answers.length; i++){
            newAnswers[i] = this.Answers[i];
        }
        newAnswers[this.Answers.length] = answer;
        this.Answers = newAnswers;
    }
    public void removeQuestion(Question question){
        Question[] newQuestions = new Question[this.Questions.length - 1];
        int j = 0;
        for(int i = 0; i < this.Questions.length; i++){
            if(this.Questions[i] != question){
                newQuestions[j] = this.Questions[i];
                j++;
            }
        }
        this.Questions = newQuestions;
    }
    public void removeAnswer(String answer){
        String[] newAnswers = new String[this.Answers.length - 1];
        int j = 0;
        for(int i = 0; i < this.Answers.length; i++){
            if(this.Answers[i] != answer){
                newAnswers[j] = this.Answers[i];
                j++;
            }
        }
        this.Answers = newAnswers;
    }
    public void creerTest(){
        //TODO
    }
    public void modifierTest(){
        //TODO
    }
}
