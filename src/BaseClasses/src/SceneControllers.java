import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneControllers {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchScenes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("./BaseClasses/src/SignIn2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
