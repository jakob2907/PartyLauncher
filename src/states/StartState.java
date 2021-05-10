package states;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class StartState extends BasicState{

    public StartState(StateHandler sh)
    {
        super(sh);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 0, 20, 0));

        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(600));
        grid.getColumnConstraints().add(new ColumnConstraints(100));

        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(300));
        grid.getRowConstraints().add(new RowConstraints(200));


        Image chessImage = new Image("graphics/Schachbrettcollage1.png");
        ImageView chessImageView = new ImageView();

        Rectangle2D chessRect = new Rectangle2D(-80,0, 600, 300);
        chessImageView.setImage(chessImage);
        chessImageView.setViewport(chessRect);

        Label enter = new Label("Press Enter to Start");
        GridPane.setHalignment(enter, HPos.CENTER);

        grid.add(chessImageView, 1, 1);
        grid.add(enter, 1, 2);

        grid.setGridLinesVisible(true);

        s = new Scene(grid, 800, 600);
        s.getStylesheets().add("cssFiles/StartState.css");
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER)
                {
                    sh.change("selectstate");
                }
            }
        });

    }

    public Scene getScene() {
        return s;
    }

    @Override
    public void setState(boolean s) {
        state = s;
    }

    @Override
    public boolean getState() {
        return false;
    }
}
