package fxmlfiles;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerHome {
	private Stage stage ; 
	private Scene scene ; 
	private Parent root ;
	
	
	public void inscription(ActionEvent A) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/inscription.fxml"));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
	
   public void Connections(ActionEvent A) throws IOException{
	  Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/connection.fxml"));
		stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
		scene = new Scene (root);
		stage.setScene(scene);
		stage.show();
	}
   

   public void Compte(ActionEvent A) throws IOException{
	   Parent root =FXMLLoader.load(getClass().getResource("../fxmlfiles/connection.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
	}
   
   public void Dashboard(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/dashboard.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
	}
   
   public void Patients(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/patient.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
  	}
   
   public void Calendrier(ActionEvent A) throws IOException{
	   Parent root =FXMLLoader.load(getClass().getResource("../fxmlfiles/connection.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
 	}
   
   
   public void Notifications(ActionEvent A) throws IOException{
	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/connection.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
 	}
   
   public void appointements(ActionEvent A) throws IOException{
	   Parent root =FXMLLoader.load(getClass().getResource("../fxmlfiles/connection.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
	}
   
   public void settings(ActionEvent A)  throws IOException{
	   Parent root = FXMLLoader.load(getClass().getResource("../fxmlfiles/connection.fxml"));
			stage = (Stage)(((Node)A.getSource()).getScene().getWindow());
			scene = new Scene (root);
			stage.setScene(scene);
			stage.show();

		
	}

}
