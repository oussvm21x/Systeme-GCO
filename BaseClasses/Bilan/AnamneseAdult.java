package BaseClasses.Bilan;

import BaseClasses.Test.Question;
public class AnamneseAdult extends Anamnese{
	
	private List<EAdultQ> categories;
    public AnamneseAdult(Question[] questions, String[] answers) {
        super(questions, answers);
    }

    @Override
    public void setQuestions() {

    }

    @Override
    public void calculateScore() {

    }
}
