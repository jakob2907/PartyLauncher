package states;

import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Game {

    Scene s;

    String name, ersteller, programmierspreche;
    Image background;

    String previousGame, nextGame;

    public Game(String name, String ersteller, String programmiersprache, Image background)
    {
        this.name = name;
        this.ersteller = ersteller;
        this.programmierspreche = programmiersprache;
        this.background = background;
    }

    public Game()
    {

    }

    public Scene getScene() {
        return null;
    }



    public void setNextGame(String nextGame) {
        this.nextGame = nextGame;
    }

    public String getNextGame(){
        return nextGame;
    }

    public String getPreviousGame() {
        return previousGame;
    }

    public void setPreviousGame(String previousGame) {
        this.previousGame = previousGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getErsteller() {
        return ersteller;
    }

    public void setErsteller(String ersteller) {
        this.ersteller = ersteller;
    }

    public String getProgrammierspreche() {
        return programmierspreche;
    }

    public void setProgrammierspreche(String programmierspreche) {
        this.programmierspreche = programmierspreche;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }
}
