public class GreenState extends TrafficState{
    GreenState(TrafficLight light) {
        super(light);
    }

    public void operation() {
        int duration = (int) light.getGreenSignalDuration() / 1000;
        System.out.println("GREEN SIGNAL STARTED FOR" + duration + " SECS AT TRAFFIC WITH ID: " + light.getId());
        while(duration > 0) {
            duration--;
            System.out.println("GREEN SIGNAL TIME LEFT: " + duration + " SECS");
        }
        System.out.println("GREEN SIGNAL ENDED AT TRAFFIC WITH ID: " + light.getId());
        light.setState(new YellowState(light));
    }
}
