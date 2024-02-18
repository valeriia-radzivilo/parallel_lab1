package features.task5.additional;

public class SymbolPrinter implements Runnable {
    private final Object lock;
    private final char symbol;

    public SymbolPrinter(Object lock, char symbol) {
        this.lock = lock;
        this.symbol = symbol;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                System.out.print(symbol);
                lock.notify(); // Notifying another thread that it can make its part

                try {
                    if (i < 99) {
                        lock.wait(); // Stop current thread to wait for another
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}