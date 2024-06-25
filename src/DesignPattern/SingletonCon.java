package src.DesignPattern;

public class SingletonCon {
    private static SingletonCon singleton = null;

    private SingletonCon() {
        System.out.println("Instance of the class created....");
    }

    public static SingletonCon getInstance() {
        if(singleton == null){
            singleton = new SingletonCon();
        }
        System.out.println("Instance of the class accessed");
        return singleton;
    }

    public static void main(String[] args) {
        SingletonCon singleton1 = SingletonCon.getInstance();
        SingletonCon singleton2 = SingletonCon.getInstance();

    }
}
