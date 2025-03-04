public abstract class TrafficState {
    TrafficLight light;
    TrafficState(TrafficLight light) {
        this.light = light;
    }

    public abstract void operation();
}
