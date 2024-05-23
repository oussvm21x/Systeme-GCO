package com.example.tppoo;


import BaseClasses.Bilan.Bilan;
import BaseClasses.Bilan.TeurapeuticProject;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.Objects;

import BaseClasses.src.Clinique;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class ProjetT {
    private Stage stage ;
    private Scene scene ;
    private Parent root ;


    @FXML
    private TextArea demarche;

    private Bilan bilan ;
    private Integer id ;
    public void getInfo(Integer id,Bilan bilan){
        this.id =id;
        this.bilan = bilan ;
    }

public void setValues(){
        System.out.println("name Bilan"+bilan.getTitle());
    demarche.setText(bilan.getEtape4().getDemarche());
}
    public void Terminer() {
        if( demarche.getText().isEmpty()){
            demarche.setStyle("-fx-border-color: red;");
            demarche.setText("Veuillez remplir ce champ");
        }else {
            TeurapeuticProject e;
            if (this.bilan.getEtape4() == null){
              e = new TeurapeuticProject();

            }else {
             e =this.bilan.getEtape4();
            }
            e.setDemarche(demarche.getText());
            this.bilan.setEtape4(e);
        }
        Clinique.sauvegarderClinique("Clinique.txt");
    }





    public void Compte(ActionEvent A) throws IOException{
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

    public void Dashboard(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("com/example/tppoo/Sample.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }

    public void Patients(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("patient.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }




    public void appointements(ActionEvent A) throws IOException{
        Parent root =FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rdv.fxml")));
        stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();


    }



    public void settings(ActionEvent A)  throws IOException{

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
