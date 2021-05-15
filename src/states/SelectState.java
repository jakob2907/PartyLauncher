package states;

import Main.Main;
import games.Pong.Pong;
import games.SuperMario.SuperMario;
import games.TicTacToe.TicTacToe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import javafx.stage.Stage;

import java.util.HashMap;

public class SelectState extends BasicState {

    Button gameStart;
    Label gLabel;

    //wenn started == false, Button zeigt Name des Spiels an
    boolean started = false;

    BasicGame pong,tictactoe,supermario;
    HashMap<String, BasicGame> games;
    String game = "pong";

    Scene sceneSelect;

    public SelectState(StateHandler sh) {
        super(sh);

        createGames(sh);

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

                    //Back Skippen

                    System.out.println("Skipped Back");
                    changeGame("forward");
                    gameStart.setText(game);
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

                    //Forward Skippen

                    System.out.println("Skipped Forward");
                    changeGame("back");
                    gameStart.setText(game);
                    gLabel.setText(game + " ist gestartet");
                }
            }
        });
        GridPane.setHalignment(skipForward, HPos.CENTER);

        gameStart = new Button();
        gameStart.setText(game);
        gameStart.setMaxSize(200,200);

        GridPane.setHalignment(gameStart, HPos.CENTER);

        gLabel = new Label();
        gLabel.setText(sh.getGame() + " ist gestartet");
        gLabel.setVisible(false);

        GridPane.setHalignment(gLabel, HPos.CENTER);

        gameStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Game starten
                sh.getWindow().setIconified(true);

                Stage newStage = new Stage();
                Main gameMain = new Main();

                newStage.setScene(games.get(game).getScene());

                try {
                    gameMain.startGame(newStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        GridPane.setHalignment(gameStart, HPos.CENTER);

        grid.add(skipBack, 0, 2);
        grid.add(skipForward, 2,2);
        grid.add(gameStart, 1,1);
        grid.add(gLabel, 1,1);


        sceneSelect = new Scene(grid, 800, 600);
        sceneSelect.getStylesheets().add("cssFiles/SelectState.css");
        sceneSelect.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER && !started)
                {
                    started = true;
                    gameStart.setVisible(false);
                    gLabel.setVisible(true);
                }

                if(event.getCode() == KeyCode.ESCAPE && started)
                {
                    started = false;
                    gameStart.setVisible(true);
                    gLabel.setVisible(false);
                }
            }
        });

        s = sceneSelect;
    }

    private void createGames(StateHandler sh) {

        games = new HashMap<>();

        pong = new Pong(sh);
        pong.setNeighbours("supermario", "tictactoe");
        games.put("pong", pong);

        tictactoe = new TicTacToe(sh);
        tictactoe.setNeighbours("pong", "supermario");
        games.put("tictactoe", tictactoe);

        supermario = new SuperMario(sh);
        supermario.setNeighbours("tictactoe","pong");
        games.put("supermario", supermario);
    }

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

    public HashMap<String, BasicGame> getGames() {
        return games;
    }
}

