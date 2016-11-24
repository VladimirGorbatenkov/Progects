import factories.CarServiceFactory;
import factories.HumanServiceFactory;
import model.Car;
import model.Human;
import service.CarService;
import service.HumanService;

public class Program {
    public static void main(String[] args) {
        Human marsel = new Human.Builder()
                .id(0)
                .name("Marsel")
                .age(22)
                .city("Kazan")
                .build();
        Human nastya = new Human.Builder()
                .id(0)
                .name("Nastya")
                .age(20)
                .city("Moskow")
                .build();
        Human ilya = new Human.Builder()
                .id(0)
                .name("Ilya")
                .age(25)
                .city("Samara")
                .build();

        HumanService humanService = HumanServiceFactory.getInstance().getHumanService();
        CarService carService = CarServiceFactory.getInstance().getCarService();
/*
        humanService.add(marsel);
        humanService.add(nastya);
        humanService.add(ilya);
*/
        for (Human currentHuman : humanService.findAll()) {
            System.out.println(currentHuman);
        }
        if (humanService.isRegistered("Kolya")) {
            System.out.println("Kolya is Registered");
        } else {
            System.out.println("Kolya not registered");
        }

//        System.out.println("3-й пользователь:   " + humanService.get(3));

//        humanService.remove(3);
//        humanService.add(new Human(0, "Masha", 22, "Kirov"));

        humanService.update(new Human(3, "Masha", 18, "Kirov"));

        System.out.println("2-й пользователь:   " + humanService.get(2));

        for (Human currentHuman : humanService.findAll()) {
            System.out.println(currentHuman);
        }
/*        humanService.remove(1);
        for (Human currentHuman : humanService.findAll()) {
            System.out.println(currentHuman);
        }*/

        for (Car currentCar : carService.findAll()) {
            System.out.println(currentCar);
        }

//        carService.remove(3);
//        carService.add(new Car(0,"Kalina",23456,2));
        for (Car currentCar : carService.findAll()) {
            System.out.println(currentCar);
        }


    }
}
