package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import Enums.EAppointment;
import Enums.EPatient;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.time.LocalDate;
import java.util.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class DossierRdvController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Appointment> table;
    @FXML
    private TableColumn<Appointment, String> typeColumn;
    @FXML
    private TableColumn<Appointment, String> titleColumn;
    @FXML
    private TableColumn<Appointment, LocalDate> dateColumn;
    @FXML
    private TableColumn<Appointment, String> timeColumn;
    @FXML
    private TableColumn<Appointment, String> durationColumn;

    private  Integer id ;
    public void getInfo(Integer id){
        this.id = id ;
        initializeWithId();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("appointmentType"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Appointment, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Appointment, String> param) {
                Appointment appointment = param.getValue();
                int minutes = appointment.getHour(); // Assuming getHour() returns minutes
                int hours = minutes / 60;
                int mins = minutes % 60;
                String formattedTime = String.format("%02d h %02d min", hours, mins);
                return new SimpleStringProperty(formattedTime);
            }
        });

        durationColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Appointment, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Appointment, String> param) {
                Appointment appointment = param.getValue();
                int minutes = appointment.getDuration();
                int hours = minutes / 60;
                int mins = minutes % 60;
                String formattedTime = String.format("%02d h %02d min", hours, mins);
                return new SimpleStringProperty(formattedTime);
            }
        });
    }
    private void initializeWithId() {
        if (this.id != null) {
            displayAppointments();
        }
    }


    public void displayAppointments() {
        ObservableList<Appointment> appointmentsList = FXCollections.observableArrayList();
        if (Clinique.ortophonisteCourrant.getPatientSansDossier(this.id)!= null) {
            Map<LocalDate, Appointment[]> appointmentsMap =Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getAppointments();
            if (appointmentsMap != null) {
                for (Map.Entry<LocalDate, Appointment[]> entry : appointmentsMap.entrySet()) {
                    LocalDate date = entry.getKey();
                    Appointment[] appointments = entry.getValue();
                    if (appointments != null) {
                        for (Appointment appointment : appointments) {
                            appointmentsList.add(appointment);
                        }
                    }
                }
                table.setItems(appointmentsList);
            } }

    }

    public void checkRdv(ActionEvent event) {
        Appointment selectedRdv = table.getSelectionModel().getSelectedItem();
        if (selectedRdv != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("InfoRdvPatient.fxml"));
                Parent root = loader.load();
                InfoRDVController controller = loader.getController();
                controller.getInfo(selectedRdv);
                controller.setValues();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }}
    }

    public void Dossier(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DossierBO.fxml"));
        Parent root = loader.load();
        DossierBOController controller = loader.getController();
        controller.getInfo(this.id);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void Profil(ActionEvent event) throws IOException{
      try {
            FXMLLoader loader;
            Parent root;
            if (Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getType().equals(EPatient.ADULT)) {
                loader = new FXMLLoader(getClass().getResource("ProfilAdulte.fxml"));
                root = loader.load();
                ProfilAdulteController controller = loader.getController();
                controller.getInfo(this.id);
                controller.setValues();
            } else {
                loader = new FXMLLoader(getClass().getResource("ProfilEnfant.fxml"));
                root = loader.load();
                ProfilEnfantController controller = loader.getController();
                controller.getInfo(this.id);
                controller.setValues();
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AjouterRdv.fxml")));
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
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

    public void deleteSelectedRdv(ActionEvent event) {
        Appointment selectedRdv = table.getSelectionModel().getSelectedItem();
        if (selectedRdv != null) {
            table.getItems().remove(selectedRdv);
            List<Patient> patients= selectedRdv.getPatients();
            LocalDate date = selectedRdv.getDate();
            Clinique.ortophonisteCourrant.deleteAppointment(date);
            for (Patient e : patients) {
                e.deleteAppointment(date);
            }
            Clinique.sauvegarderClinique("Clinique.txt");
        }
    }
}
