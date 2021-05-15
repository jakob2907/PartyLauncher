package states;

import Main.Main;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class StateHandler {

    Main main;
    Stage window;

    String state, game;
    String firstgame = "pong";
    String firstState = "startscreen";

    HashMap<String, BasicState> states;

    BasicState startScreen, startState, selectState;


    public StateHandler(Main m, Stage window)
    {
        main = m;
        this.window = window;

        createHashMap();

    }

        //Alle States werden in einer Hash Map organisiert String Key für return des States
    public void createHashMap()
    {
        state = firstState;
        game = firstgame;

        states = new HashMap<String, BasicState>();

        startScreen = new StartScreen(this);
        states.put("startscreen", startScreen);

        startState = new StartState(this);
        states.put("startstate", startState);

        selectState = new SelectState(this);
        states.put("selectstate", selectState);




        //weitere States...

        //Games die verwaltet werden



    }

    public void change(String nextState)
    {
        state = nextState;

        window.setScene(states.get(state).getScene());
    }

    public Scene getScene() {

            return states.get(state).getScene();

    }


    public String getGame()
    {
        return game;
    }

    public void setGame(String game) {

        this.game = game;
    }

    public Stage getWindow() {
        return window;
    }

    public Main getMain() {
        return main;
    }
}
