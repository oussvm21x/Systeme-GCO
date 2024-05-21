package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import Enums.EAppointment;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AjouterRdvController implements Initializable  {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField titre;

    @FXML
    private DatePicker date;
    @FXML
    private TextField hour;
    @FXML
    private TextField Minute;
    @FXML
    private ComboBox type ;
    @FXML
    private CheckBox presentiel ;




    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        if (titre.getText().isEmpty() || hour.getText().isEmpty() || date.getValue() == null || Minute.getText().isEmpty()  ) {
            if (titre.getText().isEmpty()) {
                titre.setStyle("-fx-border-color: red;");
                titre.setText("Veuillez remplir ce champ");
            }
            if (hour.getText().isEmpty()) {
                hour.setStyle("-fx-border-color: red;");
                hour.setText("Veuillez remplir ce champ");
            }
            if (Minute.getText().isEmpty()) {
                Minute.setStyle("-fx-border-color: red;");
                Minute.setText("Veuillez remplir ce champ");
            }
            return;
        }
        if (Integer.parseInt(hour.getText())<0 || Integer.parseInt(hour.getText())>23 ){
            hour.setStyle("-fx-border-color: red;");
            hour.setText("Veuillez entrez une heure valide ");
            return;
        }
        if (Integer.parseInt(Minute.getText())<0 || Integer.parseInt(Minute.getText())>23 ){
            Minute.setStyle("-fx-border-color: red;");
            Minute.setText("Veuillez entrez une heure valide ");
            return;
        }

              try {
          int  Hour = Integer.parseInt(hour.getText())*60 + Integer.parseInt(Minute.getText());
                  String selectedType = (String) type.getSelectionModel().getSelectedItem();
                  EAppointment type ;
                  if (selectedType == "Consultation"){
                      type = EAppointment.CONSULTATION;
                  }else {if (selectedType =="Suivi" ){
                      type = EAppointment.FOLLOW_UP;
                  }else {
                      type = EAppointment.ATELIER;
                  }
                  }
                  boolean etat = false ;
                  if (presentiel.isSelected()){
                      etat = true;
                  }
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("RdvPatient.fxml"));
                  root = loader.load();
                  RdvPatientController suite = loader.getController();
                  System.out.println("type before going "+ type);
                  suite.getInfo(titre.getText(),date.getValue(),Hour,type,etat );
                  stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
                  scene = new Scene(root);
                  stage.setScene(scene);
                  stage.show();

            } catch (NumberFormatException e) {
                  hour.setStyle("-fx-border-color: red;");
                  hour.setText("Veuillez entrer une heure Valide");
                  Minute.setStyle("-fx-border-color: red;");
                  Minute.setText("Veuillez entrer une heure Valide");
                return; }




    }



    public void initialize(URL location, ResourceBundle resources) {

        type.getItems().addAll(
                "Consultation",
                "Suivi",
                "Atelier"
        );
        type.setValue("Consultation");

    }

    @FXML
    public void Retourner(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
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
