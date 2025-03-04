public class User {
    String name;
    String drivingLicense;
    Reservation reservation;

    User(String name, String drivingLicense) {
        this.name = name;
        this.drivingLicense = drivingLicense;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void removeReservation() {
        this.reservation = null;
    }

    public String getName() {
        return this.name;
    }

    public String getDrivingLicense() {
        return this.drivingLicense;
    }

    public Reservation getReservation() {
        return this.reservation;
    }

    public boolean modifyReservation() {
        return false;
    }
}
