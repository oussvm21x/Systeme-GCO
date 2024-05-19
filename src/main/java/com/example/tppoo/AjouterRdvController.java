package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Appointments.Atelier;
import BaseClasses.Appointments.Consultation;
import BaseClasses.Appointments.FollowUp;
import BaseClasses.Patient.Adult;
import BaseClasses.Patient.Child;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import Enums.EAppointment;
import Enums.EMode;
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
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AjouterRdvController implements Initializable  {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private TextField titre;

    @FXML
    private DatePicker date;
    @FXML
    private TextField hour;
    @FXML
    private ComboBox type ;
    @FXML
    private CheckBox presentiel ;

    private  ArrayList<Patient> tab = new  ArrayList<Patient>();



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        if (titre.getText().isEmpty() || hour.getText().isEmpty() || date.getValue() == null  ) {
            if (titre.getText().isEmpty()) {
                titre.setStyle("-fx-border-color: red;");
                titre.setText("Veuillez remplir ce champ");
            }
            if (hour.getText().isEmpty()) {
                hour.setStyle("-fx-border-color: red;");
                hour.setText("Veuillez remplir ce champ");
            }
            return;
        }

              try {
          int  numDossier = Integer.parseInt(hour.getText());
            } catch (NumberFormatException e) {
                  hour.setStyle("-fx-border-color: red;");
                  hour.setText("Veuillez entrer une heure Valide");

                return; }
              Appointment e;
        String hourText = hour.getText();
        LocalTime selectedTime = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            selectedTime = LocalTime.parse(hourText, formatter);
        } catch (DateTimeParseException ee) {
        }

        String selectedType = (String) type.getSelectionModel().getSelectedItem();
        if (selectedType == "Consultation"){
       e = new Consultation();
            if(tab.size() > 1) {

            }
            else {
                if (tab.get(0).getType()== EPatient.ADULT )
                {e.setDuration(LocalTime.of(1, 0));
                }else   e.setDuration(LocalTime.of(1, 0));
                ;

            e.setAppointmentType(EAppointment.CONSULTATION);
            e.setDate(date.getValue());
            e.setHour(selectedTime);}
        }else {if (selectedType =="Suivi" ){
            if(tab.size() > 1) {

            }
     e = new FollowUp();
            e.setAppointmentType(EAppointment.FOLLOW_UP);
            if (presentiel.isSelected()){
                ((FollowUp) e).setMode(EMode.PRESENTIEL);
            }else    ((FollowUp) e).setMode(EMode.ONLINE);
            e.setDate(date.getValue());
            e.setHour(selectedTime);
        }else {
        e = new Atelier();
            e.setAppointmentType(EAppointment.ATELIER);
            e.setDate(date.getValue());
            e.setHour(selectedTime);
        }
        }
        e.setPatients(tab);
if (Clinique.ortophonisteCourrant.addAppointment(date.getValue(),e)){
        for ( int i=0 ; i< tab.size(); i++){
       tab.get(i).addAppointment(date.getValue(),e);
        }}


        Clinique.sauvegarderClinique("Clinique.txt");
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }



    public void initialize(URL location, ResourceBundle resources) {
        populateScrollPane();
        type.getItems().addAll(
                "Consultation",
                "Suivi",
                "Atelier"
        );
        type.setValue("Consultation");

    }

    private void populateScrollPane() {
        if ( Clinique.ortophonisteCourrant.getNbClients()>0) {
            VBox container = new VBox();
            container.setSpacing(10);

            for (int i=0 ; i< Clinique.ortophonisteCourrant.getLenght(); i++) {
                Patient ortophoniste = Clinique.ortophonisteCourrant.getPatientSansDossier(i);
                Pane pane = createEntryPane(ortophoniste);
                container.getChildren().add(pane);
            }
            scrollpane.setContent(container);
        }

    }

    private Pane createEntryPane(Patient ortophoniste) {
        Pane entryPane = new Pane();
        entryPane.setPrefWidth(400);
        entryPane.setPrefHeight(50);

        BorderStroke borderStroke = new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        );
        Border border = new Border(borderStroke);
        entryPane.setBorder(border);

        Label nameLabel = new Label( ortophoniste.getLastName());
        nameLabel.setLayoutX(25);
        nameLabel.setLayoutY(5);

        Label surnameLabel = new Label(ortophoniste.getFirstName());
        surnameLabel.setLayoutX(25);
        surnameLabel.setLayoutY(25);

        CheckBox archiveButton = new CheckBox("Ajouter");
        archiveButton.setLayoutX(300);
        archiveButton.setLayoutY(10);

        archiveButton.setOnAction(event -> {
            if (archiveButton.isSelected()) {
             tab.add(ortophoniste);
            } else {
                tab.remove(ortophoniste);
            }});


        entryPane.getChildren().addAll(nameLabel, surnameLabel, archiveButton);
        return entryPane;
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
