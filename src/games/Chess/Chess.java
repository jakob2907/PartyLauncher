package games.Chess;

import com.sun.org.apache.xml.internal.utils.IntVector;
import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class Chess {

    //TODO Figuren auf Felder setzen, welche von Vectoren übergeben werden
    //TODO Movement mit anzeigen der möglichen Felder der Figur bei Zug
    //TODO Schach

    Scene scene;
    GridPane grid;
    Pane pane;

    int[] square = new int[64];
    Rectangle[] squareRect = new Rectangle[64];

    IntVector[] move = new IntVector[2];


    Notation notation = new Notation(this);

    Label firstmove, secondmove;

    public Chess()
    {
        //Layout

        grid = new GridPane();

        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(400));
        grid.getRowConstraints().add(new RowConstraints(100));

        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(400));
        grid.getColumnConstraints().add(new ColumnConstraints(200));

        grid.setVgap(0);
        grid.setHgap(0);

        grid.setPadding(new Insets(0,0,0,0));

        pane = new Pane();
        pane.setPadding(new Insets(0,0,0,0));

        grid.add(pane, 1,1);

        GridBoard gridBoard = new GridBoard(this);
        gridBoard.setGridLinesVisible(true);

        grid.add(gridBoard,1,1);

        VBox right = new VBox();
        firstmove = new Label("Label 1");
        secondmove = new Label("Label 2");

        GridPane.setHalignment(right, HPos.CENTER);

        right.getChildren().addAll(firstmove, secondmove);

        grid.add(right, 2, 1);



        //Variablen setzen durch Methoden

        //setImages();

        DrawBoard();
        DrawSquares(Var.startFEN);

        for (int i: square) {
            System.out.print(i);
        }

        //grid.setGridLinesVisible(true);

        class ATimer extends AnimationTimer
        {
            private volatile boolean running;

            @Override
            public void start()
            {
                super.start();
                running = true;
            }

            @Override
            public void stop()
            {
                super.stop();
                running = false;
            }

            @Override
            public void handle(long now) {
                DrawBoard();

                String s = notation.LoadPositionFromArray(square);
                DrawSquares(s);

                for (int i:square
                     ) {
                    System.out.print(square[i] + " ");

                }
                System.out.println();

            }

            public boolean isRunning() {
                return running;
            }
        }

        ATimer at = new ATimer();


        scene = new Scene(grid, 800,600);
        scene.getStylesheets().add("cssFiles/chess.css");
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER && at.isRunning())
            {
                at.stop();
            }else
            {
                at.start();
            }
        });

        at.start();


    }


    //Schachbrett zeichnen mit Rectangles


    private void DrawBoard() {


        //Funktioniert aber Implementieren mit Array -> besserer Zugriff auf einzelne Schachfelder zum Markieren

        for(int file = 0; file < 8; file++)
        {
            for(int rank = 0; rank < 8; rank++)
            {
                boolean isLightSquare = (file + rank) % 2 != 0;

                int[] squareColor = (isLightSquare) ? Var.lightColor : Var.darkColor;
                Rectangle rect = new Rectangle(file * 50, rank * 50, 50,50);
                rect.setFill(Color.rgb(squareColor[0], squareColor[1],squareColor[2]));
                squareRect[file + rank*8] = rect;
                pane.getChildren().add(rect);
            }
        }

        //Test Rectangle -> Markierung

        int file = 1;
        int rank = 1;

        Rectangle rectn = new Rectangle(file * 50, rank * 50, 50,50);
        rectn.setFill(Color.rgb(238, 99,99));
        squareRect[file + rank * 8] = rectn;
        pane.getChildren().add(squareRect[file + rank * 8]);

    }
    //IntVector
    //erster int File
    //zweiter int Rank

    public void addmove(IntVector vector)
    {
        //komplett neuer move
        if(move[0] == null && move[1] == null){

            move[0] = vector;
            firstmove.setText(move[0].elementAt(0) + " " + move[0].elementAt(1));

        }
        else
        {
            move[1] = vector;
            secondmove.setText(move[1].elementAt(0) + " " + move[1].elementAt(1));
            //move();
        }
    }

    /*
    public void move()
    {
        //Figur von Vector in move[0] nach Vector in move[1] setzen
        square[move[1].elementAt(0)+ move[1].elementAt(1)*8] = square[move[0].elementAt(0) + move[1].elementAt(1)*8];
        square[move[0].elementAt(0) + move[1].elementAt(1)*8] = 0;


        move[0] = null;
        move[1] = null;
    }

     */


    private void DrawSquares(String fen)
    {
        int heigthSquares = Var.squareHeight;

        square = notation.LoadPositionFromFEN(fen);

        double file = 0;
        double rank = 0;

        for (int i: square) {

            switch(i)
            {
                case 0:
                    break;
                case 10:
                    ImageView ivKing = new ImageView(new Image("graphics/Chess/King_white.png"));
                    ivKing.setX(file*heigthSquares);
                    ivKing.setY(rank*heigthSquares);

                    pane.getChildren().add(ivKing);
                    break;
                case 20:
                    ImageView ivQueen = new ImageView(new Image("graphics/Chess/Queen_white.png"));
                    ivQueen.setX(file*heigthSquares);
                    ivQueen.setY(rank*heigthSquares);
                    pane.getChildren().add(ivQueen);
                    break;
                case 30:
                    ImageView ivRook = new ImageView(new Image("graphics/Chess/Rook_white.png"));
                    ivRook.setX(file*heigthSquares);
                    ivRook.setY(rank*heigthSquares);
                    pane.getChildren().add(ivRook);
                    break;
                case 40:
                    ImageView ivBishop = new ImageView(new Image("graphics/PokemonPieces/Pikachu.png"));
                    ivBishop.setX(file*heigthSquares);
                    ivBishop.setY(rank*heigthSquares);
                    pane.getChildren().add(ivBishop);
                    break;
                case 50:
                    ImageView ivKnight = new ImageView(new Image("graphics/Chess/Knight_white.png"));
                    ivKnight.setX(file*heigthSquares);
                    ivKnight.setY(rank*heigthSquares);
                    pane.getChildren().add(ivKnight);
                    break;
                case 60:
                    ImageView ivPawn = new ImageView(new Image("graphics/Chess/Pawn_white.png"));
                    ivPawn.setX(file*heigthSquares);
                    ivPawn.setY(rank*heigthSquares);
                    pane.getChildren().add(ivPawn);
                    break;

                //BLACK

                case 11:
                    ImageView ivKingBlack = new ImageView(new Image("graphics/Chess/King_black.png"));
                    ivKingBlack.setX(file*heigthSquares);
                    ivKingBlack.setY(rank*heigthSquares);
                    pane.getChildren().add(ivKingBlack);
                    break;
                case 21:
                    ImageView ivQueenBlack = new ImageView(new Image("graphics/Chess/Queen_black.png"));
                    ivQueenBlack.setX(file*heigthSquares);
                    ivQueenBlack.setY(rank*heigthSquares);
                    pane.getChildren().add(ivQueenBlack);
                    break;
                case 31:
                    ImageView ivRookBlack = new ImageView(new Image("graphics/Chess/Rook_black.png"));
                    ivRookBlack.setX(file*heigthSquares);
                    ivRookBlack.setY(rank*heigthSquares);
                    pane.getChildren().add(ivRookBlack);
                    break;
                case 41:
                    ImageView ivBishopBlack = new ImageView(new Image("graphics/Chess/Bishop_black.png"));
                    ivBishopBlack.setX(file*heigthSquares);
                    ivBishopBlack.setY(rank*heigthSquares);
                    pane.getChildren().add(ivBishopBlack);
                    break;
                case 51:
                    ImageView ivKnightBlack = new ImageView(new Image("graphics/Chess/Knight_black.png"));
                    ivKnightBlack.setX(file*heigthSquares);
                    ivKnightBlack.setY(rank*heigthSquares);
                    pane.getChildren().add(ivKnightBlack);
                    break;
                case 61:
                    ImageView ivPawnBlack = new ImageView(new Image("graphics/Chess/Pawn_black.png"));
                    ivPawnBlack.setX(file*heigthSquares);
                    ivPawnBlack.setY(rank*heigthSquares);
                    pane.getChildren().add(ivPawnBlack);
                    break;

                default:
                    break;
            }

            file++;

            if(file == 8)
            {
                file = 0;
                rank++;
            }

        }
    }

    //Getter Setter

    public Scene getScene()
    {
        return scene;
    }

}
