package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Appointments.Atelier;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import BaseClasses.src.Dossier;
import Enums.EAppointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class InfoRDVController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label titre;

    @FXML
    private Label thematiquelabel;

    @FXML
    private Label date;
    @FXML
    private Label heure;
    @FXML
    private Label type;
    @FXML
    private Label durée;
    @FXML
    private Label thematique;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private Button creerdossier;

    private Appointment appointment;

    public void getInfo(Appointment appointment) {
        this.appointment = appointment;
        setValues();
    }

    private void populateScrollPane() {
        if (this.appointment.getPatients().size() > 0) {
            VBox container = new VBox();
            container.setSpacing(10);
            for (Patient patient : this.appointment.getPatients()) {
                Pane pane = createEntryPane(patient);
                container.getChildren().add(pane);
            }
            scrollpane.setContent(container);
        }
    }

    private Pane createEntryPane(Patient ortophoniste) {
        Pane entryPane = new Pane();
        entryPane.setPrefWidth(490);
        entryPane.setPrefHeight(60);

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/com/example/tppoo/profil.png")));
        imageView.setFitWidth(50);
        imageView.setFitHeight(40);
        imageView.setLayoutX(10);
        imageView.setLayoutY(15);

        BorderStroke borderStroke = new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        );
        Border border = new Border(borderStroke);
        entryPane.setBorder(border);

        Label nameLabel = new Label("Name: " + ortophoniste.getLastName());
        nameLabel.setLayoutX(70);
        nameLabel.setLayoutY(10);

        Label surnameLabel = new Label("Surname: " + ortophoniste.getFirstName());
        surnameLabel.setLayoutX(70);
        surnameLabel.setLayoutY(30);

        if (!entryPane.getChildren().contains(imageView)) {
            entryPane.getChildren().addAll(imageView, nameLabel, surnameLabel);
        }

        return entryPane;
    }

    public void setValues() {
        titre.setText(this.appointment.getTitle());

        // Format the date and time
        LocalDate appointmentDate = this.appointment.getDate();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = appointmentDate.format(dateFormatter);
        date.setText(formattedDate);
        int minutes = appointment.getHour();
        int hours = minutes / 60;
        int mins = minutes % 60;
        String formattedTime = String.format("%02d h %02d min", hours, mins);
        heure.setText(formattedTime);

        // Set the type and conditionally show elements
        EAppointment appointmentType = this.appointment.getAppointmentType();
        if (appointmentType == EAppointment.ATELIER) {
            type.setText("ATELIER");
            thematique.setVisible(true);
            thematiquelabel.setVisible(true);
            thematique.setText(((Atelier)this.appointment).getThemathique());
            creerdossier.setVisible(false);
        } else if (appointmentType == EAppointment.CONSULTATION) {
            type.setText("CONSULTATION");
            thematique.setVisible(false);
            thematiquelabel.setVisible(false);
            creerdossier.setVisible(true);
        } else {
            type.setText("SUIVI");
            thematique.setVisible(false);
            thematiquelabel.setVisible(false);
            creerdossier.setVisible(false);
        }

       minutes = appointment.getDuration();
        hours = minutes / 60;
        mins = minutes % 60;
        String formattedDuration = String.format("%02d h %02d min", hours, mins);
        durée.setText(formattedDuration);

        populateScrollPane();
    }

    public void AjouterDossier() {
        Dossier e = new Dossier();
        this.appointment.getPatients().get(0).setDossier(e);
        Clinique.sauvegarderClinique("Clinique.txt");
    }

    public void RetournerRDV(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Other methods for navigation

    public void RetournerPatientProfil(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dossier.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Compte(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Dashboard(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Patients(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Archives(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void appointements(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void settings(ActionEvent A) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Parent root = loader.load();
        SettingsControllers controller = loader.getController();
        controller.setValues();
        AnchorPane anchorPane = (AnchorPane) root;
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
