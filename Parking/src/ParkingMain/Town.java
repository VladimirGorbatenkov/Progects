package ParkingMain;

public class Town {
    public static void main(String[] args) {
        Machine b1 = new Bicycle("bicycle_1", "Вася");
        Machine b2 = new Bicycle("bicycle_2", "Коля");
        Machine m1 = new Motorbike("motorbike_1", "Vasya");
        Machine m2 = new Motorbike("motorbike_1", "Kolya");
        Machine j1 = new Jeep("Jeep_1", "Петя");
        Machine j2 = new Jeep("Jeep_2", "Маша");
        Machine b3 = new Bicycle();
        Machine m3 = new Motorbike();
        Machine j3 = new Jeep("", "");

        Parking park1 = new Parking("Центральная", 10);

        park1.addMachine(b1, 0);
        park1.addMachine(b2, 2);
        park1.addMachine(m1, 5);
        park1.addMachine(m2, 9);
        park1.addMachine(j1, 7);
        park1.addMachine(j2, 3);
        park1.addMachine(b3, 1);
        park1.addMachine(m3, 4);
        park1.addMachine(j3, 8);

        b2.crash();
        j1.crash();
        m2.crash();

        park1.delMachine(3);
        park1.delMachine(9);
        park1.delMachine(2);

        park1.closeParking();

    }
}
