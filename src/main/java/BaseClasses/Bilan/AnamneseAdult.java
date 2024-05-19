package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Enums.EAdultQ;

import java.util.List;

public class AnamneseAdult extends Anamnese{

    List<EAdultQ> categories ;
    public AnamneseAdult(Question[] questions, String[] answers , List<EAdultQ> categories) {
        super(questions, answers);
        this.categories = categories ;
    }

    @Override
    public void setQuestions() {

    }

    @Override
    public void calculateScore() {

    }

    @Override
    public String getAnswers() {
        return null;
    }
}
