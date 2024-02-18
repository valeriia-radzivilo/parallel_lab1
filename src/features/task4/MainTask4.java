package features.task4;

import common.bounce.BounceFrame;

import javax.swing.*;

public class MainTask4 {
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame(true, true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name =" + Thread.currentThread().getName());
    }
}