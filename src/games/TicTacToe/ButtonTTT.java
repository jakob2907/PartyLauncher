package games.TicTacToe;

import com.sun.prism.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.shape.Shape;

public class ButtonTTT extends Button {

    int player = 0;

    public ButtonTTT(TicTacToe t)
    {
        super();
        setMaxSize(200,200);

        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (t.isRunning()) {

                    if (t.getPlayer() == 1) {
                        setStyle("-fx-background-color: #383838");
                        player = 2;
                        t.checkWin();
                        t.setPlayer(2);
                    } else {
                        setStyle("-fx-background-color: #FF0000");
                        player = 1;
                        t.checkWin();
                        t.setPlayer(1);
                    }
                }
            }
        });
    }

    public int getColor()
    {
        return player;
    }

    public void setStandard(){
        setDisable(false);
        setStyle("-fx-background-color: #FFFFFF");
    }

}
