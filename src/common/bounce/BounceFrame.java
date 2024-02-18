package common.bounce;

import common.Ball;
import common.BallThread;
import common.Pocket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BounceFrame extends JFrame {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    final Boolean usePockets;
    private final BallCanvas canvas;

    private final ArrayList<Pocket> circles = new ArrayList<>(10);

    public BounceFrame(Boolean usePockets) {
        this.usePockets = usePockets;

        initField();

        this.canvas = new BallCanvas();
        System.out.println("In Frame Thread name = " + Thread.currentThread().getName());
        Container content = this.getContentPane();


        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);


        content.add(this.canvas, BorderLayout.CENTER);


        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball b = new Ball(canvas);
                canvas.add(b);
                BallThread thread = new BallThread(b);
                thread.start();
                System.out.println("Thread name = " + thread.getName());
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);

        if (usePockets) {
            addPockets();
        }
    }


    private void initField() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.setResizable(false);

    }

    private void addPockets() {


        canvas.add(new Pocket(Color.PINK, Pocket.getRadius(), Pocket.getRadius()));
        canvas.add(new Pocket(Color.RED, WIDTH - Pocket.getRadius() * 2, Pocket.getRadius()));
        canvas.add(new Pocket(Color.GREEN, Pocket.getRadius(), HEIGHT - Pocket.getRadius() * 4));
        canvas.add(new Pocket(Color.YELLOW, WIDTH - Pocket.getRadius() * 2, HEIGHT - Pocket.getRadius() * 4));

    }

}