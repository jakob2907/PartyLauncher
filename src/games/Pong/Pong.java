package games.Pong;

import com.sun.javafx.scene.control.skin.ColorPalette;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import states.BasicGame;
import states.StateHandler;

import javax.swing.plaf.ColorChooserUI;
import javax.swing.plaf.basic.BasicColorChooserUI;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;

public class Pong extends BasicGame {

    Scene s;

    Paddle p1,p2;
    Ball b;

    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    int selectedBackground; //Omen 1 , Pokemon 2, Galaxy 3


    ColorPicker color;
    Label score;
    Label enter;
    Label pause;
    int score1;
    int score2;
    AnimationTimer at;
    private BitSet keyboardBitSet = new BitSet();
    private int scored = 0;
    boolean paused;

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

        paused = false;

        enter=new Label("Press 'ENTER' to start the game");
        enter.setLayoutX(140);
        enter.setLayoutY(500);
        enter.setFont(new Font("Arial",40));
        enter.setTextFill((Color.color(0,1,1,1)));
        enter.setVisible(false);



        final ToggleGroup group = new ToggleGroup();


        rb1 = new RadioButton("Valorant Omen");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb1.setVisible(false);
        Image omen = new javafx.scene.image.Image("https://cdn-images.win.gg/resize/w/800/h/600/format/jpg/type/progressive/fit/cover/path/news/f72f78a365657d56853b6867fb37dc3c/4fbd6bb80baa58395883812709490023/original.jpg");
        ImageView omen1 = new ImageView(omen);
        omen1.setFitHeight(60);
        omen1.setFitWidth(80);
        rb1.setGraphic(omen1);
        rb1.setLayoutX(50);
        rb1.setLayoutY(100);

        rb2 = new RadioButton("Pokémon");
        rb2.setToggleGroup(group);
        rb2.setVisible(false);
        Image pokemon = new javafx.scene.image.Image("https://i.pinimg.com/originals/a8/31/c3/a831c36e0f33ac6b408caa1f3959b403.jpg");
        ImageView pokemon1=new ImageView(pokemon);
        pokemon1.setFitHeight(60);
        pokemon1.setFitWidth(80);
        rb2.setGraphic(pokemon1);
        rb2.setLayoutX(50);
        rb2.setLayoutY(300);

        rb3 = new RadioButton("Galaxy");
        rb3.setToggleGroup(group);
        rb3.setVisible(false);
        Image galaxy = new javafx.scene.image.Image("https://i.pinimg.com/originals/e9/39/0e/e9390e770d385757c028ac40f21e73a5.jpg");
        ImageView galaxy1=new ImageView(galaxy);
        galaxy1.setFitHeight(60);
        galaxy1.setFitWidth(80);
        rb3.setGraphic(galaxy1);
        rb3.setLayoutX(50);
        rb3.setLayoutY(500);

       /* color = new ColorPicker();
        color.getStyleClass().add("button");
        color.getCustomColors();
        color.setLayoutX(400);
        color.setLayoutY(300);
        color.setVisible(true);*/

        pause = new Label("Game Paused");
        pause.setLayoutY(100);
        pause.setLayoutX(600/2-pause.getWidth()/2);
        pause.setVisible(false);
        pause.setFont(new Font("Arial",40));

        p.getChildren().addAll(p1,p2,b,score,enter,pause,rb1,rb2,rb3);
        s = new Scene(p, 800, 600);
        s.getStylesheets().add("cssFiles/Background.css");
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ESCAPE)
                {
                    showStopGUI();
                }
            }
        });

        checkEingabe();

        at = new AnimationTimer() {
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
        s.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);

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

        for(int i = 0; i < eingaben.size(); i++) {
            if (paused==false) {

                if (eingaben.get(i).equals("W")) {
                    if (p1.getY() > 0) {
                        p1.setY(p1.getY() - 14);
                    }
                }
                if (eingaben.get(i).equals("S")) {
                    if (p1.getY() < 600 - 52) {
                        p1.setY(p1.getY() + 14);
                    }
                }
                if (eingaben.get(i).equals("UP")) {
                    if (p2.getY() > 0) {
                        p2.setY(p2.getY() - 14);
                    }
                }
                if (eingaben.get(i).equals("DOWN")) {
                    if (p2.getY() < 600 - 52) {
                        p2.setY(p2.getY() + 14);
                    }
                }
                if (eingaben.get(i).equals("ENTER") && scored != 0) {
                    if (scored == 1) {
                        enter.setVisible(false);
                        serve(2);
                    } else {
                        enter.setVisible(false);
                        serve(1);
                    }

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
                scored = 0;
            }
            else
            {
                b.setYspeed((Math.random()*3+1)*-1);
                scored = 0;
            }
        }
        else
        {
            b.setXspeed(((Math.random()*3)+1)*(-1));
            if(Math.random() == 1)
            {
                b.setYspeed(Math.random()*3+1);
                scored = 0;
            }
            else
            {
                b.setYspeed((Math.random()*3+1)*-1);
                scored = 0;
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

    private void showStopGUI() {
        if(paused==true){
            at.stop();
            pause.setVisible(true);
            rb1.setVisible(true);
            rb2.setVisible(true);
            rb3.setVisible(true);
            paused = false;
        }
        else{
            at.start();
            pause.setVisible(false);
            rb1.setVisible(false);
            rb2.setVisible(false);
            rb3.setVisible(false);
            paused = true;
        }
    }

    public Scene getScene()
    {
        return s;
    }
}

