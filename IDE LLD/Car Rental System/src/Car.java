public class Car {
    String model;
    String license;
    Calendar calendar;
    int rentPerDay;
    Car(String model, String license, int rentPerDay) {
        this.model = model;
        this.license = license;
        this.rentPerDay = rentPerDay;
        calendar = new Calendar();
    }

    public String getCarModel() {
        return this.model;
    }

    public String getLicense() {
        return this.license;
    }

    public int getRentPerDay() {
        return this.rentPerDay;
    }

    public Calendar getCalendar() {
        return this.calendar;
    }
}
