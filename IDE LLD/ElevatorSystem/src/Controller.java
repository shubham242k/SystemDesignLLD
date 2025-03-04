import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Elevator> elevators;

    Controller(int n) {
        elevators = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            Elevator elevator = new Elevator(i+1);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = findOptimalElevator(sourceFloor, destinationFloor);
        optimalElevator.addNewRequest(new Request(sourceFloor), 1000);
        optimalElevator.addNewRequest(new Request(destinationFloor), 5000);
    }

    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor) {
        Direction direction = destinationFloor - sourceFloor > 0 ? Direction.UP : Direction.DOWN;
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            System.out.println(elevator.no + " waesdvav " + elevator.getCurrentFloor());
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }

        System.out.println(optimalElevator.no + " choosen one " + optimalElevator.getCurrentFloor());

        return optimalElevator;
    }
}
