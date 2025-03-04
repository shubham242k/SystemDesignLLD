public class Reservation {
    Car car;
    User user;
    int start;
    int end;
    int price;
    Renter renter;

    Reservation(Car car, Renter renter, User user, int start, int end) {
        this.car = car;
        this.user = user;
        this.start = start;
        this.end = end;
        this.renter = renter;
        setPrice();
    }

    private void setPrice() {
        if(start == end) {
            price = car.getRentPerDay();
        } else {
            price = car.getRentPerDay() * (end - start);
        }
    }

    public User getUser() {
        return this.user;
    }

    public Car getCar() {
        return this.car;
    }

    public int getStart() {
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }

    public int getPrice() {
        return this.price;
    }

    public Renter getRenter() {
        return this.renter;
    }
}
