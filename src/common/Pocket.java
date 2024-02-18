package common;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pocket {
    private static final int RADIUS = 25;
    private final int x;
    private final int y;
    private final Ellipse2D shape;

    private final Color color;

    public Pocket(Color color, int x, int y) {
        this.x = x;
        this.y = y;


        this.shape = new Ellipse2D.Double(x, y, RADIUS * 2, RADIUS * 2);
        this.color = color;
    }

    public static int getRadius() {
        return RADIUS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return shape.getBounds();
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(this.color);
        g2d.fill(shape);
    }

    public void draw(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fill(new Ellipse2D.Double(x - RADIUS, y - RADIUS, RADIUS * 2, RADIUS * 2));
    }
}