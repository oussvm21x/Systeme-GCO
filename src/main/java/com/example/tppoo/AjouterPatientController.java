package com.example.tppoo;

import BaseClasses.Patient.Adult;
import BaseClasses.Patient.Child;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import Enums.EPatient;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AjouterPatientController  {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
   private TextField nom;
    @FXML
   private TextField prenom;
    @FXML
    private TextField lieuNaissance;
    @FXML
    private TextField addresse;
    @FXML
    private DatePicker date;
    @FXML
    private CheckBox adult;
    @FXML
    private CheckBox urgent;



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{

        if (nom.getText().isEmpty() || prenom.getText().isEmpty() || lieuNaissance.getText().isEmpty() || date.getValue() == null || addresse.getText().isEmpty() ) {
            if (nom.getText().isEmpty()) {
                nom.setStyle("-fx-border-color: red;");
                nom.setText("Veuillez remplir ce champ");
            }
            if (prenom.getText().isEmpty()) {
                prenom.setStyle("-fx-border-color: red;");
                prenom.setText("Veuillez remplir ce champ");
            }
            if (lieuNaissance.getText().isEmpty()) {
                lieuNaissance.setStyle("-fx-border-color: red;");
                lieuNaissance.setText("Veuillez remplir ce champ");
            }


            if ( addresse.getText().isEmpty()) {
                addresse.setStyle("-fx-border-color: red;");
                addresse.setText("Veuillez remplir ce champ");
            }

            return;
        }

        Patient e ;
        if (adult.isSelected()) {
           e = new Adult();
           e.setType(EPatient.ADULT);
        } else {
            e = new Child();
            e.setType(EPatient.CHILD);
        }
        e.setFirstName(prenom.getText());
        e.setLastName(nom.getText());
        e.setBirthDate(date.getValue());
        e.setBirthPlace(lieuNaissance.getText());
        e.setAddress(addresse.getText());
        if (urgent.isSelected()) {
            e.setUrgent(true);
        } else {
            e.setUrgent(false);
        }
      Clinique.ortophonisteCourrant.ajouterPatient(e);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
        Clinique.sauvegarderClinique("Clinique.txt");

    }

    @FXML
    public void Retourner(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void Compte(ActionEvent A) throws IOException {
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

    @FXML
    public void Dashboard(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("com/example/tppoo/Sample.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Patients(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patients.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML

    public void appointements(ActionEvent A) throws IOException{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    public void settings(ActionEvent A) throws IOException {
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
