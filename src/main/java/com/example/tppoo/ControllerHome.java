package com.example.tppoo;

import javafx.scene.control.Label;


import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class ControllerHome {
	private Stage stage ; 
	private Scene scene ; 
	private Parent root ;


	@FXML
	private Label nom;

	@FXML
	private Label prenom;

	@FXML
	private Label adresse;

	@FXML
	private Label Numtele;

	@FXML
	private Label nbpatients;

	@FXML
	private Label Email;


	@FXML
	private Label discription;



	public void setValues() {
		nom.setText(Clinique.ortophonisteCourrant.getLastName());
		prenom.setText(Clinique.ortophonisteCourrant.getFirstName());
		adresse.setText(Clinique.ortophonisteCourrant.getAddress());
		Numtele.setText(Clinique.ortophonisteCourrant.getPhoneNumber());
		nbpatients.setText(String.valueOf(Clinique.ortophonisteCourrant.getNbClients()));
		Email.setText(Clinique.ortophonisteCourrant.getEmailAddress());
		discription.setText(Clinique.ortophonisteCourrant.getDiscription());

	}


   public void Compte(ActionEvent A) throws IOException{
	   Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../../fxmlfiles/Sample.fxml")));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
	}
   
   public void Dashboard(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("com/example/tppoo/Sample.fxml")));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
	}
   
   public void Patients(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();
  	}
   
   

	public void Archives(ActionEvent A) throws IOException{
		Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();


	}

	public void appointements(ActionEvent A) throws IOException{
		Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();


	}
   
   public void settings(ActionEvent A)  throws IOException{

	   FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
	   Parent root = loader.load();
	   SettingsControllers controller = loader.getController();
	   controller.setValues();
	   AnchorPane anchorPane = (AnchorPane) root;
	   Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
	   Scene scene = new Scene(anchorPane);
	   stage.setScene(scene);
	   stage.show();

   }

}
