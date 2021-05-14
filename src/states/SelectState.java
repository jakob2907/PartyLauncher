package states;

import games.Pong.Pong;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
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
import javafx.scene.shape.Rectangle;

public class SelectState extends BasicState {

    Button game;
    Label gLabel;

    //wenn started == false, Button zeigt Name des Spiels an
    boolean started = false;

    public SelectState(StateHandler sh) {
        super(sh);

        GridPane grid = new GridPane();

        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(600));
        grid.getColumnConstraints().add(new ColumnConstraints(100));

        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(400));
        grid.getRowConstraints().add(new RowConstraints(100));

        grid.setVgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0,0,0,0));

        grid.setGridLinesVisible(true);

        Image background = new Image("graphics/ChessPartyLogo.png");
        ImageView bView = new ImageView(background);


        Button skipBack = new Button();
        skipBack.setMaxSize(80,80);

        skipBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if(!started) {
                    System.out.println("Skipped Back");
                    sh.changeGame("forward");
                    game.setText(sh.getGame());
                    gLabel.setText(sh.getGame() + " ist gestartet");
                }
            }
        });

        GridPane.setHalignment(skipBack, HPos.CENTER);

        Button skipForward = new Button();
        skipForward.setMaxSize(80,80);

        skipForward.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!started) {
                    System.out.println("Skipped Forward");
                    sh.changeGame("back");
                    game.setText(sh.getGame());
                    gLabel.setText(sh.getGame() + " ist gestartet");
                }
            }
        });
        GridPane.setHalignment(skipForward, HPos.CENTER);

        game = new Button();
        game.setText(sh.getGame());
        game.setMaxSize(200,200);

        GridPane.setHalignment(game, HPos.CENTER);

        gLabel = new Label();
        gLabel.setText(sh.getGame() + " ist gestartet");
        gLabel.setVisible(false);

        GridPane.setHalignment(gLabel, HPos.CENTER);

        game.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //game.setVisible(false);
                //started = true;


                sh.setStartedGame(true);
                System.out.println(sh.getStartedGame());



            }
        });

        GridPane.setHalignment(game, HPos.CENTER);

        grid.add(skipBack, 0, 2);
        grid.add(skipForward, 2,2);
        grid.add(game, 1,1);
        grid.add(gLabel, 1,1);


        s = new Scene(grid, 800, 600);
        s.getStylesheets().add("cssFiles/SelectState.css");
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER && !started)
                {
                    started = true;
                    game.setVisible(false);
                    gLabel.setVisible(true);
                }

                if(event.getCode() == KeyCode.ESCAPE && started)
                {
                    started = false;
                    game.setVisible(true);
                    gLabel.setVisible(false);
                }
            }
        });
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

