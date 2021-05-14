package games.Chess;

import javafx.animation.AnimationTimer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Rectangle;

public class Chess {

    Scene scene;
    GridPane grid;

    Field[][] field = new Field[8][8];

    public Chess()
    {
        grid = new GridPane();

        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(100));

        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getColumnConstraints().add(new ColumnConstraints(200));

        grid.setVgap(0);
        grid.setHgap(0);

        grid.setPadding(new Insets(0,0,0,0));

        fillFieldsRectangle();
        placeFigures();
        fillFieldsColor();


        //grid.setGridLinesVisible(true);

        scene = new Scene(grid, 800,600);
        scene.getStylesheets().add("cssFiles/chess.css");

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
    }

    private void placeFigures()
    {
        //1 = King, 2 = Queen, 3 = rook, 4 = pawn, 5 = bishop, 6 = knight -> weiß
        //schwarz number + 10 -> 11 = King, 12 = Queen

        //black

        field[0][0].setFigure(3);
        grid.add(field[0][0].getLabel(), 1,1);
        GridPane.setHalignment(field[0][0].getLabel(), HPos.CENTER);

        field[0][1].setFigure(5);
        grid.add(field[0][1].getLabel(), 2,1);
        GridPane.setHalignment(field[0][1].getLabel(), HPos.CENTER);

        field[0][2].setFigure(4);
        grid.add(field[0][2].getLabel(), 3,1);
        GridPane.setHalignment(field[0][2].getLabel(), HPos.CENTER);

        field[0][3].setFigure(2);
        grid.add(field[0][3].getLabel(), 4,1);
        GridPane.setHalignment(field[0][3].getLabel(), HPos.CENTER);

        field[0][4].setFigure(1);
        grid.add(field[0][4].getLabel(), 5,1);
        GridPane.setHalignment(field[0][4].getLabel(), HPos.CENTER);

        field[0][5].setFigure(4);
        grid.add(field[0][5].getLabel(), 6,1);
        GridPane.setHalignment(field[0][5].getLabel(), HPos.CENTER);

        field[0][6].setFigure(5);
        grid.add(field[0][6].getLabel(), 7,1);
        GridPane.setHalignment(field[0][6].getLabel(), HPos.CENTER);

        field[0][7].setFigure(3);
        grid.add(field[0][7].getLabel(), 8,1);
        GridPane.setHalignment(field[0][7].getLabel(), HPos.CENTER);

        for(int i = 0; i < 8; i++)
        {
            field[1][i].setFigure(6);
            grid.add(field[1][i].getLabel(), i+1,2);
            GridPane.setHalignment(field[1][i].getLabel(), HPos.CENTER);
        }

        field[7][0].setFigure(13);
        grid.add(field[7][0].getLabel(), 1,8);
        GridPane.setHalignment(field[7][0].getLabel(), HPos.CENTER);

        field[7][1].setFigure(15);
        grid.add(field[7][1].getLabel(), 2,8);
        GridPane.setHalignment(field[7][1].getLabel(), HPos.CENTER);

        field[7][2].setFigure(14);
        grid.add(field[7][2].getLabel(), 3,8);
        GridPane.setHalignment(field[7][2].getLabel(), HPos.CENTER);

        field[7][3].setFigure(12);
        grid.add(field[7][3].getLabel(), 4,8);
        GridPane.setHalignment(field[7][3].getLabel(), HPos.CENTER);

        field[7][4].setFigure(11);
        grid.add(field[7][4].getLabel(), 5,8);
        GridPane.setHalignment(field[7][4].getLabel(), HPos.CENTER);

        field[7][5].setFigure(14);
        grid.add(field[7][5].getLabel(), 6,8);
        GridPane.setHalignment(field[7][5].getLabel(), HPos.CENTER);

        field[7][6].setFigure(15);
        grid.add(field[7][6].getLabel(), 7,8);
        GridPane.setHalignment(field[7][6].getLabel(), HPos.CENTER);

        field[7][7].setFigure(13);
        grid.add(field[7][7].getLabel(), 8,8);
        GridPane.setHalignment(field[7][7].getLabel(), HPos.CENTER);

        for(int i = 0; i < 8; i++)
        {
            field[6][i].setFigure(16);
            grid.add(field[6][i].getLabel(), i+1,7);
            GridPane.setHalignment(field[6][i].getLabel(), HPos.CENTER);
        }

        printFieldFigures();
    }

    private void fillFieldsRectangle() {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Field f = new Field(i,j);
                field[i][j] = f;
                f.setFigure(0);
                grid.add(f, i+1,j+1);
            }
        }

        printFieldColors();
    }



    private void fillFieldsColor() {

        int weiss = 1;
        int schwarz = 2;

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                //weißes Feld mit Nummer 0,2,4,6,8 -> 1.Reihe, 3.Reihe, 5.Reihe, 7.Reihe
                if(i%2 == 0 && j%2 == 0)
                {
                    field[i][j].setColor(weiss);
                }
                //weißes Feld mit Nummer 1,3,5,7 -> 2.Reihe, 4.Reihe, 6.Reihe, 8.Reihe
                else if(i%2 != 0 && j%2 != 0)
                {
                    field[i][j].setColor(weiss);
                }
                else
                {
                    field[i][j].setColor(schwarz);
                }
            }
        }

        field[0][0].setColor(1);
        field[0][2].setColor(1);
        field[0][4].setColor(1);
        field[0][6].setColor(1);

    }

    //print Methoden

    private void printFieldColors() {
        System.out.println("Colors:");
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(j == 7)
                {
                    System.out.println(field[i][j].getColor());
                }
                else
                {
                    System.out.print(field[i][j].getColor() + " ");
                }
            }
        }
    }


    private void printFieldFigures()
    {
        System.out.println("Figuren:");
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(j == 7)
                {
                    System.out.println(field[i][j].getFigure());
                }
                else if(i < 6)
                {
                    System.out.print(field[i][j].getFigure() + "  ");
                }
                else
                {
                    System.out.print(field[i][j].getFigure() + " ");
                }
            }
        }
    }


    //Getter Setter

    public Scene getScene()
    {
        return scene;
    }

    //TestMain

    public static void main(String[] args) {

    }

}
