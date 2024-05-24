package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Appointments.Atelier;
import BaseClasses.Appointments.Consultation;
import BaseClasses.Appointments.FollowUp;
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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class RdvPatientController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private TextField thematique;
    @FXML
    private Label thematiquelabel;

    private ArrayList<Patient> tab = new ArrayList<>();
    private String titre;
    private Integer hour;
    private Integer Time = 60;
    private EAppointment type;
    private boolean presentiel;
    private LocalDate Date;

    public void getInfo(String titre, LocalDate Date, Integer hour, EAppointment type, boolean presentiel) {
        this.titre = titre;
        this.hour = hour;
        this.type = type;
        this.presentiel = presentiel;
        this.Date = Date;

        // Update the UI elements based on the new data
        updateUI();
    }

    private void updateUI() {
        if (type == EAppointment.ATELIER) {
            thematique.setVisible(true);
            thematique.setStyle("-fx-text-fill: black;");
            thematiquelabel.setVisible(true);
            thematiquelabel.setStyle("-fx-text-fill: #0066b2;");
        } else {
            thematique.setVisible(false);
            thematiquelabel.setVisible(false);
        }

        populateScrollPane();
    }

    @FXML
    public void Ajouter(ActionEvent A) throws IOException {

            if (tab.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Avertissement");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez choisir un patient");
                alert.showAndWait();
            return;
        }

        try {
            Appointment e;
            if (type == EAppointment.CONSULTATION) {
                if (tab.size() > 1) {
                    showAlert("Veuillez choisir un seul patient");
                    return;
                }
                e = new Consultation();
                e.setAppointmentType(EAppointment.CONSULTATION);
                Patient patient = tab.get(0);
                ((Consultation) e).setLastNamePateint(patient.getLastName());
                ((Consultation) e).setFirstNamePatient(patient.getFirstName());
                if (patient.getType() == EPatient.ADULT) {
                    Time = 90;
                } else Time = 150;
            } else if (type == EAppointment.FOLLOW_UP) {
                if (tab.size() > 1) {
                    showAlert("Veuillez choisir un seul patient");
                    return;
                }
                e = new FollowUp();
                e.setAppointmentType(EAppointment.FOLLOW_UP);
                Patient patient = tab.get(0);
                ((FollowUp) e).setMedFileNum(patient.getDossier().getNumDossier());
            } else {
                if (thematique.getText().isEmpty() ){
                    thematique.setStyle("-fx-border-color: red;");
                    thematique.setText("Veuillez remplir ce champ");
                    return;
                }
                if (tab.size() < 2) {
                    showAlert("Veuillez choisir au moins deux patients");
                    return;
                }
                e = new Atelier();
                e.setAppointmentType(EAppointment.ATELIER);
                ((Atelier) e).setThemathique(thematique.getText());;
            }

            e.setTitle(titre);
            e.setDate(Date);
            e.setHour(hour);
            e.setDuration(Time);
            e.setMode(presentiel ? EMode.PRESENTIEL : EMode.ONLINE);
            e.setPatients(tab);

            if (Clinique.ortophonisteCourrant.addAppointment(Date, e)) {
                for (Patient patient : tab) {
                    patient.addAppointment(Date, e);
                }
            }
            Clinique.sauvegarderClinique("Clinique.txt");

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
            stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (NumberFormatException ex) {
            thematique.setStyle("-fx-border-color: red;");
            thematique.setText("Veuillez entrer une heure Valide");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Avertissement");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void initialize(URL location, ResourceBundle resources) {
        thematique.setVisible(false);
        thematiquelabel.setVisible(false);
    }
    private void populateScrollPane() {
        if (Clinique.ortophonisteCourrant.getNbClients() > 0) {
            VBox container = new VBox();
            container.setSpacing(10);

            for (int i = 0; i < Clinique.ortophonisteCourrant.getLenght(); i++) {
                Patient patient = Clinique.ortophonisteCourrant.getPatientSansDossier(i);

                if (patient != null) {
                    boolean dossierExists = patient.getDossier() != null;

                    if ((type == EAppointment.CONSULTATION && (!dossierExists || patient.getDossier().getNumDossier() == -1))
                            || ((type == EAppointment.ATELIER || type == EAppointment.FOLLOW_UP) && dossierExists && patient.getDossier().getNumDossier() != -1)) {
                        Pane pane = createEntryPane(patient);
                        container.getChildren().add(pane);
                    }
                }
            }
            scrollpane.setContent(container);
        }
    }


    private Pane createEntryPane(Patient patient) {
        Pane entryPane = new Pane();
        entryPane.setPrefWidth(440);
        entryPane.setPrefHeight(50);

        BorderStroke borderStroke = new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        );
        Border border = new Border(borderStroke);
        entryPane.setBorder(border);

        Label nameLabel = new Label(patient.getLastName());
        nameLabel.setLayoutX(25);
        nameLabel.setLayoutY(5);

        Label surnameLabel = new Label(patient.getFirstName());
        surnameLabel.setLayoutX(25);
        surnameLabel.setLayoutY(25);

        CheckBox archiveButton = new CheckBox("Ajouter");
        archiveButton.setLayoutX(300);
        archiveButton.setLayoutY(10);

        archiveButton.setOnAction(event -> {
            if (archiveButton.isSelected()) {
                tab.add(patient);
            } else {
                tab.remove(patient);
            }
        });

        entryPane.getChildren().addAll(nameLabel, surnameLabel, archiveButton);
        return entryPane;
    }

    @FXML
    public void Retourner(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AjouterRdv.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
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
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Patients(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patients.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void appointements(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
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

    @FXML
    public void Archives(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
