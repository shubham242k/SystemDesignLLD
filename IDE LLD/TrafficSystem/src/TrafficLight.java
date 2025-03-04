public class TrafficLight {
    int id;
    Signal currentSignal;
    TrafficState state;
    long greenSignalDuration;

    TrafficLight(int id) {
        this.id = id;
        currentSignal = Signal.RED;
        state = new RedState(this);
        greenSignalDuration = 1000;
    }

    public void setState(TrafficState state) {
        this.state = state;
    }

    public void changeSignal(Signal signal) {
        this.currentSignal = signal;
    }

    public TrafficState getState() {
        return this.state;
    }

    public Signal getCurrentSignal() {
        return this.currentSignal;
    }

    public void setGreenSignalDuration(long milli) {
        this.greenSignalDuration = milli;
    }

    public long getGreenSignalDuration() {
        return this.greenSignalDuration;
    }

    public int getId() {
        return this.id;
    }
}
