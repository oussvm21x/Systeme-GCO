package com.example.tppoo;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerInscription{
	@FXML
	TextField prenom;
	@FXML 
	TextField nom;
	@FXML 
	TextField adresse;
	@FXML 
	TextField numtele;

	private Stage stage ; 
	private Scene scene ; 
	private Parent root ;
	
	
	public void Continuer(ActionEvent A) throws IOException{
		String name = nom.getText();
		String surname = prenom.getText();
		String adress = adresse.getText();
		String num = numtele.getText();
		
		  if (name.isEmpty() || surname.isEmpty() || adress.isEmpty() || num.isEmpty()) {
			  if ( name.isEmpty() ){
				  nom.setStyle("-fx-border-color: red;");
				  nom.setText("Veuillez remplir ce champ");
			  }
			  if ( surname.isEmpty() ){
				  prenom.setStyle("-fx-border-color: red;");
				  prenom.setText("Veuillez remplir ce champ");
			  }
			  if ( adress.isEmpty()  ){
				  adresse.setStyle("-fx-border-color: red;");
				  adresse.setText("Veuillez remplir ce champ");
			  }
			  if ( num.isEmpty() ){
				  numtele.setStyle("-fx-border-color: red;");
				  numtele.setText("Veuillez remplir ce champ");
			  }


		        return;
		    }


		    try {
		        Integer.parseInt(num);
		    } catch (NumberFormatException e) {
				numtele.setStyle("-fx-border-color: red;");
				numtele.setText("Veuillez entrer un numéro de télèphone Valide");

		            return; }

		    FXMLLoader loader = new FXMLLoader(getClass().getResource("inscription2.fxml"));
		    root = loader.load();

		    Controllerinscription2 suite = loader.getController();
		    suite.getInfo(name, surname, adress, num);

		    stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		    scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		}
   public void Retourner(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("connection.fxml")));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
   

}
