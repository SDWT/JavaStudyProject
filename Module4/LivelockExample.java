package Module4;

public class LivelockExample {

    static class Resource {
        private final String name;
        private boolean inUse = false;

        public Resource(String name) {
            this.name = name;
        }

        public synchronized boolean tryUse(String threadName) {
            if (inUse)
                return false;

            inUse = true;
            System.out.println(threadName + " захватил " + name);
            return true;
        }

        public synchronized void release(String threadName) {
            inUse = false;
            System.out.println(threadName + " освободил " + name);
        }

        public String getName() {
            return name;
        }
    }

    public static void run() {
        Resource r1 = new Resource("Resource 1");
        Resource r2 = new Resource("Resource 2");

        Thread t1 = new Thread(() -> work(r1, r2, "Thread 1"));
        Thread t2 = new Thread(() -> work(r2, r1, "Thread 2"));

        t1.start();
        t2.start();
    }

    private static void work(Resource first, Resource second, String name) {
        while (true) {
            if (first.tryUse(name)) {

                M4Utils.sleep(100);

                if (second.tryUse(name)) {
                    System.out.println(name + " сделал работу!");
                    return;
                }

                System.out.println(name + " уступает, чтобы другой мог попробовать");

                first.release(name);

                M4Utils.sleep(100);
            }
        }
    }
}