package states;

import games.Pong.Pong;
import games.SuperMario.SuperMario;
import games.TicTacToe.TicTacToe;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class StateHandler {

    Stage window;

    String state, game;
    String firstgame = "pong";
    String firstState = "startscreen";

    HashMap<String, BasicState> states;
    HashMap<String, Game> games;

    BasicState startScreen, startState, selectState;
    Game pong,tictactoe,supermario;

    boolean startedGame;


    public StateHandler(Stage window)
    {
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

        games = new HashMap<>();

        pong = new Pong();
        pong.setNeighbours("supermario", "tictactoe");
        games.put("pong", pong);

        tictactoe = new TicTacToe();
        tictactoe.setNeighbours("pong", "supermario");
        games.put("tictactoe", tictactoe);

        supermario = new SuperMario();
        supermario.setNeighbours("tictactoe","pong");
        games.put("supermario", supermario);

    }

    public void change(String nextState)
    {
        state = nextState;

        window.setScene(states.get(state).getScene());
    }

    public Scene getScene() {

        if (startedGame) {

            System.out.println(startedGame);
            return games.get(game).getScene();


        } else {
            System.out.println(startedGame);
            return states.get(state).getScene();

        }
    }


    //wenn mehrere Games eingefügt werden, Methode MUSS geändert werden -> HARDCODE!!!!

    public void changeGame(String direction) {

        if(direction.equals("forward"))
        {
            game = games.get(game).getNextGame();
        }
        else
        {
            game = games.get(game).getPreviousGame();
        }


    }

    public String getGame()
    {
        return game;
    }

    public void setGame(String game) {

        this.game = game;
    }

    public HashMap<String, Game> getGames() {
        return games;
    }

    public boolean isStartedGame() {
        return startedGame;
    }

    public void setStartedGame(boolean startedGame) {
        this.startedGame = startedGame;
    }

    public boolean getStartedGame()
    {
        return startedGame;
    }


}
