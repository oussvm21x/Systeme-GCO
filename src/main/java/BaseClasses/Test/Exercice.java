package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;
import java.util.List;

public class Exercice implements Q_E , Serializable {
	private String materiels;
	private  String Consigne ;
	public String getMateriels() {
		return materiels;
	}
	public Integer Score ;

	public Integer getScore() {
		return Score;
	}

	public void setScore(Integer score) {
		Score = score;
	}

	public void setConsigne(String consigne) {
		Consigne = consigne;
	}

	public String getConsigne() {
		return Consigne;
	}

	public void setMateriels(String materiels) {
		this.materiels = materiels;
	}
	

	private void creerExercice() {
		
	}
	private void modifierExercice() {
		
	}
	private void ajouterMateriel() {
		
	}
	private void supprimerMateriels() {
		
	}

	@Override
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
