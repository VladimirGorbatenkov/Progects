package ParkingMain;

public class Bicycle extends Machine{
    private static final String DEFAULT_NUMBER = "DEFAULT BICYCLE NUMBER";
    private static final String DEFAULT_OWNER = "DEFAULT BICYCLE OWNER";

    public Bicycle (String number, String owner) {
        super(number, owner);
        if (number.length() == 0) {
            this.number = DEFAULT_NUMBER;
        }
        if (owner.length() == 0) {
            this.owner = DEFAULT_OWNER;
        }
    }

    public Bicycle () {
        this.number = DEFAULT_NUMBER;
        this.owner =  DEFAULT_OWNER;
    }

    public void go () {
        System.out.println("Велосипед номер " + this.number + " у владельца " + this.owner + " поехал");
    }

    public void crash () {
        System.out.println("Велосипед номер " + this.number + " у владельца " + this.owner + " сломался");
    }
}
