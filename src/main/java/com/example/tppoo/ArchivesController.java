package com.example.tppoo;

import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
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
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArchivesController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ScrollPane scrollpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateScrollPane();
    }

    private void populateScrollPane() {
        if ( Clinique.ortophonisteCourrant.getLenghtArchive()>0) {
            VBox container = new VBox();
            container.setSpacing(10);

            for (int i=0 ; i< Clinique.ortophonisteCourrant.getLenghtArchive(); i++) {
                Patient ortophoniste = Clinique.ortophonisteCourrant.getPatientArchives(i);
                Pane pane = createEntryPane(ortophoniste);
                container.getChildren().add(pane);
            }
            scrollpane.setContent(container);
        }

    }

    private Pane createEntryPane(Patient ortophoniste) {
        Pane entryPane = new Pane();
        entryPane.setPrefWidth(400);
        entryPane.setPrefHeight(100);

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("/com/example/tppoo/profil.png")));
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setLayoutX(10);
        imageView.setLayoutY(25);

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
        nameLabel.setLayoutY(25);

        Label surnameLabel = new Label("Surname: " + ortophoniste.getFirstName());
        surnameLabel.setLayoutX(70);
        surnameLabel.setLayoutY(50);

        Button archiveButton = new Button("Récupèrer");
        archiveButton.setLayoutX(300);
        archiveButton.setLayoutY(40);

        Button voirButton = new Button("Voir");
        voirButton.setLayoutX(250);
        voirButton.setLayoutY(40);

        archiveButton.setStyle("-fx-background-color: #0066b2; -fx-text-fill: white");
        voirButton.setStyle("-fx-background-color: #0066b2; -fx-text-fill: white");
        archiveButton.setOnAction(event -> {
            Clinique.ortophonisteCourrant.Recuperer(ortophoniste.getId());
            Pane parentPane = (Pane) archiveButton.getParent();
            VBox container = (VBox) parentPane.getParent();
            container.getChildren().remove(parentPane);
            Clinique.sauvegarderClinique("Clinique.txt");
        });
        // Check if the child nodes are already added before adding them again
        if (!entryPane.getChildren().contains(imageView)) {
            entryPane.getChildren().addAll(imageView, nameLabel, surnameLabel, archiveButton, voirButton);
        }

        return entryPane;
    }


    @FXML
    public void Récupèrer(ActionEvent A) throws IOException{


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

    @FXML
    public void Archives(ActionEvent A) throws IOException{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }
}
