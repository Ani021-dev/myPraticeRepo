package src;

public class DeadLockDemo {
    public static void main(String[] args) {
        Object key1 = new Object();
        Object key2 = new Object();

        Thread k1 = new Thread(() -> {
            synchronized (key1) {
                System.out.println("Thread k1 has acquired the key 1");
                try {
                    System.out.println("Thread k1 is sleeping for 3 secs");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("K1 woke up");
                synchronized (key2) {
                    System.out.println("Thread k1 has acquired the Key 2");
                }
            }
        });

        Thread k2 = new Thread(() -> {
            synchronized (key1) {
                System.out.println("Thread k2 has acquired the key 1");
                try {
                    System.out.println("Thread k2 is sleeping for 3 secs");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("K2 woke up");

                synchronized (key2) {
                    System.out.println("Thread k2 has acquired the Key 2");
                }
            }
        });

        k1.start();
        k2.start();
    }
}
