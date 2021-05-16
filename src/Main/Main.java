package Main;

import games.Chess.Chess;
import games.Pong.Pong;
import games.TicTacToe.TicTacToe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import states.SelectState;
import states.StartScreen;
import states.StartState;
import states.StateHandler;

public class Main extends Application {

    Stage window;

    private StateHandler stateHandler;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        stateHandler = new StateHandler(this, window);

        //richtiger Code
        //window.setScene(stateHandler.getScene());

        //Probe Code Pong
        //Pong p = new Pong();
        //window.setScene(p.getScene());

        //Probe Code TTT
        //TicTacToe ttt = new TicTacToe();
        //window.setScene(ttt.getScene());

        //Probe Code Chess
        Chess c = new Chess();

        window.setScene(c.getScene());

        window.getIcons().add(new Image("/graphics/StageIconChess.png"));
        window.resizableProperty().setValue(Boolean.FALSE);
        window.show();

    }

    //neues Fenster für Games

    public void startGame(Stage window) throws Exception
    {

        window.getIcons().add(new Image("/graphics/StageIconChess.png"));
        window.resizableProperty().setValue(Boolean.FALSE);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
