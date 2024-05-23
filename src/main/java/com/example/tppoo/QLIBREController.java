package com.example.tppoo;

import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.ClinicalTest;
import BaseClasses.Test.QLibres;
import BaseClasses.Test.Question;
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

public class QLIBREController implements Initializable {

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
    private ComboBox type ;
    @FXML
    private Button searchButton ;
    @FXML
    private TableView<QLibres> table;
    @FXML
    private TableColumn<Question, String> typeColumn;
    @FXML
    private TableColumn<Question, Float> titleColumn;

    private Bilan bilan ;
    private Integer id ;
    private ClinicalTest Test;
    public void getInfo(Integer id,Bilan bilan,  ClinicalTest Test){
        this.id =id;
        this.bilan = bilan ;
        this.Test = Test ;
        displayQLIBREQuestionsInTable();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("enonce"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
    }



    public void displayQLIBREQuestionsInTable() {
        List<QLibres> qlibreQuestions = this.Test.getTest().getQLIBREQuestions();
        if (qlibreQuestions != null) {
            ObservableList<QLibres> qlibreList = FXCollections.observableArrayList(qlibreQuestions);
            table.setItems(qlibreList);
        } else {
            // Handle the case when QLIBREQuestions is null, such as displaying an error message
            System.out.println("No QLIBRE questions found.");
        }
    }


    public void Terminer(ActionEvent A) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Test.fxml"));
        Parent root = loader.load();
        TestController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,this.Test);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterQlibre.fxml"));
        Parent root = loader.load();
        AjouterQlibreController controller = loader.getController();
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
