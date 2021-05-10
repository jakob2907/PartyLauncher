package games.Pong;

import javafx.scene.shape.Rectangle;

public class Ball extends Rectangle {

    double xspeed, yspeed;

    public Ball(double x, double y, double width)
    {
        super(x,y,width,width);

        xspeed = Math.random()*7-3;
        yspeed = Math.random()*7-3;
    }

    public double getXspeed() {
        return xspeed;
    }

    public void setXspeed(double xspeed) {
        this.xspeed = xspeed;
    }

    public double getYspeed() {
        return yspeed;
    }

    public void setYspeed(double yspeed) {
        this.yspeed = yspeed;
    }
}
