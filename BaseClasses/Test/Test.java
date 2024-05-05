package BaseClasses.Test;

import Interfaces.Q_E;

public class Test implements Q_E {

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

    @Override
    public String getAnswers() {
        return new String[0];
    }

    @Override
    public void calculateScore() {

    }
}
