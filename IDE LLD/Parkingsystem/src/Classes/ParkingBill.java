package Classes;

import ParkingSpot.Spot;

public class ParkingBill {
    Spot spot;
    ParkingLevel level;
    public ParkingBill(Spot spot, ParkingLevel level) {
        this.spot = spot;
        this.level = level;
    }
    public int payAmount(int dur) {
        return 40 * (dur) * level.getLevelNumber();
    }
    public Spot getSpot() {
        return spot;
    }
    public ParkingLevel getLevel() {
        return level;
    }
}
