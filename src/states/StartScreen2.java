package states;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.media.Media;

public class StartScreen2 extends BasicState{

    GridPane grid = new GridPane();
    GridPane gridChess = new GridPane();

    Label fabian, ben, leo, present;

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

    Media s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    public StartScreen2(StateHandler sh)
    {
        super(sh);

        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(600));
        grid.getColumnConstraints().add(new ColumnConstraints(100));

        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(300));
        grid.getRowConstraints().add(new RowConstraints(200));

        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0,0,0,0));


        gridChess.getColumnConstraints().add(new ColumnConstraints(120));
        gridChess.getColumnConstraints().add(new ColumnConstraints(120));
        gridChess.getColumnConstraints().add(new ColumnConstraints(120));
        gridChess.getColumnConstraints().add(new ColumnConstraints(120));
        gridChess.getColumnConstraints().add(new ColumnConstraints(120));

        b1 = new Button();
        b2 = new Button();
        b3 = new Button();
        b4 = new Button();
        b5 = new Button();
        b6 = new Button();
        b7 = new Button();
        b8 = new Button();
        b9 = new Button();
        b10 = new Button();

        s1 = new Media();
        s2 = new Media();
        s3 = new Media();
        s4 = new Media();
        s5 = new Media();
        s6 = new Media();
        s7 = new Media();
        s8 = new Media();
        s9 = new Media();
        s10 = new Media();


        gridChess.setGridLinesVisible(true);
        /*

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


         */

        grid.add(gridChess, 1,1);

        grid.setGridLinesVisible(true);

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
