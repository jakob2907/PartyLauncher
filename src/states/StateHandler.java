package states;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;

public class StateHandler {

    Stage window;

    String state, game;
    String firstgame = "pong";

    HashMap<String, BasicState> states;
    HashMap<String, Game> games;

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

        games = new HashMap<String ,Game>();

        pong = new Game();
        games.put("pong", pong);

        supermario = new Game();
        games.put("supermario", supermario);

        state = "startscreen";

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
               if(game.equals("pong"))
               {
                   game = "supermario";
                   System.out.println(game);
               }
               else{
                    game = "pong";
                   System.out.println(game);
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
