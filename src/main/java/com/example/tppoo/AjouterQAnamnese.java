package com.example.tppoo;

import BaseClasses.Appointments.Appointment;
import BaseClasses.Bilan.*;
import BaseClasses.Patient.Patient;
import BaseClasses.Test.Question;
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


public class AjouterQAnamnese {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextArea enonce ;
    @FXML
    private ComboBox type ;

    private Bilan bilan ;
    private Integer id ;;
    public void getInfo(Integer id,Bilan bilan ){
        this.id =id;
        this.bilan = bilan ;
        if (Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getType() == EPatient.ADULT ){
            type.getItems().addAll(
                    "Histoire Maladie",
                    "Suivi Medical"
            );
        }else {
            type.getItems().addAll(
                    "Structure familiale",
                    "Dynamique familiale",
                    "Antecedents familiaux",
                    "Conditions natales",
                    "Developpement psychomoteur",
                    "Developpement langagier",
                    "Caractère et comportement"

            );
        }
    }

    public void Add(ActionEvent A) throws IOException {
        String selectedType = (String) type.getValue();
        Question question = new Question();
        question.setEnonce(enonce.getText());
        if (Clinique.ortophonisteCourrant.getPatientSansDossier(this.id).getType() == EPatient.ADULT ){
           if(selectedType == "Histoire Maladie"){
               question.setType1( EAdultQ.Histoire_Maladie);
               AnamneseAdult.addStaticQuestion( EAdultQ.Histoire_Maladie, question);
           }else {
               question.setType1( EAdultQ.Suivi_Medical);
               AnamneseAdult.addStaticQuestion( EAdultQ.Suivi_Medical,question );
           }
        }else {
            if(selectedType == "Structure familiale"){
                question.setType2(EKidQ.Structure_familiale);
                AnamneseKid.addStaticQuestion(EKidQ.Structure_familiale, question);
            }
            if(selectedType =="Dynamique familiale"){
                question.setType2(EKidQ.Dynamique_familiale);
                AnamneseKid.addStaticQuestion(EKidQ.Dynamique_familiale, question);
            }
            if(selectedType ==  "Antecedents familiaux"){
                question.setType2(EKidQ.Antecedents_familiaux);
                AnamneseKid.addStaticQuestion(EKidQ.Antecedents_familiaux,question);
            }
            if(selectedType ==  "Conditions natales"){
                question.setType2(EKidQ.Conditions_natales);
                AnamneseKid.addStaticQuestion(EKidQ.Conditions_natales,question );
            }
            if(selectedType ==   "Developpement psychomoteur"){
                question.setType2(EKidQ.Developpement_psychomoteur);
                AnamneseKid.addStaticQuestion(EKidQ.Developpement_psychomoteur,question);
            }
            if(selectedType ==   "Developpement langagier"){
                question.setType2(EKidQ.Developpement_langagier);
                AnamneseKid.addStaticQuestion(EKidQ.Developpement_langagier, question);
            }
            if(selectedType ==  "Caractère et comportement"){
                question.setType2(EKidQ.Caractère_et_comportement);
                AnamneseKid.addStaticQuestion(EKidQ.Caractère_et_comportement, question);
            }
        }
       AnamneseKid.saveStaticData("AnamneseKidQ.txt");
        AnamneseAdult.saveStaticData("AnamneseAdultQ.txt");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Anamnese.fxml"));
        Parent root = loader.load();
        AnamneseController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,null);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Terminer(ActionEvent A) throws IOException {
        Clinique.sauvegarderClinique("Clinique.txt");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Anamnese.fxml"));
        Parent root = loader.load();
        AnamneseController controller = loader.getController();
        controller.getInfo(this.id,this.bilan,null);
        Stage stage = (Stage) ((Node) A.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AjouterRdv.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
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
