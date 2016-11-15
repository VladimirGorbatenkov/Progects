package ParkingMain;


public class Jeep extends Machine {
    private static final String DEFAULT_NUMBER = "DEFAULT JEEP NUMBER";
    private static final String DEFAULT_OWNER = "DEFAULT JEEP OWNER";

    public Jeep() {
        this.number = DEFAULT_NUMBER;
        this.owner =  DEFAULT_OWNER;
    }

    public Jeep(String number, String owner) {
        super(number, owner);
        if (number.length() == 0) {
            this.number = DEFAULT_NUMBER;
        }
        if (owner.length() == 0) {
            this.owner = DEFAULT_OWNER;
        }

    }

    public void go () {
        System.out.println("Джип номер " + this.number + " у владельца " + this.owner + " поехал");
    }

    public void crash () {
        System.out.println("Джип номер " + this.number + " у владельца " + this.owner + " сломался");
    }

}
