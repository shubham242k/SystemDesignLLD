import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator {
    int no;
    Direction direction;

    HashSet<Request> pendingUpRequests;
    HashSet<Request> pendingDownRequests;
    PriorityQueue<Request> minHeap;
    PriorityQueue<Request> maxHeap;
    int currentFloor;

    Elevator(int no) {
        this.no = no;
        this.direction = Direction.UP;
        this.currentFloor = 1;
        pendingUpRequests = new HashSet<>();
        pendingDownRequests = new HashSet<>();
        minHeap = new PriorityQueue<>((a,b) -> a.getDestinationFloor() - b.getDestinationFloor());
        maxHeap = new PriorityQueue<>((a,b) -> b.getDestinationFloor() - a.getDestinationFloor());
    }

    public void run() {
        while(true) {
            while(true) {
                processRequest();
            }
        }
    }

    public synchronized void addNewRequest(Request request, int time) {
        System.out.println(request.getDestinationFloor());

        if(request.getDestinationFloor() > currentFloor) {
            if(direction == Direction.UP || direction == Direction.IDLE) {
                minHeap.add(request);
            } else {
                pendingDownRequests.add(request);
            }
        } else if(request.getDestinationFloor() <= currentFloor) {
            if(direction == Direction.DOWN || direction == Direction.IDLE) {
                maxHeap.add(request);
            } else {
                pendingUpRequests.add(request);
            }
        }
        System.out.println(maxHeap.size() + " " + minHeap.size() + "  " + pendingDownRequests + " " + pendingUpRequests+ " " +currentFloor);
        try {
            Thread.sleep(time);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processRequest() {
        if(direction == Direction.UP || direction == Direction.IDLE) {
            processUpRequest();
        }
        if(direction == Direction.DOWN) {
            processDownRequest();
        }
    }

    private void processUpRequest() {
        while(!minHeap.isEmpty()) {
            Request request = minHeap.poll();
            int cur = currentFloor;
            while(cur < request.getDestinationFloor()) {
                System.out.println("Elevator #" + no + " moving UPWARDS. Current Floor: " + cur);
                cur++;
                this.currentFloor++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Elevator #" + no + " reached destination floor: " + request.getDestinationFloor());
            this.currentFloor = request.getDestinationFloor();
        }
        maxHeap.addAll(pendingUpRequests);
        pendingUpRequests.clear();
        if(!maxHeap.isEmpty()) {
            direction = Direction.DOWN;
        } else {
            direction = Direction.IDLE;
        }
    }

    private void processDownRequest() {
        while(!maxHeap.isEmpty()) {

            Request request = maxHeap.poll();
            int cur = currentFloor;
            while(cur >= request.getDestinationFloor()) {
                System.out.println("Elevator #" + no + " moving DOWNWARDS. Current Floor: " + cur);
                cur--;
                this.currentFloor--;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Elevator #" + no + " reached destination floor: " + request.getDestinationFloor());
            this.currentFloor = request.getDestinationFloor();
        }
        minHeap.addAll(pendingDownRequests);
        pendingDownRequests.clear();
        if(!minHeap.isEmpty()) {
            direction = Direction.UP;
        } else {
            direction = Direction.IDLE;
        }
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }
}
