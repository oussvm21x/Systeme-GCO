package com.example.tppoo;

import BaseClasses.Patient.Adult;
import BaseClasses.Patient.Child;
import javafx.scene.control.DatePicker;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class ProfilEnfantController {
    private Stage stage ;
    private Scene scene ;
    private Parent root ;


    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField birthPlace;

    @FXML
    private TextField adress;

    @FXML
    private TextField numpere;

    @FXML
    private TextField nummere;


    @FXML
    private TextField etude;


    @FXML
    private DatePicker birthDate;
    private Integer id;

    public void getInfo(Integer id){
        this.id = id ;
    }
    public void enregistrer (ActionEvent A){
        Clinique.ortophonisteCourrant.getPatientSansDossier(id).setLastName(nom.getText());
        Clinique.ortophonisteCourrant.getPatientSansDossier(id).setFirstName(prenom.getText());
        Clinique.ortophonisteCourrant.getPatientSansDossier(id).setAddress(adress.getText());
        Clinique.ortophonisteCourrant.getPatientSansDossier(id).setBirthPlace(birthPlace.getText());
        Clinique.ortophonisteCourrant.getPatientSansDossier(id).setBirthDate(birthDate.getValue());
        ((Child)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).setnumP(numpere.getText());
        ((Child)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).setnumM(nummere.getText());
        ((Child)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).setStudieLevel(etude.getText());
    }


    public void setValues() {
        nom.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getLastName());
        prenom.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getFirstName());
        birthPlace.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getBirthPlace());
        adress.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getAddress());
        birthDate.setValue(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getBirthDate());
        numpere.setText(((Child)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).getParentsNums()[0]);
        nummere.setText(((Child)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).getParentsNums()[1]);
        etude.setText(((Child)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).getStudieLevel());
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
