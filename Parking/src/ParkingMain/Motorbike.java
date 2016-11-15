package ParkingMain;


public class Motorbike extends Machine {
    private static final String DEFAULT_NUMBER = "DEFAULT MOTORBIKE NUMBER";
    private static final String DEFAULT_OWNER = "DEFAULT MOTORBIKE OWNER";

    public Motorbike() {
        this.number = DEFAULT_NUMBER;
        this.owner =  DEFAULT_OWNER;
    }

    public Motorbike(String number, String owner) {
        super(number, owner);
        if (number.length() == 0) {
            this.number = DEFAULT_NUMBER;
        }
        if (owner.length() == 0) {
            this.owner = DEFAULT_OWNER;
        }

    }

    public void go () {
        System.out.println("Мотоцикл номер " + this.number + " у владельца " + this.owner + " поехал");
    }

    public void crash () {
        System.out.println("Мотоцикл номер " + this.number + " у владельца " + this.owner + " сломался");
    }

}
