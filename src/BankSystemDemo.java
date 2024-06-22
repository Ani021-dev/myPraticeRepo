package src;

public class BankSystemDemo {
    double balance;

    BankSystemDemo(int balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        double newBalance = this.balance + amount;
        System.out.println(Thread.currentThread().getName() + " is updating new balance " + newBalance);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        balance = newBalance;
        System.out.println(Thread.currentThread().getName() + " is updating balance " + balance);
    }

    public synchronized void widraw(double amount) {
        if (this.balance > amount) {
            double newBalance = this.balance - amount;
            System.out.println(Thread.currentThread().getName() + " is widrawing new balance " + newBalance);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.balance = newBalance;
            System.out.println(Thread.currentThread().getName() + " is widrawing balance " + balance);
        }
    }

    public static void main(String[] args) {
        BankSystemDemo bkd = new BankSystemDemo(100);

        Thread deposit1 = new Thread(() -> bkd.deposit(50), "deposit1");
        Thread deposit2 = new Thread(() -> bkd.deposit(40), "deposit2");
        Thread widraw1 = new Thread(() -> bkd.widraw(50), "widraw1");
        Thread widraw2 = new Thread(() -> bkd.widraw(30), "widraw2");

        deposit1.start();
        deposit2.start();
        widraw1.start();
        widraw2.start();

        try {
            deposit1.join();
            deposit2.join();
            widraw1.join();
            widraw2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final Balance is = " + bkd.balance);
    }
}
