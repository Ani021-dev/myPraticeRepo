package src.DesignPattern;

public class FactoryDesign {
    public static void main(String[] args) {
        WeaponFactory factory1 = new PistolFactory();
        WeaponFactory factory2 = new ShortGunFactory();
        WeaponFactory factory3 = new SniperFactory();

        Weapon pistol = factory1.makeWeapon("100%", "100KM", "100m/s", "9MM");
        Weapon shortGun = factory2.makeWeapon("200%", "200KM", "200m/s", "12MM");
        Weapon sniper = factory3.makeWeapon("300%", "1000KM", "1300m/s", "15MM");

        System.out.println(pistol.toString());
        System.out.println(shortGun.toString());
        System.out.println(sniper.toString());
    }
}

interface Weapon {
    String toString();
}

class Pistol implements Weapon {
    private final String damage;
    private final String range;
    private final String speed;
    private final String amunationType;

    public Pistol(String damage, String range, String speed, String ammunationType) {
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.amunationType = ammunationType;
    }

    @Override
    public String toString() {
        return "Pistol{" +
                "damage='" + damage + '\'' +
                ", range='" + range + '\'' +
                ", speed='" + speed + '\'' +
                ", amunationType='" + amunationType + '\'' +
                '}';
    }
}

class ShortGun implements Weapon {
    private final String damage;
    private final String range;
    private final String speed;
    private final String amunationType;

    ShortGun(String damage, String range, String speed, String ammunationType) {
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.amunationType = ammunationType;
    }

    @Override
    public String toString() {
        return "ShortGun{" +
                "damage='" + damage + '\'' +
                ", range='" + range + '\'' +
                ", speed='" + speed + '\'' +
                ", amunationType='" + amunationType + '\'' +
                '}';
    }
}

class Sniper implements Weapon {
    private final String damage;
    private final String range;
    private final String speed;
    private final String amunationType;

    Sniper(String damage, String range, String speed, String ammunationType) {
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.amunationType = ammunationType;
    }

    @Override
    public String toString() {
        return "Sniper{" +
                "damage='" + damage + '\'' +
                ", range='" + range + '\'' +
                ", speed='" + speed + '\'' +
                ", amunationType='" + amunationType + '\'' +
                '}';
    }
}

interface WeaponFactory {
    Weapon makeWeapon(String damage, String range, String speed, String amunationType);
}

class PistolFactory implements WeaponFactory {

    @Override
    public Pistol makeWeapon(String damage, String range, String speed, String amunationType) {
        return new Pistol(damage, range, speed, amunationType);
    }
}

class ShortGunFactory implements WeaponFactory {

    @Override
    public ShortGun makeWeapon(String damage, String range, String speed, String ammunationType) {
        return new ShortGun(damage, range, speed, ammunationType);
    }
}

class SniperFactory implements WeaponFactory {

    @Override
    public Sniper makeWeapon(String damage, String range, String speed, String ammunationType) {
        return new Sniper(damage, range, speed, ammunationType);
    }
}