import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Renter {
    private String location;
    private String name;
    List<Car> cars;
    List<Reservation> reservations;

    Renter(String location, String name) {
        this.location = location;
        this.name = name;
        this.cars = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCar() {
        return this.cars;
    }

    public String getName(){
        return this.name;
    }
    public String getLocation() {
        return this.location;
    }

    public List<Car> getAvailableCars(int start, int end) {
        List<Car> list = new ArrayList<>();

        for(Car car : cars) {
            System.out.print("Car: " + car.getCarModel() + " -- ");
            if(car.getCalendar().isAvailable(start, end)) {
                list.add(car);
            }
        }
        return list;
    }

    public List<Reservation> getReservations() {
        return this.reservations;
    }

    public void addReservation(Reservation reserv) {
        reservations.add(reserv);
    }
}
