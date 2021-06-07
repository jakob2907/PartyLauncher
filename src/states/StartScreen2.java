package states;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.swing.*;
import java.io.File;
import java.nio.file.Paths;

public class StartScreen2 extends BasicState {

    GridPane grid = new GridPane();
    GridPane gridChess = new GridPane();

    Label fabian, ben, leo, present;

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;

    Media s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    MediaPlayer mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10;
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
        grid.setGridLinesVisible(false);

        grid.add(gridChess,1,1);
        gridChess.getColumnConstraints().add(new ColumnConstraints(125));
        gridChess.getColumnConstraints().add(new ColumnConstraints(125));
        gridChess.getColumnConstraints().add(new ColumnConstraints(125));
        gridChess.getColumnConstraints().add(new ColumnConstraints(125));
        gridChess.getColumnConstraints().add(new ColumnConstraints(125));

        gridChess.getRowConstraints().add(new RowConstraints(150));




        b1 = new Button("C");
        b2 = new Button("H");
        b3 = new Button("E");
        b4 = new Button("S");
        b5 = new Button("S");
        b6 = new Button("P");
        b7 = new Button("A");
        b8 = new Button("R");
        b9 = new Button("T");
        b10 = new Button("Y");


        gridChess.add(b1,0,0);
        gridChess.add(b2,1,0);
        gridChess.add(b3,2,0);
        gridChess.add(b4,3,0);
        gridChess.add(b5,4,0);
        gridChess.add(b6,0,1);
        gridChess.add(b7,1,1);
        gridChess.add(b8,2,1);
        gridChess.add(b9,3,1);
        gridChess.add(b10,4,1);



        Font font = Font.font("Courier New", FontWeight.BOLD, 36);
        Font font1 = Font.font("Arial", FontWeight.BOLD, 36);

        b1.setFont(font);
        b2.setFont(font);
        b3.setFont(font);
        b4.setFont(font);
        b5.setFont(font);
        b6.setFont(font);
        b7.setFont(font);
        b8.setFont(font);
        b9.setFont(font);
        b10.setFont(font);



        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            System.out.println("A");
            Utils.playSound("thefatrat_rise_up_6-tpBXMByoK-gucZGnJW.mp3");
            if(b1.getFont()==font){
            b1.setFont(font1);
            System.out.println("if");
            }
            else if(b1.getFont()==font1){
                b1.setFont(font);
                System.out.println("else if");
            }

            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        b10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });








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
