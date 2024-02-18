package common.bounce;

import common.Ball;
import common.Pocket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class BallCanvas extends JPanel {

    private final ArrayList<Ball> balls = new ArrayList<>();
    private final ArrayList<Pocket> pockets = new ArrayList<>();


    public void add(Ball b) {
        this.balls.add(b);
    }

    public void add(Pocket p) {
        this.pockets.add(p);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (Ball b : balls) {

            b.draw(g2);
        }
        for (Pocket p : pockets) {

            p.draw(g2);
        }

        //this.setBackground(Color.green);
    }
}