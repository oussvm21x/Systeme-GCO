package com.example.tppoo;

import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.ClinicalTest;
import BaseClasses.Test.Exercice;
import BaseClasses.src.Clinique;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AjouterExoController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea enonce;
    @FXML
    private TextArea materiel;
    @FXML
    private TextField note;



    private Integer id;
    private Bilan bilan;
    private ClinicalTest test;

    public void getInfo(Integer id, Bilan bilan, ClinicalTest test) {
        this.id = id;
        this.bilan = bilan;
        this.test = test;
    }

    @FXML
    public void enregistrer(ActionEvent event) throws IOException {
        if (enonce.getText().isEmpty()) {
            showAlert("Erreur", "Le texte de la question est vide. Veuillez fournir le texte de la question.");
            return;
        }
        if (note.getText().isEmpty()) {
            showAlert("Erreur", "La note est vide.");
            return;
        }



        Exercice e = new Exercice();
        e.setConsigne(enonce.getText());
        e.setScore( Integer.parseInt(note.getText()));
        e.setMateriels(materiel.getText());

        this.test.getTest().addExerciceQuestion(e);
        Clinique.sauvegarderClinique("Clinique.txt");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EXERCICE.fxml"));
        Parent root = loader.load();
        EXERCICEController controller = loader.getController();
        controller.getInfo(this.id, this.bilan, this.test);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EXERCICE.fxml"));
        Parent root = loader.load();
        EXERCICEController controller = loader.getController();
        controller.getInfo(this.id, this.bilan, this.test);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
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

    @FXML
    public void Compte(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Dashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Patients(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Archives(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void appointements(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void settings(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
        Parent root = loader.load();
        SettingsControllers controller = loader.getController();
        controller.setValues();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
