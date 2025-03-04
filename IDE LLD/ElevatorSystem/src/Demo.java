public class Demo {
    public static void main(String[] arg) {
        Elevator elevator = new Elevator(1);

        Controller controller = new Controller(3);

        controller.requestElevator(5, 10);
        controller.requestElevator(3, 7);
        controller.requestElevator(8, 2);
        controller.requestElevator(1, 9);

//        Thread threads = new Thread(() -> {
//            elevator.addNewRequest(new Request(10), 3000);
//            elevator.addNewRequest(new Request(2), 1000);
//            elevator.addNewRequest(new Request(11), 30000);
//            elevator.addNewRequest(new Request(9), 2000);
//            elevator.addNewRequest(new Request(10), 2000);
//        });
//        threads.start();
//        new Thread(elevator::run).start();

    }
}
