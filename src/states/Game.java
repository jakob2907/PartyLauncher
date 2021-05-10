package states;

import javafx.scene.image.Image;

public class Game {

    String name, ersteller, programmierspreche;
    Image background;

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
