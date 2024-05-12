package fxmlfiles;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerInscription{
	@FXML
	TextField prenom;
	@FXML 
	TextField nom;
	@FXML 
	TextField adresse;
	@FXML 
	TextField numtele;
	 @FXML
	    private Text errorMessage;
	
	private Stage stage ; 
	private Scene scene ; 
	private Parent root ;
	
	
	public void Continuer(ActionEvent A) throws IOException{
		String name = nom.getText();
		String surname = prenom.getText();
		String adress = adresse.getText();
		String num = numtele.getText();
		
		  if (name.isEmpty() || surname.isEmpty() || adress.isEmpty() || num.isEmpty()) {
			  errorMessage.setText("Tous les champs sont obligatoires."); 
		        return;
		    }

		    try {
		        Integer.parseInt(num);
		    } catch (NumberFormatException e) {
		    	  errorMessage.setText("Le numéro de téléphone doit être un entier valide."); // Set error message
		            return;
		    }

		    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmlfiles/inscription2.fxml"));
		    root = loader.load();

		    Controllerinscription2 suite = loader.getController();
		    suite.getInfo(name, surname, adress, num);

		    stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		    scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		}
   public void Retourner(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/Sample.fxml"));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
   

}
