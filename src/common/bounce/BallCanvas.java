package common.bounce;

import common.objects.Ball;
import common.objects.Pocket;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallCanvas extends JPanel {

    private final ArrayList<Ball> balls = new ArrayList<>();
    private final ArrayList<Pocket> pockets = new ArrayList<>();

    public void add(Ball ball) {
        balls.add(ball);
    }

    public void add(Pocket pocket) {
        pockets.add(pocket);
    }

    public void remove(Ball ball) {
        balls.remove(ball);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawBalls(g2);
        drawPockets(g2);

    }

    private void drawBalls(Graphics2D g2) {
        try {
            for (Ball ball : balls) {
                checkBallInPocket(ball);
                if (!ball.getIsInPocket()) {
                    ball.draw(g2);
                }
            }
        } catch (Exception ignored) {
        }
    }

    private void checkBallInPocket(Ball ball) {
        for (Pocket pocket : pockets) {
            if (ball.isInPocket(pocket)) {
                onBallInPocket(ball, pocket);
                break;
            }
        }
    }

    private void onBallInPocket(Ball ball, Pocket pocket) {
        ball.setInPocket(true);
        remove(ball);
        pocket.addScore();
        this.repaint();
    }

    private void drawPockets(Graphics2D g2) {
        for (Pocket pocket : pockets) {
            pocket.draw(g2);
        }
    }
}