package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;

public class Test implements Q_E , Serializable {

    private String testName ;
    private String conclusion ;


    //constructor
    public Test(String testName) {
        this.testName = testName;
    }

    //setters and getters
    public void setTestName(String testName) {
        this.testName = testName;
    }
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
    public String getTestName() {
        return testName;
    }
    public String getConclusion() {
        return conclusion;
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
