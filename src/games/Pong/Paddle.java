package games.Pong;

import javafx.scene.shape.Rectangle;

public class Paddle extends Rectangle {

    int score;

    public Paddle(double x, double y, double width, double height)
    {
        super(x,y,width,height);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
