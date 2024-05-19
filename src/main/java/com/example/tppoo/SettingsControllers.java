package com.example.tppoo;


import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Objects;

import BaseClasses.src.Clinique;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class SettingsControllers {
    private Stage stage ;
    private Scene scene ;
    private Parent root ;


    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField adresse;

    @FXML
    private TextField Numtele;

    @FXML
    private TextField password;
    @FXML
    private TextField verifpassword;

    @FXML
    private TextField Email;


    public void setValues() {
        nom.setText(Clinique.ortophonisteCourrant.getLastName());
        prenom.setText(Clinique.ortophonisteCourrant.getFirstName());
        adresse.setText(Clinique.ortophonisteCourrant.getAddress());
        Numtele.setText(Clinique.ortophonisteCourrant.getPhoneNumber());
        Email.setText(Clinique.ortophonisteCourrant.getEmailAddress());
        password.setText("......");
        verifpassword.setText("......");


    }

    public void appliquer() {
        if (!password.getText().isEmpty() && verifpassword.getText().equals(password.getText()) && !verifpassword.getText().equals("......")) {
            Clinique.ortophonisteCourrant.setPassword(password.getText());
        }
        if (!adresse.getText().isEmpty() ){
            Clinique.ortophonisteCourrant.setAddress(adresse.getText());
        }
        if (!Email.getText().isEmpty()){
            Clinique.ortophonisteCourrant.setEmailAddress(Email.getText());
        }
        if (!prenom.getText().isEmpty()){
            Clinique.ortophonisteCourrant.setFirstName(prenom.getText());
        }

        if (!nom.getText().isEmpty()){
            Clinique.ortophonisteCourrant.setLastName(  nom.getText());
        }
        if (!Numtele.getText().isEmpty()){
            Clinique.ortophonisteCourrant.setPhoneNumber(Numtele.getText());
        }
        Clinique.sauvegarderClinique("Clinique.txt");
    }





    public void Compte(ActionEvent A) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
        Parent root = loader.load();
        ControllerHome controller = loader.getController();
        controller.setValues();
        AnchorPane anchorPane = (AnchorPane) root;
        Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        Scene scene = new Scene(anchorPane); // Use the AnchorPane here
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




    public void appointements(ActionEvent A) throws IOException{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }

  public void modifierDInscription(ActionEvent A) throws IOException{
     FXMLLoader loader = new FXMLLoader(getClass().getResource("description.fxml"));
      Parent root = loader.load();
      descriptionController controller = loader.getController();
      controller.setValues();
      AnchorPane anchorPane = (AnchorPane) root;
      Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
      Scene scene = new Scene(anchorPane); // Use the AnchorPane here
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
        Scene scene = new Scene(anchorPane); // Use the AnchorPane here
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

}
