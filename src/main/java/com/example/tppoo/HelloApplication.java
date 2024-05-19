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
            Clinique.createAccount("lyna","ticembal","12 boumerdes","1234","lyna", "lyna");
System.out.println(Clinique.ortophonisteCourrant);
            Dossier d1 = new Dossier();
            Dossier d2 = new Dossier();
            Dossier d3 = new Dossier();
            Dossier d4 = new Dossier();
            d1.setNumDossier(1);
            d2.setNumDossier(2);
            d3.setNumDossier(3);
            d4.setNumDossier(4);
            Patient e1 = new Child("lyna","ticembal", LocalDate.of(2022, 5, 17),"Reghaya","Boumerdes", EPatient.CHILD,d1 ,"primaire");
            Patient e2 = new Adult("lyna","ticembal", LocalDate.of(2022, 5, 17),"Reghaya","Boumerdes", EPatient.ADULT,d2 ,"primaire","docteur" , "master");
            Patient e3 = new Child("lyna","ticembal", LocalDate.of(2022, 5, 17),"Reghaya","Boumerdes", EPatient.CHILD,d3,"primaire");
            Patient e4 = new Child("lyna","ticembal", LocalDate.of(2022, 5, 17),"Reghaya","Boumerdes", EPatient.CHILD,d4 ,"primaire");

            Clinique.ortophonisteCourrant.ajouterPatient(e1);
            Clinique.ortophonisteCourrant.ajouterPatient(e2);
            Clinique.ortophonisteCourrant.ajouterPatient(e3);
            Clinique.ortophonisteCourrant.ajouterPatient(e4);
            System.out.println("Les clients:");
            for (Map.Entry<Integer, Patient> entry : Clinique.ortophonisteCourrant.PatientNAD.entrySet()) {
                System.out.println("Dossier Number: " + entry.getKey() + ", Patient: " + entry.getValue());
            }
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
