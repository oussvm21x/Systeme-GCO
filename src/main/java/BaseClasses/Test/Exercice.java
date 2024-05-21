package BaseClasses.Test;

import Interfaces.Q_E;

import java.io.Serializable;

public class Exercice implements Q_E , Serializable {
	private String[] materiels;

	public String[] getMateriels() {
		return materiels;
	}

	public void setMateriels(String[] materiels) {
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
