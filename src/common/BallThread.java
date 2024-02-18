package common;

import common.objects.Ball;

public class BallThread extends Thread {
    private final Ball b;
    private final BallThread previousBallThread;

    public BallThread(Ball ball, BallThread previousThread) {
        b = ball;
        previousBallThread = previousThread;
    }


    @Override
    public void run() {
        try {
            if (this.previousBallThread != null) {
                this.previousBallThread.join();
            }

            for (int i = 1; i < 10000; i++) {
                b.move();

                if (b.getIsInPocket()) {
                    // Thread.currentThread().interrupt();
                    break;
                }

                System.out.println("Thread name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted exception");
        }
    }
}