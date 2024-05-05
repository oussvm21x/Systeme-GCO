package BaseClasses.Bilan;

import BaseClasses.Test.Question;
import Enums.EKidQ;

import java.util.List;

public class AnamneseKid extends Anamnese{
    List<EKidQ> categories ;
    public AnamneseKid(Question[] questions, String[] answers ,List<EKidQ> categories ) {
        super(questions, answers);
        this.categories = categories;
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
