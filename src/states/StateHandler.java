package states;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class StateHandler {

    Stage window;

    String state;

    HashMap<String, BasicState> states;
    BasicState startScreen, startState, selectState;


    public StateHandler(Stage window)
    {
        this.window = window;

        createHashMap();
    }

        //Alle States werden in einer Hash Map organisiert String Key für return des States
    public void createHashMap()
    {
        states = new HashMap<String, BasicState>();

        startScreen = new StartScreen(this);
        states.put("startscreen", startScreen);

        startState = new StartState(this);
        states.put("startstate", startState);

        selectState = new SelectState(this);
        states.put("selectstate", selectState);


        //weitere States...
    }

    public void change(String nextState)
    {
        state = nextState;

        window.setScene(states.get(state).getScene());
    }

    public Scene getScene()
    {
        //zurZeit aktive Scene ausgeben
        return null;
    }




}
