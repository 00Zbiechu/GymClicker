package dane.clicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class PushupController {

    //FXML
    @FXML
    Label resultToShow;

    @FXML
    ImageView pushIMG;

    @FXML
    ImageView releaseIMG;

    @FXML
    ImageView wpcOn;

    @FXML
    ImageView wpcOff;


    //GUI
    Stage stage;
    Scene scene;
    Parent root;
    Node node;


    //Var
    int scores=0;
    int scoresToAdd=1;
    boolean wpcUsed;


    public void addScores(){
        this.scores=scores+scoresToAdd;
    }

    public int getScores(){
        return scores;
    }

    public void setScores(int scores){this.scores=scores;}

    public void showScores(){

        resultToShow.setText("Ilość punktów = "+getScores());

    }

    public void push(){

        releaseIMG.setViewOrder(1);
        pushIMG.setViewOrder(2);

    }


    public void release(){

        pushIMG.setViewOrder(1);
        releaseIMG.setViewOrder(2);
        addScores();
        showScores();

    }




    public boolean getWpcStatus(){
        return wpcUsed;
    }

    public void setWpcStatus(boolean status){

        wpcUsed = status;

    }

    public void useWpc(){

        scoresToAdd = 2;
        wpcUsed=true;
        wpcOff.setViewOrder(2);

    }

    public void ifWpcUsed(boolean wpcUsed){

       if(wpcUsed){
           wpcOff.setViewOrder(2);
           scoresToAdd =2;
       }
    }

    public void changeToSquats(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("SquatView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        node = (Node)event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        SquatController squatController = loader.getController();
        squatController.setScores(this.getScores());
        squatController.setWpcStatus(getWpcStatus());
        squatController.ifWpcUsed(getWpcStatus());

    }


    public void changeToPullups(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PullupView.fxml"));
        root = loader.load();
        scene = new Scene(root);
        node = (Node)event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        PullupsController pullupsController = loader.getController();
        pullupsController.setScores(this.getScores());
        pullupsController.setWpcStatus(getWpcStatus());
        pullupsController.ifWpcUsed(getWpcStatus());

    }




}
