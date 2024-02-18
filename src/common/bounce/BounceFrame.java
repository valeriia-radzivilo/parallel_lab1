package common.bounce;

import common.BallThread;
import common.objects.Ball;
import common.objects.Pocket;

import javax.swing.*;
import java.awt.*;

public class BounceFrame extends JFrame {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    private final BallCanvas canvas;
    private boolean usePockets = false;
    private boolean usePriority = false;
    private int ballsCount = 1;
    private boolean addedPriorityBall = false;

    public BounceFrame(boolean usePockets) {
        this.canvas = new BallCanvas();
        this.usePockets = usePockets;
        initializeUI();
        createAndSetupUI();
    }

    public BounceFrame(int ballsCount) {
        this.canvas = new BallCanvas();
        this.usePriority = true;
        this.ballsCount = ballsCount;
        initializeUI();
        createAndSetupUI();
    }

    private void initializeUI() {
        setSize(WIDTH, HEIGHT);
        setTitle("Bounce program");
        setResizable(false);
    }

    private void createAndSetupUI() {

        Container content = getContentPane();
        JPanel buttonPanel = createButtonPanel();

        content.add(this.canvas, BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.SOUTH);

        addPocketsIfRequired();
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(e -> startBallThread(usePriority));
        buttonStop.addActionListener(e -> System.exit(0));

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        return buttonPanel;
    }

    private void startBallThread(boolean priorityTest) {
        if (priorityTest) {
            for (int i = 0; i < ballsCount; i++) {
                addRegularBall();
            }

            if (!addedPriorityBall) {
                addRedBall();
            }
        } else {
            addRegularBall();
        }
    }

    private void addRedBall() {
        Ball redBall = new Ball(canvas, Color.RED, false);
        canvas.add(redBall);
        BallThread redThread = new BallThread(redBall);
        redThread.setPriority(Thread.MAX_PRIORITY);
        redThread.start();
        System.out.println("Red thread name = " + redThread.getName());
        addedPriorityBall = true;
    }

    private void addRegularBall() {
        Ball ball = new Ball(canvas, null, !this.usePriority);
        canvas.add(ball);
        BallThread thread = new BallThread(ball);
        thread.start();
        System.out.println("Thread name = " + thread.getName());
    }

    private void addPocketsIfRequired() {
        if (usePockets) {
            addPockets();
        }
    }

    private void addPockets() {
        int radius = Pocket.getRadius();
        canvas.add(new Pocket(Color.DARK_GRAY, radius, radius * 2));
        canvas.add(new Pocket(Color.RED, WIDTH - 2 * radius, radius * 2));
        canvas.add(new Pocket(Color.GREEN, radius, HEIGHT - 4 * radius));
        canvas.add(new Pocket(Color.BLUE, WIDTH - 2 * radius, HEIGHT - 4 * radius));
    }
}