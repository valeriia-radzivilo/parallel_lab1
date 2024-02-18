package features.task3;

import common.bounce.BounceFrame;

import javax.swing.*;

public class MainTask3 {
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame(100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name =" + Thread.currentThread().getName());
    }
}