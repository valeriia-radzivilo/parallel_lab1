package features.task6;

import features.task6.additional.Counter;
import features.task6.additional.CounterBlock;
import features.task6.additional.CounterSyncBloc;

import java.util.Objects;
import java.util.Scanner;

public class MainTask6 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter type of counter ( 1 - sync method, 2 - sync bloc, 3 - object blocking) : ");

        String userResponse = myObj.nextLine();
        Counter counter = getCounter(userResponse);

        startThreads(counter);
    }

    private static Counter getCounter(String userResponse) {
        if (Objects.equals(userResponse, "1")) {
            return new Counter();
        }
        if (Objects.equals(userResponse, "2")) {
            return new CounterSyncBloc();
        }
        if (Objects.equals(userResponse, "3")) {
            return new CounterBlock();
        }
        throw new IllegalArgumentException("Wrong input");

    }

    private static void startThreads(Counter counter) {


        Thread incrementThread = incrementThread(counter);

        Thread decrementThread = decrementThread(counter);

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
            System.out.println("Final Counter Value: " + counter.getCount());
        } catch (InterruptedException e) {

        }
    }

    private static Thread incrementThread(Counter counter) {
        return new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
            System.out.println("Value increment: " + counter.getCount());
        });
    }

    private static Thread decrementThread(Counter counter) {
        return new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
            }

            System.out.println("Value decrement: " + counter.getCount());
        });
    }

}