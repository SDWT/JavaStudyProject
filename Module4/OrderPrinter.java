package Module4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderPrinter {

    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition[] conditions;

    private int current = 0;

    public OrderPrinter(int n) {
        this.n = n;
        this.conditions = new Condition[n];

        for (int i = 0; i < n; i++)
            conditions[i] = lock.newCondition();
    }

    public void start() {
        for (int i = 0; i < n; i++) {
            final int id = i;
            new Thread(() -> runThread(id)).start();
        }
    }

    private void runThread(int id) {
        while (true) {
            lock.lock();
            try {
                while (current != id) {
                    conditions[id].await();
                }

                System.out.print((id + 1) + " ");

                current = (id + 1) % n;

                conditions[current].signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } finally {
                lock.unlock();
            }
        }
    }
}