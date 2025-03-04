package ParkingSystem;
import ParkingSystem.ParkingSpot.*;

public class Bill {
	Spot spot;
	Bill(Spot spot, ParkingLevel level) {
		this.spot = spot;
		this.level = level;
	}

	public int payAmount(int dur) {
		return 40 * (dur) * level.getLevelNumber;
	}

	public Spot getSpot() {
		return spot;
	}

	public ParkingLevel getLevel() {
		return level;
	}
}