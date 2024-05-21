package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import Enums.EAppointment;
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

public class rdvController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private DatePicker searchBar;
    @FXML
    private Button searchButtton ;
    @FXML
    private ComboBox type ;
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
        displayAppointments();

        type.getItems().addAll(
                "Consultation",
                "Suivi",
                "Atelier"
        );
    }

    public void displayAppointments() {
        ObservableList<Appointment> appointmentsList = FXCollections.observableArrayList();
        if (Clinique.ortophonisteCourrant != null) {
            Map<LocalDate, Appointment[]> appointmentsMap = Clinique.ortophonisteCourrant.getAppointments();
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
            } else {
                System.out.println("getAppointments() returned null.");
            }
        } else {
            System.out.println("Clinique.ortophonisteCourrant is null.");
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

    public void Searche(ActionEvent A) throws  IOException {
        HashMap<LocalDate, Appointment[]> appointments = Clinique.ortophonisteCourrant.getAppointments();
        ArrayList<Appointment> filteredAppointments = new ArrayList<>();
        String selectedType = (String) type.getSelectionModel().getSelectedItem();

        if (searchBar.getValue() == null){
                if (selectedType == null) {
                    for (Appointment[] appointmentArray : appointments.values()) {
                        for (Appointment appointment : appointmentArray) {
                            filteredAppointments.add(appointment);
                        }
                    }
                } else {
                    EAppointment Type;
                    if (selectedType.equals("Atelier")) {
                        Type = EAppointment.ATELIER;
                    } else if (selectedType.equals("Suivi")) {
                        Type = EAppointment.FOLLOW_UP;
                    } else {
                        Type = EAppointment.CONSULTATION;
                    }
                    for (Appointment[] appointmentArray : appointments.values()) {
                        for (Appointment appointment : appointmentArray) {
                            if (appointment.getAppointmentType().equals(Type)) {
                                filteredAppointments.add(appointment);
                            }
                        }
                    }
                }
        }else {
            LocalDate Date= searchBar.getValue();

            if (selectedType == null) {
                if (appointments.containsKey(Date)) {
                    Appointment[] appointmentsArray = appointments.get(Date);
                    for (Appointment appointment : appointmentsArray) {
                        filteredAppointments.add(appointment);
                    }
                }
            } else {
                EAppointment Type;
                if (selectedType == "Atelier"){
                  Type = EAppointment.ATELIER;
                }else {
                    if(selectedType == "Suivi"){
                   Type = EAppointment.FOLLOW_UP;
                    }else
                        Type = EAppointment.CONSULTATION;
                }
                if (appointments.containsKey(Date)) {
                    Appointment[] appointmentsArray = appointments.get(Date);
                    for (Appointment appointment : appointmentsArray) {
                        if (appointment.getAppointmentType().equals(Type)) {
                            filteredAppointments.add(appointment);
                        }
                    }
                }
            }

        }
        table.getItems().clear();
        ObservableList<Appointment> observableAppointments = FXCollections.observableArrayList(filteredAppointments);
        table.setItems(observableAppointments);
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
