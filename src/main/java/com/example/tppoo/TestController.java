package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Bilan.AnamneseAdult;
import BaseClasses.Bilan.AnamneseKid;
import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.ClinicalTest;
import BaseClasses.Patient.Patient;
import BaseClasses.Test.Question;
import BaseClasses.src.Clinique;
import Enums.EAdultQ;
import Enums.EKidQ;
import Enums.EPatient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TestController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    private Bilan bilan ;
    private Integer id ;
    private ClinicalTest Test ;
    public void getInfo(Integer id,Bilan bilan,ClinicalTest Test ){
        this.id =id;
        this.bilan = bilan ;
        this.Test =Test;}





    public void QCM(ActionEvent A) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QCM.fxml"));
        Parent root = loader.load();
        QCMController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,this.Test);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void QCU(ActionEvent A) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QCU.fxml"));
        Parent root = loader.load();
        QCUController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,this.Test);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
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
                controller.getInfo(Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getId());
                controller.setValues();
            } else {
                loader = new FXMLLoader(getClass().getResource("ProfilEnfant.fxml"));
                root = loader.load();
                ProfilEnfantController controller = loader.getController();
                controller.getInfo(Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getId());
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

    public void QLibre(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QLIBRE.fxml"));
        Parent root = loader.load();
        QLIBREController controller = loader.getController();
        controller.getInfo(this.id, this.bilan, this.Test);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Exercice(ActionEvent A) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EXERCICE.fxml"));
        Parent root = loader.load();
        EXERCICEController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,this.Test);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sample.fxml")));
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


}