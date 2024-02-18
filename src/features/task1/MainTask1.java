package features.task1;

import common.bounce.BounceFrame;

import javax.swing.*;

public class MainTask1 {
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame(false, false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name =" + Thread.currentThread().getName());
    }
}