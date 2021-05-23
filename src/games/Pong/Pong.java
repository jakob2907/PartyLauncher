package games.Pong;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import states.BasicGame;
import states.StateHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.BitSet;

public class Pong extends BasicGame {

    Scene s;

    Paddle p1,p2;
    Ball b;

    Label score;
    Label enter;
    int score1;
    int score2;

    private BitSet keyboardBitSet = new BitSet();
    private int scored = 0;

    public Pong(StateHandler stateHandler)
    {
        super(stateHandler);

        Pane p = new Pane();

        p1 = new Paddle(10, 8, 20, 50);
        p2 = new Paddle(800-30, 600-58, 20, 50);
        b = new Ball(800/2-5, 600/2-5, 10);
        score1 = 0;
        score2 = 0;
        String string = Integer.toString(score1)+"   :   "+Integer.toString(score2);
        score = new Label(string);
        score.setFont(new Font("Arial", 60));
        score.setTextFill((Color.color(0,1,1,0.6)));
        score.setLayoutX(307);
        score.setLayoutY(200);


        enter=new Label("Press 'ENTER' to start the game");
        enter.setLayoutX(140);
        enter.setLayoutY(500);
        enter.setFont(new Font("Arial",40));
        enter.setTextFill((Color.color(0,1,1,1)));
        enter.setVisible(false);
        p.getChildren().addAll(p1,p2,b,score,enter);
        s = new Scene(p, 800, 600);
        s.getStylesheets().add("cssFiles/Background.css");

        checkEingabe();

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                checkCollision(p1,b);
                checkCollision(p2,b);

                move();
            }
        };

        at.start();
    }

    private void checkWalls() {

        if(b.getY() <= 0 || b.getY() >= 600 - 10)
        {
            b.setYspeed(b.getYspeed() * -1);
        }

        if(b.getX() <= 0)
        {
            p2.setScore(p2.getScore() + 1);
            b.setXspeed(0);
            b.setYspeed(0);
            b.setX(800/2-5);
            b.setY(600/2-5);
            scored = 2;
            score1++;
            enter.setVisible(true);
        }

        if(b.getX() >= 790)
        {
            p1.setScore(p1.getScore() + 1);
            b.setXspeed(0);
            b.setYspeed(0);
            b.setX(800/2-5);
            b.setY(600/2-5);
            scored = 1;
            score2++;
            enter.setVisible(true);
        }
        score.setText(Integer.toString(score1)+"   :   "+Integer.toString(score2));
    }

    public void move()
    {
        checkWalls();

        b.setX(b.getX() + b.getXspeed());
        b.setY(b.getY() + b.getYspeed());
    }

    private void checkEingabe()
    {
        s.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        s.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);

    }

    private EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {

            keyboardBitSet.set(event.getCode().ordinal(), true);

            checkCombination();
        }
    };

    private EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {

            keyboardBitSet.set(event.getCode().ordinal(), false);

            checkCombination();
        }
    };

    private void checkCombination() {

        ArrayList<String> eingaben = new ArrayList<>();

        int count = 0;
        for(KeyCode keyCode : KeyCode.values())
        {
            if(keyboardBitSet.get(keyCode.ordinal())){
                eingaben.add(keyCode.toString());
            }
            count++;
        }

        for(int i = 0; i < eingaben.size(); i++)
        {

            if(eingaben.get(i).equals("W"))
            {
                if(p1.getY() > 0) {
                    p1.setY(p1.getY() - 14);
                }
            }
            if(eingaben.get(i).equals("S"))
            {
                if(p1.getY() < 600 - 52)
                {
                    p1.setY(p1.getY() + 14);
                }
            }
            if(eingaben.get(i).equals("UP"))
            {
                if(p2.getY() > 0) {
                    p2.setY(p2.getY() - 14);
                }
            }
            if(eingaben.get(i).equals("DOWN"))
            {
                if(p2.getY() < 600-52) {
                    p2.setY(p2.getY() + 14);
                }
            }
            if(eingaben.get(i).equals("ENTER") && scored != 0)
            {
                if (scored == 1)
                {
                    enter.setVisible(false);
                    serve(2);
                }
                else
                {
                    enter.setVisible(false);
                    serve(1);
                }

            }
        }

    }

    private void serve(int i) {

        if(i == 1)
        {
            b.setXspeed((Math.random()*3)+1);
            if(Math.random() == 1)
            {
                b.setYspeed(Math.random()*3+1);
            }
            else
            {
                b.setYspeed((Math.random()*3+1)*-1);
            }
        }
        else
        {
            b.setXspeed(((Math.random()*3)+1)*(-1));
            if(Math.random() == 1)
            {
                b.setYspeed(Math.random()*3+1);
            }
            else
            {
                b.setYspeed((Math.random()*3+1)*-1);
            }
        }
    }

    public void checkCollision(Rectangle a, Rectangle b)
    {
        if( a.getX() < b.getX() + b.getWidth()  &&
                a.getX() + a.getWidth() > b.getX()  &&
                a.getY() < b.getY() + b.getHeight() &&
                a.getY() + a.getHeight() > b.getY())
        {
            if(a.getX()>50){
                this.b.setXspeed(this.b.getXspeed() * Math.random()*2-2.1);
                this.b.setYspeed(this.b.getYspeed() * Math.random()*2-2.1);
            }
            else {
                this.b.setXspeed(this.b.getXspeed() * Math.random()*2-2.1 *-1);
                this.b.setYspeed(this.b.getYspeed() * Math.random()*2-2.1);
            }
        }


    }

    public Scene getScene()
    {
        return s;
    }
}
