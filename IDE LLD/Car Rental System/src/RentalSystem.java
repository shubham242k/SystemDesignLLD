import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalSystem {
    Map<String, List<Renter>> renters;
    List<User> users;

    RentalSystem() {
        renters = new HashMap<>();
        users = new ArrayList<>();
    }

    public User addUser(String name, String driveLicense) {
        User user = new User(name, driveLicense);
        users.add(user);
        return user;
    }

    public void addRenter(Renter renter) {
        String location = renter.getLocation();
        List<Renter> list =  renters.getOrDefault(location, new ArrayList<>());
        list.add(renter);
        renters.put(location, list);

    }

    public Map<Renter, List<Car>> searchAvailableCar(String location, int start, int end) {
        List<Renter> renterList = renters.getOrDefault(location, new ArrayList<>());
        Map<Renter, List<Car>> cars = new HashMap<>();
        for(Renter renter : renterList) {
            cars.put(renter, renter.getAvailableCars(start, end));
        }
        return cars;
    }

    public List<Car> searchAvailableCarFromRenter(Renter renter, int start, int end) {
        List<Car> cars = new ArrayList<>();
        return renter.getAvailableCars(start, end);
    }

    public void createReservation(Renter renter, Car car, User user, int start, int end) {
        if(car.calendar.isAvailable(start, end)) {
            car.calendar.blockTheCalendar(start, end);
            Reservation reservation = new Reservation(car, renter, user, start, end);
            renter.addReservation(reservation);
            user.setReservation(reservation);
        }
    }

    public void cancelReservation(Reservation reservation) {
        reservation.getUser().removeReservation();
        reservation.getCar().getCalendar().unblockTheCalendar(reservation.getStart(), reservation.getEnd());
        reservation.getRenter().getReservations().remove(reservation);
    }

    public void displayAllCars() {
        for(Map.Entry<String, List<Renter>> renterList : renters.entrySet()) {
            System.out.println("------ At location: " + renterList.getKey() + " ------------------");
            for(Renter renter : renterList.getValue()) {
                System.out.println("At Renter: " + renter.getName() + " ---------------");
                for (Car car : renter.getCar()) {
                    System.out.print("For car: " + car.getCarModel() + ": ");
                    car.getCalendar().getAvailableDays();
                }
            }
        }
    }
}
