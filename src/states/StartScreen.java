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

public class StartScreen extends BasicState{

    GridPane grid = new GridPane();

    Label fabian, ben, leo, present;

    public StartScreen(StateHandler sh)
    {
        super(sh);

        grid.getColumnConstraints().add(new ColumnConstraints(680/3));
        grid.getColumnConstraints().add(new ColumnConstraints(680/3));
        grid.getColumnConstraints().add(new ColumnConstraints(680/3));

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,50,20,50));



        fabian = new Label("Fabian Olszowi");
        GridPane.setHalignment(fabian, HPos.CENTER);

        ben = new Label("Ben Hill");
        GridPane.setHalignment(ben, HPos.CENTER);

        Image benImage = new Image("graphics/BenHill230.png");
        ImageView benImageView = new ImageView();

        Rectangle2D benRect = new Rectangle2D(0,0, 680/3, 120);
        benImageView.setImage(benImage);
        benImageView.setViewport(benRect);

        leo = new Label("Leo Wehr");
        GridPane.setHalignment(leo, HPos.CENTER);

        Image leoImage = new Image("graphics/LeoWehr230.png");
        ImageView leoImageView = new ImageView();

        Rectangle2D leoRect = new Rectangle2D(0,0, 680/3, 250);
        leoImageView.setImage(leoImage);
        leoImageView.setViewport(leoRect);

        present = new Label("PRESENT");
        //present.setStyle();
        GridPane.setHalignment(present, HPos.CENTER);

        Image chess = new Image("graphics/ChessPartyLogo.png");
        ImageView chessview = new ImageView();

        Rectangle2D chessrect = new Rectangle2D(-150,-20, 700, 400);
        chessview.setViewport(chessrect);
        chessview.setImage(chess);



        grid.add(fabian, 0, 0);
        //grid.add(ben, 1, 0);
        grid.add(benImageView, 1, 0);
        //grid.add(leo, 2,0);
        grid.add(leoImageView, 2, 0);
        grid.add(present, 1,1);
        grid.add(chessview, 0,2);

        //grid.setGridLinesVisible(true);

        s = new Scene(grid, 800, 600);
        s.getStylesheets().add("cssFiles/StartScreen.css");
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER)
                {
                    sh.change("startstate");
                    System.out.println("Enter StartScreen");
                }
            }
        });
    }


    @Override
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
