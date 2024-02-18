package features.task2;

import common.bounce.BounceFrame;

import javax.swing.*;

public class MainTask2 {
    public static void main(String[] args) {
        BounceFrame frame = new BounceFrame(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        System.out.println("Thread name =" + Thread.currentThread().getName());
    }
}