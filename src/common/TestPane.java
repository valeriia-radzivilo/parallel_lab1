//package common;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class TestPane extends JPanel {
//
//    private final ArrayList<Pocket> circles = new ArrayList<>(10);
//    private final Dimension size;
//
//    public TestPane(int width, int height) {
//        Random random = new Random();
//
//
//        circles.add(new Pocket(Color.PINK, Pocket.getRadius() / 2, 0));
//        circles.add(new Pocket(Color.RED, (int) (width - Pocket.getRadius() * 2.5), 0));
//        circles.add(new Pocket(Color.GREEN, Pocket.getRadius() / 2, (int) (height - Pocket.getRadius() * 3.5)));
//        circles.add(new Pocket(Color.YELLOW, (int) (width - Pocket.getRadius() * 2.5), (int) (height - Pocket.getRadius() * 3.5)));
//
//
//        size = new Dimension(width, height);
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return size;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Pocket circle : circles) {
//            Graphics2D g2d = (Graphics2D) g.create();
//            circle.paint(g2d);
//            g2d.dispose();
//        }
//    }
//
//}