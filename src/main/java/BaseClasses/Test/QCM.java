package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;
import java.util.List;

public class QCM extends Question implements Q_E, Serializable {

	private List<String> possiblesAnswers;
	private List<Integer> correctAnswers;
	private List<Integer> answers;

	//constructor
	public QCM(String enonce, float score, List<String> possiblesAnswers, List<Integer> correctAnswers) {
		this.enonce = enonce ;
		this.possiblesAnswers = possiblesAnswers;
		this.correctAnswers = correctAnswers;
	}

	public List<String> getPossiblesAnswers() {
		return possiblesAnswers;
	}
	public void setPossiblesAnswers(List<String> possiblesAnswers) {
		this.possiblesAnswers = possiblesAnswers;
	}
	public List<Integer> getCorrectAnswers() {
		return correctAnswers;
	}
	public void setCorrectAnswers(List<Integer> correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	//add possible answer
	public void addPossibleAnswer(String possibleAnswer) {
		this.possiblesAnswers.add(possibleAnswer);
	}
	public void removePossibleAnswer(String possibleAnswer) {
		this.possiblesAnswers.remove(possibleAnswer);
	}
	public void addCorrectAnswer(int correctAnswer) {
		this.correctAnswers.add(correctAnswer);
	}
	public void removeCorrectAnswer(int correctAnswer) {
		this.correctAnswers.remove(Integer.valueOf(correctAnswer));
	}
	public void setAnswers(List<Integer> answers) {
		this.answers = answers;
	}

	public void setQuestions(String enonce , float score , List<String> possiblesAnswers , List<Integer> correctAnswers) {
		this.enonce = enonce ;
		this.score = score ;
		this.possiblesAnswers = possiblesAnswers ;
		this.correctAnswers = correctAnswers ;
	}
	@Override
	public String getAnswers() {
		return this.answers.toString();
	}

	@Override
	public void calculateScore() {
		int correctCount = 0;
		int incorrectCount = 0;
		for (int i = 0; i < this.answers.size(); i++) {
			boolean isCorrect = false;
			for (int j = 0; j < this.correctAnswers.size(); j++) {
				if (this.answers.get(i).equals(this.correctAnswers.get(j))) {
					correctCount++;
					isCorrect = true;
					break;
				}
			}
			if (!isCorrect) {
				incorrectCount++;
			}
		}
		this.score = (float) (correctCount - incorrectCount/2) / this.correctAnswers.size() * 100;
		if (this.score < 0) {
			this.score = 0;
		}
		setScore(this.score);
	}

}