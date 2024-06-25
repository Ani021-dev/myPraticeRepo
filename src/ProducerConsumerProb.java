package src;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class ProducerConsumerProb {
    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 5;

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.size() == maxSize) {
                        try {
                            System.out.println("Buffer is full, so waiting .....");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    buffer.add(i);
                    System.out.println("Produced " + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    buffer.notifyAll();
                }
            }
        }, "producer");

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer is empty, so waiting .....");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    int val = buffer.remove();
                    System.out.println("Consumed " + val);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    buffer.notifyAll();
                }
            }
        }, "consumer");

        producer.start();
        consumer.start();
    }
}


//Using Blovking Queue

class ProducerConsumerUsingBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.put(i); //put will block the buffer if full
                    System.out.println("Produced " + i);
                    Thread.sleep((long) (Math.random() * 5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "producer");

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    int val = buffer.take(); //take is block if the buffer is empty
                    System.out.println("Consumed " + val);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "consumer");

        producerThread.start();
        consumerThread.start();
    }
}

class ProducerConsumerMultiple {
    public static void main(String[] args) {
        OwnBlockingQueue<Integer> queue = new OwnBlockingQueue<>(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            service.submit(new Producer(queue, i));
        }
        for (int i = 1; i <= 2; i++) {
            service.submit(new Consumer(queue, i));
        }

        service.shutdown();
    }
}

class Producer implements Runnable {
    private final OwnBlockingQueue<Integer> queue;
    private final int producerId;

    Producer(OwnBlockingQueue<Integer> queue, int producerId) {
        this.queue = queue;
        this.producerId = producerId;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                int val = producer(producerId) + i;
                queue.put(val);
                System.out.println("Producer " + producerId + " produced " + val);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int producer(int i) {
        return i * 100;
    }
}

class Consumer implements Runnable {
    private final OwnBlockingQueue<Integer> queue;
    private final int consumerId;

    Consumer(OwnBlockingQueue<Integer> queue, int consumerId) {
        this.queue = queue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            while (queue.size() != 0) {
                int val = queue.take();
                System.out.println("Consumer " + consumerId + " consumed " + val);
                Thread.sleep(5000);
            }
        } catch (
                InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class OwnBlockingQueue<T> {
    private final Queue<T> queue;
    private final int maxSize;

    public OwnBlockingQueue(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void put(T t) throws InterruptedException {
        if (queue.size() == maxSize) {
            wait();
        }
        queue.add(t);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        if (queue.isEmpty()) {
            wait();
        }
        T item = queue.poll();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }
}