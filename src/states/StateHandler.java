package states;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class StateHandler {

    Stage window;

    String state, game;
    String firstgame = "pong";

    HashMap<String, BasicState> states;

    ArrayList<String> games;

    BasicState startScreen, startState, selectState;
    Game pong, supermario;


    public StateHandler(Stage window)
    {
        this.window = window;

        createHashMap();

    }

        //Alle States werden in einer Hash Map organisiert String Key für return des States
    public void createHashMap()
    {
        game = firstgame;

        states = new HashMap<String, BasicState>();

        startScreen = new StartScreen(this);
        states.put("startscreen", startScreen);

        startState = new StartState(this);
        states.put("startstate", startState);

        selectState = new SelectState(this);
        states.put("selectstate", selectState);


        //weitere States...
        games = new ArrayList<>();
        games.add("pong");
        games.add("Supermario");
        games.add("schach");

    }

    public void change(String nextState)
    {
        state = nextState;

        window.setScene(states.get(state).getScene());
    }

    public Scene getScene()
    {
        return states.get(state).getScene();
    }


    //wenn mehrere Games eingefügt werden, Methode MUSS geändert werden -> HARDCODE!!!!

    public void changeGame() {

        if(state.equals("selectstate"))
        {
               for(int i = 0; i < games.size(); i++)
               {
                   if(games.get(i).equals(game))
                   {
                        game = games.get(i+1);
                   }
               }
        }
        else
        {
            System.out.println("ChangeGame nicht ordnungsgemäß aufgerufen - nicht in Select State");
        }

    }

    public String getGame()
    {
        return game;
    }

    public void setGame(String game) {

        this.game = game;
    }
}
