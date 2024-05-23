package com.example.tppoo;

import BaseClasses.Patient.Patient;
import BaseClasses.src.Clinique;
import Enums.EPatient;
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

public class PatientController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private TextField searchBar;
    @FXML
    private Button searchButtton ;
    @FXML
    private CheckBox Adossier ;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateScrollPane();
    }

    private void populateScrollPane() {
        if ( Clinique.ortophonisteCourrant.getNbClients()>0) {
            VBox container = new VBox();
            container.setSpacing(10);

       for (int i=0 ; i< Clinique.ortophonisteCourrant.getLenght(); i++) {
                Patient ortophoniste = Clinique.ortophonisteCourrant.getPatientSansDossier(i);
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

        Button archiveButton = new Button("Archiver");
        archiveButton.setLayoutX(300);
        archiveButton.setLayoutY(40);

        Button voirButton = new Button("Voir");
        voirButton.setLayoutX(250);
        voirButton.setLayoutY(40);

        archiveButton.setStyle("-fx-background-color: #0066b2; -fx-text-fill: white");
        voirButton.setStyle("-fx-background-color: #0066b2; -fx-text-fill: white");
        // Event handler for "Archiver" button
        archiveButton.setOnAction(event -> {
            Clinique.ortophonisteCourrant.Archiver(ortophoniste.getId());
            Pane parentPane = (Pane) archiveButton.getParent();
            VBox container = (VBox) parentPane.getParent();
            container.getChildren().remove(parentPane);
            Clinique.sauvegarderClinique("Clinique.txt");
        });

        voirButton.setOnAction(event -> {
            try {
                FXMLLoader loader;
                Parent root;
                if (ortophoniste.getType().equals(EPatient.ADULT)) {
                    loader = new FXMLLoader(getClass().getResource("ProfilAdulte.fxml"));
                    root = loader.load();
                    ProfilAdulteController controller = loader.getController();
                    controller.getInfo(ortophoniste.getId());
                    controller.setValues();
                } else {
                    loader = new FXMLLoader(getClass().getResource("ProfilEnfant.fxml"));
                    root = loader.load();
                    ProfilEnfantController controller = loader.getController();
                    controller.getInfo(ortophoniste.getId());
                    controller.setValues();
                }
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        if (!entryPane.getChildren().contains(imageView)) {
            entryPane.getChildren().addAll(imageView, nameLabel, surnameLabel, archiveButton, voirButton);
        }



        return entryPane;
    }


    @FXML
    public void Ajouter(ActionEvent A) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AjouterClient.fxml")));
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

    public void Searche(ActionEvent A) throws  IOException {
        int numDossier ;
        Patient patient ; 
        if(Adossier.isSelected()){
            try {
               numDossier = Integer.parseInt(searchBar.getText());
            } catch (NumberFormatException e) {
                searchBar.setStyle("-fx-border-color: red;");
                searchBar.setText("Veuillez entrer un numéro de Dossier Valide");

                return; }
            patient = Clinique.ortophonisteCourrant.recherchePatient(numDossier);
            if(patient != null) {
                Pane entryPane = createEntryPane(patient);
            VBox container = new VBox();
                container.setSpacing(10);
                container.getChildren().add(entryPane);
             scrollpane.setContent(container);
            }
            else {
                Label noPatientLabel = new Label("Aucun Patient n'a été trouvé");
                VBox container = new VBox();
                container.setSpacing(10);
                container.getChildren().add(noPatientLabel);
                scrollpane.setContent(container);
            }
        }


    }


}
