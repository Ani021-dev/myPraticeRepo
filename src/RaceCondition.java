package src;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        ReadModifyWrite obj = new ReadModifyWrite();

        Thread t1 = new Thread(obj, "Thread 1");
        Thread t2 = new Thread(obj, "Thread 2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(obj.getCount());

        CheckAndAct obj1 = new CheckAndAct();

        Thread payal = new Thread(obj1, "payal");
        Thread ramesh = new Thread(obj1, "ramesh");

        payal.start();
        ramesh.start();
    }
}

class ReadModifyWrite implements Runnable {
    int shread = 0;

    @Override
    public void run() {
        synchronized (this){
            for (int i = 0; i < 1000000; i++)
                shread++;
        }
    }

    public int getCount() {
        return shread;
    }
}

class CheckAndAct implements Runnable {
    int balance = 100;

    @Override
    public void run() {
        System.out.println("Thread is waiting for widhrawal " + Thread.currentThread().getName());
        synchronized (this){
            if(balance >= 100){
                System.out.println("Widhrawal Successful by: " + Thread.currentThread().getName());
                balance -= 50;
            }else{
                System.out.println("Widhrwal Unsuccessful by: " + Thread.currentThread().getName());
                return;
            }

            System.out.println("Widhrawal Successful and final balance is: " + balance);
        }
    }
}
