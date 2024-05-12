package fxmlfiles;
import java.io.IOException;

import BaseClasses.src.Clinique;
import BaseClasses.src.Ortophoniste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ConnectionControllers {
	

	private Stage stage ; 
	private Scene scene ; 
	private Parent root ;
	

	    @FXML
	    private TextField adresseEmail;

	    @FXML
	    private Button continuer;

	    @FXML
	    private TextField motpasse;

	    @FXML
	    private Button precedent;

	    @FXML
	    void Continuer(ActionEvent A) throws IOException {
	        String mail = adresseEmail.getText();
	        String passveref = motpasse.getText();

	        if (!Clinique.ortophonistesMap.containsKey(mail)) {
	            adresseEmail.setStyle("-fx-border-color: red;");
	            adresseEmail.setText("Verifier votre Email");
	        } else {
	            Ortophoniste retrievedOrtophoniste = Clinique.ortophonistesMap.get(mail);
	            Clinique.ortophonisteCourrant = retrievedOrtophoniste;
	            if (passveref.equals(retrievedOrtophoniste.getPassword())) {
	                Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/Sample.fxml"));
	                Stage stage = (Stage) (((Node) A.getSource()).getScene().getWindow());
	                Scene scene = new Scene(root);
	                stage.setScene(scene);
	                stage.show();
	            } else {
	                motpasse.setStyle("-fx-border-color: red;");
	                motpasse.setText("Mot de passe non valide ");
	            }
	        }
	    }

	    @FXML
	    public void Retourner(ActionEvent A) throws IOException{
	 	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/Sample.fxml"));
	 		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
	 		scene = new Scene (root);
	 		stage.setScene(scene);
	 		stage.show();
	 	}

	}

