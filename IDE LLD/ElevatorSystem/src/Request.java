public class Request {
    int destinationFloor;
    Direction user;
    Request(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    Request(int destinationFloor, Direction user) {
        this.destinationFloor = destinationFloor;
        this.user = user;
    }

    public int getDestinationFloor() {
        return this.destinationFloor;
    }

    public Direction getDirection() {
        return this.user;
    }
}
