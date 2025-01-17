package com.example.tppoo;

import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.ClinicalTest;
import BaseClasses.Bilan.Diagnostic;
import BaseClasses.Bilan.TeurapeuticProject;
import BaseClasses.Test.QCM;
import BaseClasses.Test.QCU;
import BaseClasses.Test.Question;
import BaseClasses.Test.Test;
import BaseClasses.src.Clinique;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DiagnosticController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea enonce;
    @FXML
    private ScrollPane scrollpane;
    private Integer id;
    private Bilan bilan;
    public static List<String> Answers = new ArrayList<>();
    private final String[] staticInformation = {"Troubles de la déglutition", "Troubles neuro-développementaux", "Troubles cognitifs"};


    public void getInfo(Integer id, Bilan bilan) {
        this.id = id;
        this.bilan = bilan;

        populateScrollPane();
    }


    public void enregistrer(ActionEvent event) throws IOException {
        if (enonce.getText().isEmpty()) {
            showAlert("Erreur", "Le texte de la question est vide. Veuillez fournir le texte de la question.");
            return;
        }
        if (Answers.isEmpty()) {
            showAlert("Erreur", "Aucun choix fourni. Veuillez fournir au moins un choix.");
            return;
        }
        Diagnostic e;
        if (this.bilan.getEtape3() == null) {
            e = new Diagnostic();
        } else {
            e = this.bilan.getEtape3();
        }
        e.setDescription(enonce.getText());
        if (Answers.contains("Troubles de la déglutition")){
            e.setTroubles_deglutition(true);
        }
        if (Answers.contains("Troubles cognitifs")){
            e.setTroubles_cognitifs(true);
        }
        if (Answers.contains("Troubles neuro-développementaux")){
            e.setTroubles_neuro_developpement(true);
        }
        Clinique.sauvegarderClinique("Clinique.txt");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Bilan.fxml"));
            Parent root = loader.load();
            BilanController controller = loader.getController();
            controller.getInfo(this.id, this.bilan);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @FXML
    private void retourner(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Bilan.fxml"));
            Parent root = loader.load();
            BilanController controller = loader.getController();
            controller.getInfo(this.id, this.bilan);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void populateScrollPane() {
        VBox container = new VBox();
        container.setSpacing(10);

        // Adding static information to the scroll pane
        for (String info : staticInformation) {
            Pane pane = createEntryPane(info);
            container.getChildren().add(pane);
        }

        scrollpane.setContent(container);
    }

    private Pane createEntryPane(String answer) {
        Pane entryPane = new Pane();
        entryPane.setPrefWidth(500);
        entryPane.setPrefHeight(50);

        BorderStroke borderStroke = new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        );
        Border border = new Border(borderStroke);
        entryPane.setBorder(border);

        Label nameLabel = new Label(answer);
        nameLabel.setLayoutX(25);
        nameLabel.setLayoutY(5);

        CheckBox archiveButton = new CheckBox("");
        archiveButton.setLayoutX(400);
        archiveButton.setLayoutY(10);

        archiveButton.setOnAction(event -> {
            if (archiveButton.isSelected()) {
                Answers.add(answer);
            } else {
                Answers.remove(answer);
            }
        });

        entryPane.getChildren().addAll(nameLabel, archiveButton);
        return entryPane;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

    public void Compte(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Dashboard(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Patients(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Archives(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void appointements(ActionEvent A) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
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
        Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.show();
    }
}
