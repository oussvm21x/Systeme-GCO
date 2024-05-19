package com.example.tppoo;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

import BaseClasses.src.Clinique;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controllerinscription2 {
	

	String  nom ; 
	String prenom ; 
	String adresse ; 
	String num ; 
	@FXML 
	TextField password;
	@FXML 
	TextField passwordverification;
	@FXML 
	TextField email;
	
	
	private Stage stage ; 
	private Scene scene ; 
	private Parent root ;
	
	public void getInfo(String  name , String  surname , String  adress , String nume) {
		nom =name ;
		prenom = surname  ;
		adresse = adress ; 
		num = nume; 
	}
	
	
	
	
	
	public void Continuer(ActionEvent A) throws IOException {
	    String pass = password.getText();
	    String passveref = passwordverification.getText();
	    String mail = email.getText();


		if (pass.isEmpty() || passveref.isEmpty() || mail.isEmpty() ) {
			if ( mail.isEmpty() ){
				email.setStyle("-fx-border-color: red;");
				email.setText("Veuillez remplir ce champ");
			}
			if ( passveref.isEmpty() ){
				passwordverification.setStyle("-fx-border-color: red;");
				passwordverification.setText("Veuillez remplir ce champ");
			}
			if ( pass.isEmpty()  ){
				password.setStyle("-fx-border-color: red;");
				password.setText("Veuillez remplir ce champ");
			}

			return;
		}
	    if(Clinique.ortophonistesMap.containsKey(mail)) {
	    	 email.setStyle("-fx-border-color: red;");
	    	 email.setText("Email déjà utilisé");
	    }
	    else {
	    if (passveref.equals(pass)) {
			Clinique.createAccount(nom, prenom, adresse, num, mail, pass);
			Clinique.sauvegarderClinique("Clinique.txt");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
			Parent root = loader.load();
			ControllerHome controller = loader.getController();
			controller.setValues();
			AnchorPane anchorPane = (AnchorPane) root;
			Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
			Scene scene = new Scene(anchorPane); // Use the AnchorPane here
			stage.setScene(scene);
			stage.show();

		}else {
	    	
	    	passwordverification.setStyle("-fx-border-color: red;");
	    	passwordverification.setText("Verifier mot de passe");
	    }}
	}

   public void Retourner(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inscription.fxml")));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
   

}
