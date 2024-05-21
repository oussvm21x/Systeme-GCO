package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;

public class Test implements Q_E , Serializable {

    private String testName ;
    private String conclusion ;

    //constructor
    public Test(String testName, String conclusion) {
        this.testName = testName;
        this.conclusion = conclusion;
    }
    @Override
    public void setQuestions() {

    }

    public String getAnswers() {
        return "";
    }

    @Override
    public void calculateScore() {

    }
}
