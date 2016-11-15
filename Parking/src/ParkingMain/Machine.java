package ParkingMain;

public abstract class Machine {
    protected static final String DEFAULT_NUMBER = "DEFAULT NUMBER";
    protected static final String DEFAULT_OWNER = "DEFAULT OWNER";
    protected String number;
    protected String owner;
    protected abstract void go ();
    protected abstract void crash ();

    public Machine() {
        this.number = DEFAULT_NUMBER;
        this.owner = DEFAULT_OWNER;
    }

    public Machine(String number, String owner) {
        if (number.length() > 0) {
            this.number = number;
        }
        else {
            this.number = DEFAULT_NUMBER;
        }
        if (owner.length() > 0) {
            this.owner = owner;
        }
        else {
            this.owner = DEFAULT_OWNER;
        }
    }

    protected String getNumber() {
        return number;
    }

    protected String getOwner() {
        return owner;
    }
}
