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

public class EpreuvesController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private Button AjouetQ ;
    @FXML
    private Button Reponse ;
    @FXML
    private Button terminer ;
    @FXML
    private TableView<ClinicalTest> table;
    @FXML
    private TableColumn<ClinicalTest, Integer> typeColumn;
    @FXML
    private TableColumn<ClinicalTest, String> titleColumn;


    private Bilan bilan ;
    private Integer id ;
    public void getInfo(Integer id,Bilan bilan){
        this.id =id;
        this.bilan = bilan ;
        displayClinicalTests();
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("num"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
    }


    public void displayClinicalTests() {
        ObservableList<ClinicalTest> clinicalTestsList = FXCollections.observableArrayList();
        if (this.bilan != null) {
            List<ClinicalTest> etape2 = this.bilan.getEtape2();
            if (etape2 != null) {
                clinicalTestsList.addAll(etape2);
            }
        }
        table.setItems(clinicalTestsList);
    }



    public void Terminer(ActionEvent A) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Bilan.fxml"));
        Parent root = loader.load();
        BilanController controller = loader.getController();
        controller.getInfo(this.id,bilan);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void AddClinicalTest(ActionEvent A) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterPreuveTechnique.fxml"));
        Parent root = loader.load();
        AjouterPreuveTechnique controller = loader.getController();
       controller.getInfo(this.id,this.bilan);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterQAnamnese.fxml"));
        Parent root = loader.load();
        AjouterQAnamnese controller = loader.getController();
        controller.getInfo(this.id,this.bilan);
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

    public void Consulter(ActionEvent event) {
        ClinicalTest selectedRdv = table.getSelectionModel().getSelectedItem();
        if (selectedRdv != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
                Parent root = loader.load();
                TestController controller = loader.getController();
                controller.getInfo(this.id , this.bilan,selectedRdv);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }}
    }

}
