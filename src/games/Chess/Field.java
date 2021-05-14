package games.Chess;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Field extends Rectangle {

    //Variables
    int x, y;

    int figure;

    //Objects

    String color1 = "#1874CD";
    String color2 = "#ADD8E6";

    int color;

    Button b;
    Label label;

    public Field(int x, int y)
    {
        super(0,0,50,50);

        this.x = x;
        this.y = y;

    }



    //Getter Setter

    public void setColor(int i)
    {
        if(i == 1)
        {
            color = 1;
            //setStyle("-fx-background-color: #1874CD");
            setFill(Color.AQUA);
        }
        else
        {
            color = 2;
            //setStyle("-fx-background-color: #ADD8E6");
            setFill(Color.DARKBLUE);
        }
    }


    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
        label = new Label();
        label.setText(""+figure);
    }

    public Field getField()
    {
        return this;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public int getColor() {
        return color;
    }

    public Label getLabel() {
        return label;
    }
}
