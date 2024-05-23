package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Bilan.*;
import BaseClasses.Patient.Patient;
import BaseClasses.Test.QLibres;
import BaseClasses.Test.Question;
import BaseClasses.Test.Test;
import BaseClasses.src.Clinique;
import Enums.EAdultQ;
import Enums.EAppointment;
import Enums.EKidQ;
import Enums.EPatient;
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


public class AjouterQlibreController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea enonce ;

    private Bilan bilan ;
    private Integer id ;;
    private ClinicalTest test;

    public void getInfo(Integer id, Bilan bilan, ClinicalTest test) {
        this.id = id;
        this.bilan = bilan;
        this.test = test;

    }




    public void retour(ActionEvent A) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QLIBRE.fxml"));
        Parent root = loader.load();
        QLIBREController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,this.test);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        if (enonce.getText().isEmpty()) {
            showAlert("Erreur", "Le texte de la question est vide. Veuillez fournir le texte de la question.");
            return;
        }
        Question e = new QLibres();
        e.setEnonce(enonce.getText());
        this.test.getTest().addQLIBREQuestion((QLibres) e);
        Test.saveStaticData("Test.txt");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QLIBRE.fxml"));
        Parent root = loader.load();
        QLIBREController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,this.test);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
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
