import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Car car1 = new Car("HYUNDAI", "DL1023", 100);
        Car car2 = new Car("TATA", "KL1023", 150);
        Car car3 = new Car("TOYOTA", "HR1023", 400);
        Car car4 = new Car("MARUTI", "TL1023", 50);
        Car car5 = new Car("MAHINDRA", "UP1023", 200);
        Car car6 = new Car("MG HECTOR", "AN1023", 800);

        Renter renter1 = new Renter("DELHI", "Om cars");
        Renter renter2 = new Renter("HARYANA", "Shanti cars");
        Renter renter3 = new Renter("HARYANA", "Parvati cars");
        Renter renter4 = new Renter("RAJASTHAN", "Lakshmi cars");

        renter1.addCar(car1);
        renter1.addCar(car5);
        renter2.addCar(car2);
        renter2.addCar(car6);
        renter3.addCar(car3);
        renter4.addCar(car4);

        RentalSystem system = new RentalSystem();
        system.addRenter(renter1);
        system.addRenter(renter2);
        system.addRenter(renter3);
        system.addRenter(renter4);

        User user1 = system.addUser("Shubham", "DRLI123");
        User user2 = system.addUser("Pujika", "DRLI164");

//        Map<Renter, List<Car>> Map = system.searchAvailableCar("DELHI", 4, 5);

        system.createReservation(renter1, car1, user1, 2, 5);
        car1.getCalendar().getAvailableDays();
        system.createReservation(renter1, car1, user2, 1, 1);
        car1.getCalendar().getAvailableDays();

        system.createReservation(renter1, car1, user2, 3, 4);
        car1.getCalendar().getAvailableDays();
    }

}
