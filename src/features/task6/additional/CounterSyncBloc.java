package features.task6.additional;

public class CounterSyncBloc extends Counter {

    private final Object lock = new Object();
    private int count = 0;

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public void decrement() {
        synchronized (lock) {
            count--;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }


}