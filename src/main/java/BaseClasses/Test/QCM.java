package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;

public class QCM extends Question implements Q_E, Serializable {
	
	private String[] possiblesAnswers;
	private int[] correctAnswers;
	private int[] answers;
	
	
	public String[] getPossiblesAnswers() {
		return possiblesAnswers;
	}
	public void setPossiblesAnswers(String[] possiblesAnswers) {
		this.possiblesAnswers = possiblesAnswers;
	}
	public int[] getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(int[] correctAnswers) {
		this.correctAnswers = correctAnswers;
	}
	
	
	public void setAnswers(int[] answers) {
		this.answers = answers;
	}

	
	   public void setQuestions() {

	    }

	    @Override
	    public String getAnswers() {
	        return "";
	    }

	    @Override
	    public void calculateScore() {

	    }
}
