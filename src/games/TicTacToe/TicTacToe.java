package games.TicTacToe;

import games.Pong.Pong;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import states.Game;

import java.util.ArrayList;

public class TicTacToe extends Game {

    int player;

    boolean running = true;

    Scene s;

    ButtonTTT b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Label lWin;
    Label p1;
    Label p2;
    int scorep1;
    int scorep2;
    Button nextGame;


    ArrayList<ButtonTTT> buttons = new ArrayList<>();

    public TicTacToe()
    {
        super();

        scorep1=0;
        scorep2=0;

        GridPane grid = new GridPane();

        grid.getRowConstraints().add(new RowConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(200));

        grid.getColumnConstraints().add(new ColumnConstraints(100));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(100));

        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(5,0,5,0));

        b1 = new ButtonTTT(this);
        b2 = new ButtonTTT(this);
        b3 = new ButtonTTT(this);
        b4 = new ButtonTTT(this);
        b5 = new ButtonTTT(this);
        b6 = new ButtonTTT(this);
        b7 = new ButtonTTT(this);
        b8 = new ButtonTTT(this);
        b9 = new ButtonTTT(this);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);

        grid.add(b1,1,0);
        grid.add(b2,2,0);
        grid.add(b3,3,0);
        grid.add(b4,1,1);
        grid.add(b5,2,1);
        grid.add(b6,3,1);
        grid.add(b7, 1,2);
        grid.add(b8, 2,2);
        grid.add(b9, 3,2);

        lWin = new Label();

        lWin.setStyle("-fx-font-size: 24");
        lWin.setStyle("-fx-font-style: oblique");
        lWin.setStyle("-fx-font-weight: bold");
        lWin.setTextFill(Color.WHITE);

        GridPane.setHalignment(lWin, HPos.CENTER);

        lWin.setVisible(false);

        grid.add(lWin, 2,1);
        //grid.setGridLinesVisible(true);
        p1 = new Label("Player1: " + scorep1);
        p2= new Label("Player2: " + scorep2);
        p1.setStyle("-fx-font-size: 50");
        p2.setStyle("-fx-font-size: 50");
        p1.setStyle("-fx-font-style: oblique");
        p2.setStyle("-fx-font-style: oblique");
        p1.setStyle("-fx-font-weight: bold");
        p2.setStyle("-fx-font-weight: bold");
        p1.setTextFill(Color.GRAY);
        p2.setTextFill(Color.GRAY);
        p1.setVisible(true);
        p2.setVisible(true);
        p2.setTextAlignment(TextAlignment.RIGHT);
        grid.add(p1,0,0);
        grid.add(p2,4,0);

        nextGame = new Button("Next Game");

        nextGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


            }
        });
        nextGame.setVisible(false);

        nextGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nextGame();
                nextGame.setVisible(false);
            }
        });

        grid.add(nextGame,3,1);

        GridPane.setHalignment(nextGame, HPos.CENTER);
        s = new Scene(grid, 800,600);

    }




    public int checkWin()
    {
        //waagerecht 3x

        if(b1.getColor() == b2.getColor() && b1.getColor() == b3.getColor() && b1.getColor() != 0)
        {
            System.out.println(b1.getColor() + " hat gewonnen");
            lWin.setText("Player "+b1.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b1,b2,b3);
            setScore(b1.getColor());
            running = false;
            return b1.getColor();
        }

        if(b4.getColor() == b5.getColor() && b4.getColor() == b6.getColor() && b4.getColor() != 0)
        {
            System.out.println(b4.getColor() + " hat gewonnen");
            lWin.setText(b4.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b4,b5,b6);
            setScore(b4.getColor());
            running = false;
            return b4.getColor();
        }

        if(b7.getColor() == b8.getColor() && b7.getColor() == b9.getColor() && b7.getColor() != 0)
        {
            System.out.println(b7.getColor() + " hat gewonnen");
            lWin.setText(b7.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b7,b8,b9);
            setScore(b7.getColor());
            running = false;
            return b7.getColor();
        }


        //senkrecht 3x

        if(b1.getColor() == b4.getColor() && b1.getColor() == b7.getColor() && b1.getColor() != 0)
        {
            System.out.println(b1.getColor() + " hat gewonnen");
            lWin.setText(b1.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b1,b4,b7);
            setScore(b7.getColor());
            running = false;
            return b1.getColor();
        }

        if(b2.getColor() == b5.getColor() && b2.getColor() == b8.getColor() && b2.getColor() != 0)
        {
            System.out.println(b2.getColor() + " hat gewonnen");
            lWin.setText(b2.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b2,b5,b8);
            setScore(b2.getColor());
            running = false;
            return b2.getColor();
        }

        if(b3.getColor() == b6.getColor() && b3.getColor() == b9.getColor() && b3.getColor() != 0)
        {
            System.out.println(b3.getColor() + " hat gewonnen");
            lWin.setText(b3.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b3,b6,b9);
            setScore(b3.getColor());
            running = false;
            return b3.getColor();
        }

        //diagonal 2x

        if(b1.getColor() == b5.getColor() && b1.getColor() == b9.getColor() && b1.getColor() != 0)
        {
            System.out.println(b1.getColor() + " hat gewonnen");
            lWin.setText(b1.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b1,b5,b9);
            setScore(b1.getColor());
            running = false;
            return b1.getColor();
        }

        if(b7.getColor() == b5.getColor() && b7.getColor() == b3.getColor() && b7.getColor() != 0)
        {
            System.out.println(b7.getColor() + " hat gewonnen");
            lWin.setText(b7.getColor() + " hat gewonnen");
            lWin.setVisible(true);
            disableButtonsLeft(b7,b5,b3);
            setScore(b7.getColor());
            running = false;
            return b7.getColor();
        }

        return 0;
    }

    private void disableButtonsLeft(ButtonTTT b1, ButtonTTT b2, ButtonTTT b3) {

        for(int i = 0; i < buttons.size(); i++)
        {
            buttons.get(i).setDisable(true);
        }

        b1.setDisable(false);
        b2.setDisable(false);
        b3.setDisable(false);

    }


    public Scene getScene()
    {
        return s;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public boolean isRunning() {
        return running;
    }

    public void setScore(int player){
        if(player==1){
            scorep1++;
            p1.setText("Player1: " + scorep1);
            nextGame.setVisible(true);
        }
        else if(player==2){
            scorep2++;
            p2.setText("Player1: " +scorep2);
            nextGame.setVisible(true);
        }
    }
    public void nextGame(){
        for(int i=0; i<buttons.size();i++){
            buttons.get(i).setStandard();
        }
    }
}
