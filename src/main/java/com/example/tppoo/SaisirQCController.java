package com.example.tppoo;

import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.ClinicalTest;
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

public class SaisirQCController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea enonce;
    @FXML
    private ScrollPane scrollpane;
    private Integer id;
    private Bilan bilan;
    private ClinicalTest test;
    private boolean qcm;
    private Question question ;
    public static List<String> Answers = new ArrayList<>();
    private List<Integer> SelectedAnswers = new ArrayList<>();


    public void getInfo(Integer id, Bilan bilan, ClinicalTest test, boolean qcm , Question question) {
        this.id = id;
        this.bilan = bilan;
        this.test = test;
        this.qcm = qcm;
        this.question = question ;
        populateScrollPane();
        enonce.setText(this.question.getEnonce());
    }


    public void enregistrer(ActionEvent A) throws IOException {

        if (SelectedAnswers.isEmpty()) {
            showAlert("Erreur", "Aucune réponse sélectionnée. Veuillez sélectionner au moins une réponse correcte.");
            return;
        }
        if (SelectedAnswers.size() > 1 && !qcm) {
            showAlert("Erreur", "Plusieurs réponses sélectionnées ne sont autorisées que pour les questions QCM.");
            return;
        }

       if(qcm){
           ((QCM)this.question).setAnswers(SelectedAnswers);
           ((QCM)this.question).calculateScore();
       }else {
           ((QCU)this.question).setAnswers(SelectedAnswers.get(0));
           ((QCU)this.question).calculateScore();
       }
        Clinique.sauvegarderClinique("Clinique.txt");

        FXMLLoader loader;
        Parent root;
        if (qcm) {
            loader = new FXMLLoader(getClass().getResource("QCM.fxml"));
            root = loader.load();
            QCMController controller = loader.getController();
            controller.getInfo(this.id, this.bilan, this.test);
        } else {
            loader = new FXMLLoader(getClass().getResource("QCU.fxml"));
            root = loader.load();
            QCUController controller = loader.getController();
            controller.getInfo(this.id, this.bilan, this.test);
        }
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void populateScrollPane() {
        VBox container = new VBox();
        container.setSpacing(10);

        if (qcm && ((QCM)this.question).getPossiblesAnswers()!= null) {
                for (String answer : ((QCM)this.question).getPossiblesAnswers()) {
                    Pane pane = createEntryPane(answer, Answers.indexOf(answer));
                    container.getChildren().add(pane);
            }
        } else if (!qcm &&((QCU)this.question).getPossiblesAnswers() != null) {
                for (String answer :((QCU)this.question).getPossiblesAnswers()) {
                    Pane pane = createEntryPane(answer, Answers.indexOf(answer));
                    container.getChildren().add(pane);

            }
        }

        if (Answers != null) {
            for (int i = 0; i < Answers.size(); i++) {
                Pane pane = createEntryPane(Answers.get(i), i);
                container.getChildren().add(pane);
            }
        }

        scrollpane.setContent(container);
    }

    private Pane createEntryPane(String answer, int index) {
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
                SelectedAnswers.add(index);
            } else {
                SelectedAnswers.remove(Integer.valueOf(index));
            }
        });

        entryPane.getChildren().addAll(nameLabel, archiveButton);
        return entryPane;
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        FXMLLoader loader;
        Parent root;
        if (qcm) {
            loader = new FXMLLoader(getClass().getResource("QCM.fxml"));
            root = loader.load();
            QCMController controller = loader.getController();
            controller.getInfo(this.id, this.bilan, this.test);
        } else {
            loader = new FXMLLoader(getClass().getResource("QCU.fxml"));
            root = loader.load();
            QCUController controller = loader.getController();
            controller.getInfo(this.id, this.bilan, this.test);
        }
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
