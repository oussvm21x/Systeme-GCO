package com.example.tppoo;

import BaseClasses.Patient.Adult;
import BaseClasses.Patient.Child;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import BaseClasses.src.Dossier;
import BaseClasses.src.Ortophoniste;
import Enums.EPatient;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Clinique.chargerClinique("Clinique.txt");
        AnchorPane root = (AnchorPane)FXMLLoader.load(Objects.requireNonNull(getClass().getResource("connection.fxml")));
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
        e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
