package ParkingMain;

public class Parking {
    private static final String DEFAULT_NAME = "DEFAULT PARKING NAME";
    private static final int DEFAULT_CAPASITY = 10;
    private String name;
    private int capasity;
    private boolean[] usedStall;
    private Machine[] arr;

    public boolean isUsedStall(int num) {
        if (num >= 0 && num < capasity) {
            return usedStall[num];
        }
        else {
            return true;
        }
    }

    public boolean addMachine(Machine m, int num) {
        if (! this.isUsedStall(num)) {
            arr[num] = m;
            usedStall[num] = true;
            System.out.println(whoOnThisStale(num) + " номер " + m.getNumber() + " владельца " + m.getOwner() + " поставлена на парковочное место номер " + num);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean delMachine(int num) {
        if (this.isUsedStall(num)) {
            System.out.println(whoOnThisStale(num) + " номер " + this.arr[num].getNumber() + " владельца " + this.arr[num].getOwner() + " удалена с парковочного места номер " + num);
            usedStall[num] = false;
            this.arr[num].go();
            return true;
        }
        else {
            return false;
        }
    }

    public void closeParking() {
        System.out.println("!!!       ВСЕ ВОН      !!!!");
        for (int i = 0; i <this.capasity; i++) {
            if (isUsedStall(i)) {
                this.delMachine(i);
            }
        }
    }

    public Parking() {
        this(DEFAULT_NAME, DEFAULT_CAPASITY);
    }

    public Parking(String name, int capasity) {
        this.name = name;
        this.capasity = capasity;
        this.arr = new Machine[capasity];
        this.usedStall = new boolean[capasity];
        for (int i = 0; i < capasity; i++) {
            this.usedStall[i] = false;
        }
    }

    public String whoOnThisStale(int num) {
        String temp = "";
        if (usedStall[num]) {
            switch (this.arr[num].getClass().getName()) {
                case "ParkingMain.Bicycle" : temp =  "Велосипед"; break;
                case "ParkingMain.Motorbike" : temp = "Мотоцикл"; break;
                case "ParkingMain.Jeep" : temp = "Джип"; break;
                default: temp = "????????????";
            }
        }
        else {
            temp = "место свободно";
        }
        return temp;
    }

    public String getName() {
        return name;
    }

    public int getCapasity() {
        return capasity;
    }

}
