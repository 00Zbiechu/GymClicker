package dane.clicker;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class GameController {

    //FXML
    @FXML
    Label resultToShow;

    @FXML
    ImageView pushIMG;

    @FXML
    ImageView releaseIMG;

    //Var
    int scores=0;

    public void addScores(){
        this.scores++;
    }

    public int getScores(){
        return scores;
    }



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


}
