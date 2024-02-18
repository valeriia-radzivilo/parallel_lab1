package features.task5;


import features.task5.additional.SymbolPrinter;
import features.task5.additional.SymbolPrinterOne;

public class MainTask5 {
    public static void main(String[] args) {
        try {
            partOne();

            // NOTE: DO NOT UNCOMMENT BOTH OF THEM - THE RESULT WILL BE INCORRECT
            // partTwo();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void partOne() throws InterruptedException {
        System.out.println("Part 1: \n");
        Thread thread1 = new Thread(new SymbolPrinterOne('-'));
        Thread thread2 = new Thread(new SymbolPrinterOne('|'));

        thread1.start();
        thread2.start();

        System.out.println("\n");

    }

    private static void partTwo() throws InterruptedException {
        System.out.println("Part 2: \n\n");
        Object lock = new Object();

        Thread thread1 = new Thread(new SymbolPrinter(lock, '-'));
        Thread thread2 = new Thread(new SymbolPrinter(lock, '|'));

        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();
    }
}