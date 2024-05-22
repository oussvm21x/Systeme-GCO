package com.example.tppoo;

import BaseClasses.Patient.Adult;
import Enums.EPatient;
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

public class ProfilAdulteController {
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
    private TextField diplome;

    @FXML
    private TextField profession;


    @FXML
    private TextField numeroperso;


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
    ((Adult)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).setDiplome(diplome.getText());
    ((Adult)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).setPhoneNum(numeroperso.getText());
    ((Adult)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).setProfession(profession.getText());
}


    public void Dossier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dossier.fxml"));
        Parent root = loader.load();
        DossierRdvController controller = loader.getController();
        controller.getInfo(this.id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void setValues() {
        nom.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getLastName());
        prenom.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getFirstName());
        birthPlace.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getBirthPlace());
        adress.setText(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getAddress());
        birthDate.setValue(Clinique.ortophonisteCourrant.getPatientSansDossier(id).getBirthDate());
        diplome.setText(((Adult)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).getDiplome());
        numeroperso.setText(((Adult)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).getPhoneNum());
        profession.setText(((Adult)Clinique.ortophonisteCourrant.getPatientSansDossier(id)).getProfession());
}


    public void Compte(ActionEvent A) throws IOException{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }

    public void Dashboard(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
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
