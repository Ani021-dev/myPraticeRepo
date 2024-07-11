package src.DesignPattern;

//Strategy Design Pattern
public class PaymentGatewayStrategy {
    public static void main(String[] args) {
        Payment paid = new Payment(1576, "ABC colony, ABC, ABC", new UPI());
        System.out.println(paid.pay());

        Payment payment = new Payment(6575, "XYZ colony, XYZ, XYZ", new Card());
        System.out.println(payment.pay());
    }
}

interface PaymentStrategy {
    String pay(int amount, String billingAdd);
}

class UPI implements PaymentStrategy {

    @Override
    public String pay(int amount, String billingAdd) {
        return new String("Amount " + amount + " is paid via UPI and billing address is " + billingAdd);
    }
}

class Card implements PaymentStrategy {
    @Override
    public String pay(int amount, String billingAdd) {
        return new String("Anount " + amount + " is paid via Card and billing address is " + billingAdd);
    }
}

class Payment {
    int amount;
    String billingAdd;
    PaymentStrategy paymentStrategy;

    Payment(int amount, String billingAdd, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.billingAdd = billingAdd;
        this.paymentStrategy = paymentStrategy;
    }

    public String pay() {
        return paymentStrategy.pay(amount, billingAdd);
    }
}
