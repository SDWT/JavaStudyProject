package Module4;

public class DeadlockExample {

    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void run() {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK_1) {
                System.out.println("Thread 1: Блокировка LOCK_1");

                sleep(100);

                System.out.println("Thread 1: ожидание LOCK_2");
                synchronized (LOCK_2) {
                    System.out.println("Thread 1: LOCK_2 был разблокирован");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK_2) {
                System.out.println("Thread 2: Блокировка LOCK_2");

                sleep(100);

                System.out.println("Thread 2: ожидание LOCK_1");
                synchronized (LOCK_1) {
                    System.out.println("Thread 2: LOCK_1 был разблокирован");
                }
            }
        });

        t1.start();
        t2.start();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }
}