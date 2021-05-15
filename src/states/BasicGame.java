package states;

import javafx.scene.Scene;

public class BasicGame{

    Scene scene;

    String previousGame,nextGame;

    StateHandler sh;

    public BasicGame(StateHandler sh)
    {
        this.sh = sh;
    }

    public void setNeighbours(String pGame,String nGame)
    {
        previousGame = pGame;
        nextGame = nGame;
    }

    public String getPreviousGame() {
        return previousGame;
    }

    public String getNextGame() {
        return nextGame;
    }

    public Scene getScene() {
        return scene;
    }

}
