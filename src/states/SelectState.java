package states;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class SelectState extends BasicState {

    public SelectState(StateHandler sh) {
        super(sh);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0,0,0,0));

        Image background = new Image("graphics/ChessPartyLogo.png");

        s = new Scene(grid, 800, 600);
        s.getStylesheets().add("cssFiles/SelectState.css");
    }

    private Rectangle DrawRectangle(int x, int y, int w, int h) {

        Rectangle rect = new Rectangle(x,y,w,h);
        return rect;

    }

    @Override
    public Scene getScene() {
        return s;
    }

    @Override
    public void setState(boolean s) {

    }

    @Override
    public boolean getState() {
        return false;
    }
}

