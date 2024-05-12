package fxmlfiles;
import javafx.scene.control.TextField;

import java.io.IOException;

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
	    
	    if(Clinique.ortophonistesMap.containsKey(mail)) {
	    	 email.setStyle("-fx-border-color: red;");
	    	 email.setText("Email déjà utilisé");
	    }
	    else {
	    if (passveref.equals(pass)) {
	        //Clinique.createAccount(nom, prenom, adresse, num, mail, pass);
	        Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/Sample.fxml"));
	        Stage stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	    }else {
	    	
	    	passwordverification.setStyle("-fx-border-color: red;");
	    	passwordverification.setText("Verifier mot de passe");
	    }}
	}

   public void Retourner(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/inscription.fxml"));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
   

}
