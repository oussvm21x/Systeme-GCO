package BaseClasses.Test;

import Interfaces.Q_E;

public class Question implements Q_E {
    private String enonce; 
	private float score; 
	
	
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

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
