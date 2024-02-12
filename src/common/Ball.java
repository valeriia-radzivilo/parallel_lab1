package common;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

// This is a class that represents a ball that can bounce around a graphical component
public class Ball {
    // These are the variables that store the ball's position and movement increments
    private Component canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;

    // This is the constructor that initializes the ball's position randomly
    public Ball(Component c) {
        this.canvas = c;
        if (Math.random() < 0.5)
            x = new Random().nextInt(this.canvas.getWidth());
        else
            y = new Random().nextInt(this.canvas.getHeight());
        if (Math.random() < 0.5)
            x = 0;
        else
            y = new Random().nextInt(this.canvas.getHeight());
    }

    // This is the method that draws the ball on the screen
    public void draw(Graphics2D g2) {
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    // This is the method that updates the ball's position and makes it bounce off the edges of the screen
    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x=0; dx=-dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x=this.canvas.getWidth() - XSIZE; dx=-dx;
        }
        if (y<0) {
            y=0; dy=-dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y=this.canvas.getHeight() - YSIZE; dy=-dy;
        }
        this.canvas.repaint();
    }
}