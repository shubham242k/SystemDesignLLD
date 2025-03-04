public class YellowState extends TrafficState{
    YellowState(TrafficLight light) {
        super(light);
    }

    public void operation() {
        int duration = 2;
        System.out.println("YELLOW SIGNAL STARTED FOR" + duration + " SECS AT TRAFFIC WITH ID: " + light.getId());
        while(duration > 0) {
            duration--;
            System.out.println("YELLOW SIGNAL TIME LEFT: " + duration + " SECS");
        }
        System.out.println("YELLOW SIGNAL ENDED AT TRAFFIC WITH ID: " + light.getId());
        light.setState(new YellowState(light));
    }
}
