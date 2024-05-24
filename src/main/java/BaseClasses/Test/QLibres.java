package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;

public class QLibres extends Question implements Q_E, Serializable {
	
	private String Answer ;


    @Override
    public void setQuestions() {

    }

    @Override
    public String getAnswers() {
        return Answer ; 
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
