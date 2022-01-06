package dane.clicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {

    //GUI
    Stage stage;
    Scene scene;
    Parent root;
    Node node;

    public void startGame(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        node = (Node)event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }


}