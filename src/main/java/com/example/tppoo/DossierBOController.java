package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Bilan.Bilan;
import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import Enums.EAppointment;
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

public class DossierBOController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Bilan> table;
    @FXML
    private TableColumn<Bilan, String> ListeBO;
    @FXML
    private TableColumn<Bilan, Integer> num;


    private  Integer id ;
    public void getInfo(Integer id){
        this.id = id ;
        initializeWithId();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListeBO.setCellValueFactory(new PropertyValueFactory<>("title"));
       num.setCellValueFactory(new PropertyValueFactory<>("id"));
    }
    private void initializeWithId() {
        if (this.id != null) {
            displayBO();
        }
    }

    public void displayBO() {
    if ( Clinique.ortophonisteCourrant.getPatientSansDossier(this.id) .getDossier()!= null){
        List<Bilan> bilans = Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getDossier().getBilans();
        System.out.println(("Bilans ,"+bilans));
        if (bilans != null) {
            ObservableList<Bilan> BOList = FXCollections.observableArrayList(bilans);
            table.setItems(BOList);
        }
    }else {
        showAlert("Créer un dossier d'abord");
    }

    }


    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
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



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoueterBilan.fxml"));
        Parent root = loader.load();
        AjouterBilan controller = loader.getController();
        controller.getInfo(this.id);
        AnchorPane anchorPane = (AnchorPane) root;
        Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
        Scene scene = new Scene(anchorPane); // Use the AnchorPane here
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

    public void Archives(ActionEvent A) throws IOException{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Archives.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }

    public void checkRdv(ActionEvent event) {
        Bilan selectedRdv = table.getSelectionModel().getSelectedItem();
        if (selectedRdv != null) {
            try {
                FXMLLoader loader;
                if (selectedRdv.getId()== 0){
                    loader = new FXMLLoader(getClass().getResource("Bilan.fxml"));
                }else {
                    loader = new FXMLLoader(getClass().getResource("BilanSup0.fxml"));
                }
                Parent root = loader.load();
                BilanController controller = loader.getController();
                controller.getInfo(this.id,selectedRdv);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }}
    }

}
